package com.bbz;

import com.bbz.util.CSVTemplate;

import java.io.*;

public class CSVTest {


    private final static String path = "/Users/tianxin2/tianxin/spring-boot-study/java-io";

    public static void main(String[] args) throws Exception {


        InputStream inputStream = new FileInputStream(new File(path) + "/任务11.csv");
        CSVTemplate.of().process(new InputStreamReader(inputStream, "utf-8"), row -> {
            try {
                Task task = new Task(row.get(0), row.get(1));
                System.out.println(task.toString());

            } catch (Exception e) {

            }
        });
    }

    static class Task {
        private String name;
        private String type;

        public Task(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
