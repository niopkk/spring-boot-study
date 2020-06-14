package com.bbz.jdbc.remote;

public class MainTest {

    public static void main(String[] args) {
        IDataRead read=new MySqlDataRead();
        read.read("qqqq",resultSet -> {
            System.out.println("1111");
        });
    }
}
