### 简易spring-idc-02 工厂方式

#### 参考来源 https://github.com/code4craft/tiny-spring

包装bean的元信息

```java
public class BeanDefinition {
    private Object bean;

    private Class beanClass;

    private String beanClassName;

    public BeanDefinition() {

    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;

    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
           //加载类的信息
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

定义BeanFactory工厂两个职能：获取bean和注册bean

```java
public interface BeanFactory {

    //获取bean
    Object getBean(String beanName);
    //注册bean
    void registerBeanDefinition(String bean, BeanDefinition definition);

}
```

定义AbstractBeanFactory 实现BeanFactory的方法

```java
public abstract class AbstractBeanFactory implements BeanFactory {
    //存放bean的元信息
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 放到子类通过反射进行实例化
     * @param definition
     * @return
     */
    abstract Object doCreateBean(BeanDefinition definition);
}
```

定义AutowrieCapableBeanFactory可装配的bean，意思就是那些bean准备好了可以进行实例化了，放入到map容器中。

```java
public class AutowrieCapableBeanFactory extends AbstractBeanFactory {
    //通过反射进行实例化bean
    @Override
    Object doCreateBean(BeanDefinition definition) {
        try {
            Object bean = definition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

### Test

```java
   @Test
    public void test(){
        //1、初始化beanFactory
        BeanFactory beanFactory=new AutowrieCapableBeanFactory();
        //2、注入bean
        BeanDefinition beanDefinition=new BeanDefinition();

        //3、set全类名
        beanDefinition.setBeanClassName("com.bbz.ioc.step02.HelloWordService");

        //注入bean
        beanFactory.registerBeanDefinition("helloWordService",beanDefinition);

        //获取bean
        HelloWordService helloWordService = (HelloWordService)beanFactory.getBean("helloWordService");
        //调用方法
        helloWordService.hello();
    }

```