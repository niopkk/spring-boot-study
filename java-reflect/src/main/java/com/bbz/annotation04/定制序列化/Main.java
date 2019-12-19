package com.bbz.annotation04.定制序列化;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * com.bbz.annotation04
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class Main {


    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Student student = new Student("张三", sdf.parse("1990-12-12"), 80.9);


        System.out.println(SimpleFormmart.format(student));

    }
}
