package com.bbz.annotation02.testenum;

public enum GameEnum {
    BIG(0, "大"),
    SMALL(1, "小"),
    FATTER(2, "中");

    private Integer code;

    private String des;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    GameEnum(Integer code, String des) {
        this.code = code;
        this.des = des;
    }

    public static void method() {
        System.out.println("这是一个测试单例枚举");
    }

    public static String getDes(Integer code) {
        for (GameEnum g : GameEnum.values()) {
            if (code.equals(g.code)) {
                return g.des;
            }
        }
        return null;
    }


}
