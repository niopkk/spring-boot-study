package com.bbz;

public class Main {

    public static void main(String[] args) {
        Encode encode = derive -> derive.encrypt();

        encode.encode(new Derive());

        Encode encode1=derive -> derive.te("tttt");
        encode1.encode(new Derive());
    }
}
