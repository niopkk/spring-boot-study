package com.lesson3;

public class PendingInterrupt  {


    public static void main(String[] args) {
        if(args.length>0){
            Thread.currentThread().interrupt();
        }

        //获取当前时间
        long startTime = System.currentTimeMillis();
        try{
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        }catch(InterruptedException x){
            System.out.println("was interrupted");
        }
        //计算中间代码执行的时间
        System.out.println("elapsedTime=" + (System.currentTimeMillis() - startTime));
    }
}
