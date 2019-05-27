package com.bbz.core.entity;


import lombok.Data;

@Data
public class UserEntity {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 性别
     */
    private Integer sex;


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
