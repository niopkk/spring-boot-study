package com.bbz.core.entity;


public class UserEntity {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private String userId;


    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;


    /**
     * 最后登录时间
     */
    private Long lastLoginTime;

}
