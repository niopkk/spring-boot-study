package com.bbz.委派模式;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("完成领导的命令:"+command);
    }
}
