package com.bbz.builder;

import java.io.*;

public class TryWithResourcesMainTest {

    public static void main(String[] args) {


    }


    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read()) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
}
