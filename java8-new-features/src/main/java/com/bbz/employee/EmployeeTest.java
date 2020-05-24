package com.bbz.employee;

public class EmployeeTest {


    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee("李四");
        Teacher teacher = employee.getTeacher();
        teacher.setName("1111");

        System.out.println(employee);
        System.out.println(teacher);
    }
    
}
