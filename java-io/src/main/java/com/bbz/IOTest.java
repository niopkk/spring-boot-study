package com.bbz;

import java.io.*;
import java.nio.charset.Charset;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019/11/2
 */
public class IOTest {

    private final static String path = "/Users/tianxin2/tianxin/spring-boot-study/java-io";

    //    https://juejin.im/post/5b97e5f75188255c8d0fb0c0  文章地址
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

//        test01();
//        test02();
//        test03();
//        test04();
//        test05();

//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
//        test11();
//        test12();


        Student student = new Student();

        System.out.println(student.getClass());
        print(student.getClass());
        print("com.bbz.Student");

    }
    private static void print(String s) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> aClass=Class.forName(s);
        Student student = (Student) aClass.newInstance();
        student.setAge("ewerewkkkkk");
        System.out.println(student.getAge());

    }



    private static void print(Class<?> s) throws IllegalAccessException, InstantiationException {
        Student student = (Student) s.newInstance();
        student.setAge("1232");
        System.out.println(student.getAge());

    }

    private static void test12() throws IOException {
        // 输入和输出都使用缓冲流
        //第一步读取文件，
        FileInputStream fileInputStream = new FileInputStream(new File(path) + "/alarm.mp3");
        //第二步 将文件写入缓冲区
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        //第三步 要写入的文件名称和地址
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path) + "/alarm4.mp3");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int len = 0;
        byte[] bs = new byte[1024];
        long begion = System.currentTimeMillis();
        while ((len = bufferedInputStream.read(bs)) != -1) {
            bufferedOutputStream.write(bs, 0, len);
        }
        System.out.println("复制所需要时间:" + (System.currentTimeMillis() - begion));
        bufferedInputStream.close();
        fileInputStream.close();
        bufferedOutputStream.close();
        fileOutputStream.close();

    }

    private static void test11() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path) + "/test2.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("GBK"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
    }

    private static void test10() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path) + "/test2.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("GBK"));
        outputStreamWriter.write("Hello，world！\n欢迎来到 java 世界\n");
        outputStreamWriter.append("另外一行内容");

        outputStreamWriter.flush();

        System.out.println("文件编码:" + outputStreamWriter.getEncoding());

        outputStreamWriter.close();
        fileOutputStream.close();
    }

    private static void test09() throws IOException {
        FileReader fileReader = new FileReader(new File(path) + "/test.txt");
        int c;
        while ((c = fileReader.read()) != -1) {
            System.out.println((char) c);
        }
        fileReader.close();
    }

    private static void test08() throws IOException {
        FileReader fileReader = new FileReader(new File(path) + "/test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();
    }

    private static void test07() throws IOException {
        FileWriter fileWriter = new FileWriter(new File(path) + "/test.txt");
        fileWriter.write("Hello word java\n");
        fileWriter.write("覆盖原来的内容\n");
        fileWriter.append("下一航\n");
        fileWriter.flush();
        System.out.println("编码：" + fileWriter.getEncoding());
        fileWriter.close();
    }

    private static void test06() throws IOException {
        FileWriter fileWriter = new FileWriter(new File(path).getAbsoluteFile() + "/test.txt");
        fileWriter.write("hello word java 世界ewewe\n");
        fileWriter.write("不会覆盖文件原来的内容ewewe\n");
        fileWriter.append("并不是追加一行内容，不要被方rrerererr法名迷惑\n");
        fileWriter.append(null);
        fileWriter.flush();
        System.out.println("文件的默认编码:" + fileWriter.getEncoding());
        fileWriter.close();
    }

    public static void test05() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path).getAbsoluteFile() + "/text.txt");
        int c;
        // 读取写入的二进制文件，输出字节数组
        while ((c = fileInputStream.read()) != -1) {
            System.out.print(c);
        }
    }


    private static void test04() throws IOException {
        byte[] bytes = {1, 2, 3};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/tianxin2/tianxin/spring-boot-study/java-io").getAbsoluteFile() + "/text.txt");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    private static void test01() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符:");
        char c;
        c = (char) reader.read();
        System.out.println("你输入的字符为:" + c);
    }

    private static void test02() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一串字符:");
        String str = bufferedReader.readLine();
        System.out.println("你输入的字符川为:" + str);
    }

    private static void test03() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符,按q结束");
        char c;
        do {
            c = (char) bufferedReader.read();
            System.out.println("你输入的字符为:" + c);
        } while (c != 'q');
    }
}
