package com.bbz;

public class Testmain {

    public static void main(String[] args) {

        B a = new B();
        a.setName("张三");




        change(a);

        System.out.println("ddddd:" + a.getName());


        Integer d = 3;
        change(d);
        System.out.println(d);

        String str1 = "通话";

        String str2 = "重地";


        System.out.println(str1. hashCode());
        System.out.println(str2. hashCode());

        System. out. println(str1. equals(str2));



    }

    public static void change(Integer d) {
        System.out.println(d);
        d = 50;
    }

    public static void change(B b) {
        b.setName("李四");
        System.out.println(b.getName());
    }

    static class B {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
