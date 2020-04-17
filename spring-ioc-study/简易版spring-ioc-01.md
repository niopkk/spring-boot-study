### 简易 spring-ioc-01

`tiny-spring`是为了学习Spring的而开发的，可以认为是一个Spring的精简版。Spring的代码很多，层次复杂，阅读起来费劲。我尝试从使用功能的角度出发，参考Spring的实现，一步一步构建，最终完成一个精简版的Spring。有人把程序员与画家做比较，画家有门基本功叫临摹，tiny-spring可以算是一个程序的临摹版本-从自己的需求出发，进行程序设计，同时对著名项目进行参考。

#### 参考来源 https://github.com/code4craft/tiny-spring

 定义存放bean元信息的BeanDefinition

```java
public class BeanDefinition {

    public Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
```

在定义一个存放BeanDefinition的类

```java
public class BeanFactory {
    //保存在map对象中
    private final Map<String, BeanDefinition> bdMap = new ConcurrentHashMap<>();

    //根据key获取 BeanDefinition的对象
    public Object getBean(String beanName) {
        return bdMap.get(beanName).getBean();
    }
    //将一个BeanDefinition放入map对象
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        bdMap.put(name, beanDefinition);
    }
}
```

#### Test

```java
 @Test
    public void test01() {


        //实例化BeanFactory 工厂
        BeanFactory beanFactory = new BeanFactory();


        //将自定义的bean 放入到BeanDefinition类中
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWordService());

        //注入到容器当中
        beanFactory.registerBeanDefinition("helloWordService", beanDefinition);

        //ioc容器中获取bean实例
        HelloWordService helloWordService = (HelloWordService) beanFactory.getBean("helloWordService");

        //调用方法
        helloWordService.hello();
    }
```

```java
public class HelloWordService {


    public void hello() {
        System.out.println("hello word");
    }
}
```



