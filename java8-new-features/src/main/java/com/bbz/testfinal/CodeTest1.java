package com.bbz.testfinal;

public class CodeTest1 {

    final TestFinal tf = new TestFinal();

    final int sum;

    public CodeTest1(int sum) {
        this.sum = sum;
    }

    public static void main(String[] args) {
        CodeTest1 code = new CodeTest1(3);
        code.tf.setName("wew");
        System.out.println();

        System.out.printf(code.tf.getName());
    }
}
