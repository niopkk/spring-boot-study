package com.bbz.spring.formework.context;

import com.bbz.spring.formework.annotation.Autowired;
import com.bbz.spring.formework.annotation.Controller;
import com.bbz.spring.formework.annotation.Service;
import com.bbz.spring.formework.beans.BeanWrapper;
import com.bbz.spring.formework.beans.config.BeanDefinition;
import com.bbz.spring.formework.beans.config.BeanPostProcessor;
import com.bbz.spring.formework.beans.support.BeandDefinitionReader;
import com.bbz.spring.formework.beans.support.DefaultListableBeanFactory;
import com.bbz.spring.formework.core.BeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext extends DefaultListableBeanFactory implements BeanFactory {

    private Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    private Map<String, BeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    private String[] configLocations;

    private BeandDefinitionReader reader;

    public ApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void refresh() throws Exception {

        //定位配置文件
        reader = new BeandDefinitionReader(this.configLocations);

        //加载配置文件，扫描相关的类，将它们封装成beanDefinition
        List<BeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

        //注册，将配置信息放到ioc容器里面
        doRegisterBeanDefinition(beanDefinitions);

        //把不是延时加载的类，提前初始化
        doAutowrited();
    }

    private void doAutowrited() {
        beanDefinitionMap.forEach(((beanName, beanDefinition) -> {
            if (!beanDefinition.isLazyinit()) {
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    private void doRegisterBeanDefinition(List<BeanDefinition> beanDefinitions) throws Exception {

        for (BeanDefinition beanDefinition : beanDefinitions) {
            if (beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + "is exists!!");
            }
            //Test->test  ,beanDefinition
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }

    /**
     * 首字母小写的类名
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String beanName) throws Exception {
        //beanName->test
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        try {
            BeanPostProcessor beanPostProcessor = new BeanPostProcessor();

            Object instantiate = instantiateBean(beanDefinition);
            if (null == instantiate) {
                return null;
            }
            //初始化前调用
            beanPostProcessor.postProcessorBeforeInitialization(instantiate, beanName);

            BeanWrapper beanWrapper = new BeanWrapper(instantiate);

            this.factoryBeanInstanceCache.put(beanName, beanWrapper);

            //初始化后调用
            beanPostProcessor.postProcessorAfterInitialization(instantiate, beanName);

            populateBean(beanName, instantiate);

            return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void populateBean(String beanName, Object instantiate) {
        Class<?> clazz = instantiate.getClass();
        if (!(clazz.isAnnotationPresent(Controller.class) || clazz.isAnnotationPresent(Service.class))) {
            return;
        }
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Autowired.class)) {
                continue;
            }
            Autowired autowired = field.getAnnotation(Autowired.class);
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)) {
                //获取到全限定类名->com.bbz.Test
                autowiredBeanName = field.getType().getName();
            } else {
                //Autowired 自定义名称 解决方式
                BeanWrapper beanWrapper = this.factoryBeanInstanceCache.get(field.getType().getName());
                this.factoryBeanInstanceCache.put(autowiredBeanName, beanWrapper);
            }
            field.setAccessible(true);
            try {
                field.set(instantiate, this.factoryBeanInstanceCache.get(autowiredBeanName).getWrappedInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private Object instantiateBean(BeanDefinition beanDefinition) {
        Object instance = null;
        //全限定类名->com.bbz.Test
        String className = beanDefinition.getBeanClassName();
        try {
            if (this.factoryBeanObjectCache.containsKey(className)) {
                instance = this.factoryBeanObjectCache.get(className);
            } else {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                //小写类名(getFactoryBeanName())->test
                this.factoryBeanObjectCache.put(beanDefinition.getFactoryBeanName(), instance);
            }
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getBean(Class<?> beanClass) throws Exception {
        return getBean(beanClass.getName());
    }

    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[beanDefinitionMap.keySet().size()]);
    }

    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    public Properties getConfig() {
        return reader.getConfig();
    }
}
