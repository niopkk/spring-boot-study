package com.bbz.item8;

public class PayrollDayMain {

    public static void main(String[] args) {
        int pay = PayrollDay.SUNDAY.pay(10, 20);
        System.out.println(pay);
    }
}
