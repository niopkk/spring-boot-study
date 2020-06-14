package com.bbz;

public class TestMian {

    public static void main(String[] args) {
        B b=new B();
        b.scan();
    }

    static class A {
        public void scan() {
            doScan();
        }

        protected void doScan(){
            System.out.println("A.doScan");
        }
    }

    static class B  extends A{

        @Override
        protected void doScan(){
            System.out.println("B.doScan");
        }
    }



}

