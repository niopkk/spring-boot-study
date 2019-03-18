package com.xml_study.lesson0;


public class Main {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        ApplicationContext context = new ClassPathXmlApplicationContext("lesson0.xml");
//
////        constructor
//        Set<String> set = new CopyOnWriteArraySet<>();
//
//
//        Student student = (Student) context.getBean("student");
//
//        student.setAge(1212);
//        student.setName("sdfsdf");
//        student.setSocre(78);
//        System.out.println(student.getName());
//        String[] strings = new String[]{"xxxxxx,第三得分点"};
//
//        for (String s : strings) {
//            System.out.println(s);
//        }


//        Singer singer=new Singer();
//        Singer proxy= (Singer) new ProxyFactory(singer).getProxyInstance();
//        proxy.sing();
//

//        ProxyTestImpl proxyTest=new P


//        RpcProxy handler = new RpcProxy(new HelloWorldImpl());
//        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
//                Main.class.getClassLoader(),
//                new Class[]{HelloWorld.class},
//                handler);
//        proxy.say();

        HelloWorld helloWorld = new ProxyFactory().proxy(HelloWorld.class);

        helloWorld.say();

    }


}
