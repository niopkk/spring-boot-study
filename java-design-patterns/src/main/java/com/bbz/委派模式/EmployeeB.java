package com.bbz.委派模式;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("B 完成领导的命令:" + command);
    }
}
