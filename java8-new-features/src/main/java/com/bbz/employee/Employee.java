package com.bbz.employee;

public class Employee  {

    private String name;

    private Teacher teacher;

    public Employee(String name) {
        this.name = name;
        this.teacher = new Teacher("老师",20);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Teacher getTeacher() throws CloneNotSupportedException {
        return (Teacher) teacher.clone();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
