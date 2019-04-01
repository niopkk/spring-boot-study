package com.ThreadLocal;

public class Test2Main {

    private static ThreadLocalExt ext = new ThreadLocalExt();


    public static void main(String[] args) {

        if (ext.get() == null) {
            System.out.println("没有放入过值");
            ext.set("放入新值");
        }

        System.out.println(ext.get());

        System.out.println(ext.get());
    }


    static class ThreadLocalExt extends ThreadLocal {
        @Override
        protected Object initialValue() {
            return "给ThreadLocal默认值.......";
        }
    }
}
