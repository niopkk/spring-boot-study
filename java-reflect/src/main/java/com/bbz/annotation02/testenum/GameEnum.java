package com.bbz.annotation02.testenum;

public enum GameEnum {
    BIG("大"),
    SMALL("小"),
    FATTER("中");

    private String des;

    GameEnum(String des) {
        this.des = des;
    }
}
