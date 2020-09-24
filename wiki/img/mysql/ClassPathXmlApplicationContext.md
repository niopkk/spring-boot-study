1. spring读取的xml或者注解配置类里面的数据信息如何存储。
2. 对象是如何实例化的。
3. 对象属性是如何进行赋值的。

下面我们直接从代码中解析

##### ClassPathXmlApplicationContext

流程启动

```java
public static void main(String[] args) {
    ApplicationContext applicationContext=new
            ClassPathXmlApplicationContext("classpath:applicationContext.xml");
  
    Person person = (Person) applicationContext.getBean("person");
    System.out.println(person);
}
```

```java
public ClassPathXmlApplicationContext(
      String[] configLocations, boolean refresh, @Nullable ApplicationContext parent)
      throws BeansException {
   super(parent);
   //将读取的文件路径写入父类AbstractRefreshableConfigApplicationContext的
   //@Nullable
	 //private String[] configLocations;
   //这个时候文件的路径已经在内存中，后续将xml转为BeanDefinition都将是从这里来的数据
   setConfigLocations(configLocations);
   if (refresh) {
      //刷新容器，spring一系列的操作都在此方法执行
      refresh();
   }
}
```

#####AbstractApplicationContext

通过refresh();方法进入AbstractApplicationContext抽象类,它是refresh()方法的实现继承ConfigurableApplicationContext接口

```java
//AbstractApplicationContext 抽象类
public abstract class AbstractApplicationContext extends DefaultResourceLoader
		implements ConfigurableApplicationContext {
  @Override
	public void refresh() throws BeansException, IllegalStateException {
		synchronized (this.startupShutdownMonitor) {
			// Prepare this context for refreshing.
      //进入跟踪查看一下，大概了解，准备spring刷新前的一些准备
      //this.closed.set(false);设置上下文关闭标志
		  //this.active.set(true);设置spring启动事件,开启活跃状态，
      //initPropertySources();初使属性源信息,方法为空，可以自己实现
      //getEnvironment().validateRequiredProperties()验证必要属性
      //this.earlyApplicationEvents = new LinkedHashSet<>();收集早期发布的ApplicationEvent
			prepareRefresh();

			// Tell the subclass to refresh the internal bean factory.
      //重点
      //spring在这一步将xml转为流，最后解析为BeanDefinition
      //还有将解析的BeanDefinition放入到DefaultListableBeanFactory类中的
      //存放beanName ->BeanDefinition的对应关系
      //private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256)
      //存放beanName的名字
      //private volatile List<String> beanDefinitionNames = new ArrayList<>(256);
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
			prepareBeanFactory(beanFactory);

			try {
				// Allows post-processing of the bean factory in context subclasses.
				postProcessBeanFactory(beanFactory);

				// Invoke factory processors registered as beans in the context.
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
				initMessageSource();

				// Initialize event multicaster for this context.
				initApplicationEventMulticaster();

				// Initialize other special beans in specific context subclasses.
				onRefresh();

				// Check for listener beans and register them.
				registerListeners();

				// Instantiate all remaining (non-lazy-init) singletons.
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
				finishRefresh();
			}

			catch (BeansException ex) {
				if (logger.isWarnEnabled()) {
					logger.warn("Exception encountered during context initialization - " +
							"cancelling refresh attempt: " + ex);
				}

				// Destroy already created singletons to avoid dangling resources.
				destroyBeans();

				// Reset 'active' flag.
				cancelRefresh(ex);

				// Propagate exception to caller.
				throw ex;
			}

			finally {
				// Reset common introspection caches in Spring's core, since we
				// might not ever need metadata for singleton beans anymore...
				resetCommonCaches();
			}
		}
	}
}
//ConfigurableApplicationContext
public interface ConfigurableApplicationContext extends ApplicationContext, Lifecycle, Closeable {
     void refresh() throws BeansException, IllegalStateException;
}
```

```java
protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
  
   //销毁清理BeanFactory,重新创建一个BeanFactory
   //抽象方法在子类 
   //如过是xml配置在AbstractRefreshableApplicationContext中实现
   //java注解在GenericApplicationContext子类实现
   refreshBeanFactory();
   return getBeanFactory();
}
```

##### AbstractRefreshableApplicationContext

```java
@Override
protected final void refreshBeanFactory() throws BeansException {
   if (hasBeanFactory()) {
      destroyBeans();
      closeBeanFactory();
   }
   try {
     //初始化bean的容器
      DefaultListableBeanFactory beanFactory = createBeanFactory();
      beanFactory.setSerializationId(getId());
      customizeBeanFactory(beanFactory);
      //在这一步进行xml的读取和解析xml中的bean 转换为BeanDefinition对象
      //抽象方法在 AbstractXmlApplicationContext类中实现
      loadBeanDefinitions(beanFactory);
      synchronized (this.beanFactoryMonitor) {
         this.beanFactory = beanFactory;
      }
   }
  
}
```

#####AbstractXmlApplicationContext

```java
@Override
protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
   // Create a new XmlBeanDefinitionReader for the given BeanFactory.
   XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

   // Configure the bean definition reader with this context's
   // resource loading environment.
   beanDefinitionReader.setEnvironment(this.getEnvironment());
   beanDefinitionReader.setResourceLoader(this);
   beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));

   // Allow a subclass to provide custom initialization of the reader,
   // then proceed with actually loading the bean definitions.
   initBeanDefinitionReader(beanDefinitionReader);
   //这一步是读取xml文件的地方，转为Resource对象
   loadBeanDefinitions(beanDefinitionReader);
}
```

##### AbstractBeanDefinitionReader

```java
public int loadBeanDefinitions(String location, @Nullable Set<Resource> actualResources) throws BeanDefinitionStoreException {
   ResourceLoader resourceLoader = getResourceLoader();
   if (resourceLoader == null) {
      throw new BeanDefinitionStoreException(
            "Cannot load bean definitions from location [" + location + "]: no ResourceLoader available");
   }
      // Resource pattern matching available.
      try {
         Resource[] resources = ((ResourcePatternResolver) resourceLoader).getResources(location);
        
         //返回加载的资源数量loadBeanDefinitions
         int count = loadBeanDefinitions(resources);
         if (actualResources != null) {
            Collections.addAll(actualResources, resources);
         }
         if (logger.isTraceEnabled()) {
            logger.trace("Loaded " + count + " bean definitions from location pattern [" + location + "]");
         }
         return count;
      }
  
}
```

##### XmlBeanDefinitionReader

```java
public int loadBeanDefinitions(EncodedResource encodedResource) throws BeanDefinitionStoreException {

      InputStream inputStream = encodedResource.getResource().getInputStream();
      try {
         InputSource inputSource = new InputSource(inputStream);
         if (encodedResource.getEncoding() != null) {
            inputSource.setEncoding(encodedResource.getEncoding());
         }
         //此方法才是开始解析xml转为Java中的Document一个个的节点
         return doLoadBeanDefinitions(inputSource, encodedResource.getResource());
      }
      finally {
         inputStream.close();
      }
   }

}
protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource)
			throws BeanDefinitionStoreException {

		try {
      //返回的是一个Document对象
			Document doc = doLoadDocument(inputSource, resource);
      //将Document转为BeanDefinition对象后，将信息写入beanDefinitionMap中
        //其中主要就是xml这些信息都可以在BeanDefinition找到
        // <bean id="person" class="com.day01_Spring.Person">
        //  <property name="id" value="1001"/>
        //  <property name="name" value="张三"/>
        //  <property name="teacher">
        //     <list>
        //        <value>1</value>
        //        <value>2</value>
        //        <value>3</value>
        //    </list>
        //  </property>
        //  <property name="sList">
        //       <list>
        //           <ref bean="t1"/>
        //       </list>
        //    </property>
        // </bean>
      //private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256)
      //后续getBean()通过配置文件的id，获取到了BeanDefinition，就相当于获取了xml中的所有信息
			int count = registerBeanDefinitions(doc, resource);
			if (logger.isDebugEnabled()) {
				logger.debug("Loaded " + count + " bean definitions from " + resource);
			}
			return count;
		}
	}


```

