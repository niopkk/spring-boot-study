package com.lesson4;

public class DeprecatedSuspendResume  implements Runnable {


    private volatile int fristVal;

    private volatile int secondVal;

    public boolean areValuesEqual() {
        return (fristVal == secondVal);
    }

    public void run() {

        try {
            fristVal=0;
            secondVal=0;
            workMethod();
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("线程中断");
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;
        while (true){
            stepOne(val);
            stepTwo(val);
            val++;
            Thread.sleep(200);  //再次循环钱休眠200毫秒
        }
    }
    //赋值后，休眠300毫秒，从而使线程有机会在stepOne操作和stepTwo操作之间被挂起
    private void stepOne(int newVal) throws InterruptedException{
        fristVal = newVal;
        Thread.sleep(300);  //模拟长时间运行的情况
    }

    private void stepTwo(int newVal){
        secondVal = newVal;
    }

    public static void main(String[] args) {
        DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
        Thread t = new Thread(dsr);
        t.start();
        //休眠1秒，让其他线程有机会获得执行
        try {
            Thread.sleep(1000);}
        catch(InterruptedException x){}
        for (int i = 0; i < 10; i++){
            //挂起线程
            t.suspend();
            System.out.println("dsr.areValuesEqual()=" + dsr.areValuesEqual());
            //恢复线程
            t.resume();
            try{
                //线程随机休眠0~2秒
                Thread.sleep((long)(Math.random()*2000.0));
            }catch(InterruptedException x){
                //略
            }
        }
        System.exit(0); //中断应用程序
    }

}
