package com.bbz.model;

import com.bbz.support.TokenDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUser implements TokenDetail {


    /**
     * 用户id
     */
    private int id;

    /**
     * 用户名
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
     * 账号状态
     */
    private int status;

    /**
     * 登陆时间
     */
    private long loginTime;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 修改时间
     */
    private long modifyTime;

    /**
     * 是否删除 0 未删除 1 删除
     */
    private int isDeleted;


    /**
     * 角色ID
     */
    private int roleId;


    @Override
    public String getUsername() {
        return this.getAccount();
    }
}
