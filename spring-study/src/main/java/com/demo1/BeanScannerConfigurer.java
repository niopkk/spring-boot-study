package com.demo1;


import com.demo1.annotation.CustomizeComponent;
import com.demo1.proxy.InterfaceProxy;
import com.demo1.proxy.MyMethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BeanScannerConfigurer implements BeanFactoryPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {


        MyScanner scanner = new MyScanner((BeanDefinitionRegistry) beanFactory);
        scanner.setResourceLoader(this.applicationContext);
        scanner.scan("com.demo1.scan");
    }

    public final static class MyScanner extends ClassPathBeanDefinitionScanner {


        public MyScanner(BeanDefinitionRegistry registry) {
            super(registry);
        }

        @Override
        protected void registerDefaultFilters() {
            this.addIncludeFilter(new AnnotationTypeFilter(CustomizeComponent.class));
        }

        @Override
        protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
            Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
            for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
                GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();

                definition.getPropertyValues().add("innerClassName", definition.getBeanClassName());
                definition.setBeanClass(FactoryBeanTest.class);

            }

            return beanDefinitionHolders;
        }

        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
            return super.isCandidateComponent(beanDefinition) &&
                    beanDefinition
                            .getMetadata()
                            .hasAnnotation(CustomizeComponent.class.getName());
        }
    }

    public static class FactoryBeanTest<T> implements InitializingBean, FactoryBean<T> {


        private String innerClassName;

        public void setInnerClassName(String innerClassName) {
            this.innerClassName = innerClassName;
        }

        @Override
        public T getObject() throws Exception {

            Class<?> innerClass = Class.forName(innerClassName);

            if (innerClass.isInterface()) {
                return (T) InterfaceProxy.newInstance(innerClass);
            } else {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(innerClass);
                enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
                enhancer.setCallback(new MyMethodInterceptor());

                return (T) enhancer.create();
            }
        }

        @Override
        public boolean isSingleton() {
            return true;
        }

        @Override
        public Class<?> getObjectType() {

            try {
                return Class.forName(innerClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void afterPropertiesSet() throws Exception {

        }
    }


}
