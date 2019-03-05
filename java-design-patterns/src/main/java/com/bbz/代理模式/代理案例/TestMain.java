package com.bbz.代理模式.代理案例;


import com.bbz.代理模式.代理案例.impl.UserManagerImpl;

public class TestMain {


    public static void main(String[] args) {


        IUserManage proxyFactory = (IUserManage) new ProxyFactory().proxy(new UserManagerImpl());

        proxyFactory.add("张三");

        proxyFactory.del(2);

//        String s = "test1 ";
//
//
//        System.out.println(change(s));

//
//        List<List<Integer>> result= new ArrayList<List<Integer>>();
//        List<Integer> temp= new ArrayList<Integer>();
//        temp.add(1);
//        temp.add(2);
//        temp.add(3);
//        result.add(temp);
//        temp.clear();
//        for(int i=0;i<result.size();i++)
//            System.out.println(result.get(i));


//        List<String> list = Arrays.asList("1","2","3","4","5");
//
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            if ("4".equals(s)) {
//                iterator.remove();
//            }
//        }
//
//        System.out.println("list:" + list);
//
//
//        ClassLoader loader=Thread.currentThread().getContextClassLoader();
//        System.out.println(loader);
//        System.out.println(loader.getParent());
//        System.out.println(loader.getParent().getParent());


    }


}
