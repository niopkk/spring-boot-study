package com.bbz.base;

public class ResultView {

    private static final String PICDOMAN = "http://123456";

    /**
     * 返回状态码 1成功 -1 失败
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 返回的数据总条数
     */
    private Long total = 0L;


    /**
     * 返回链接前缀
     */
    private String picdoman;

    public ResultView() {

    }

    public ResultView(Integer code, String msg, Object data, long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.picdoman = PICDOMAN;
        this.total = total;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPicdoman() {
        return picdoman;
    }

    public void setPicdoman(String picdoman) {
        this.picdoman = picdoman;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
