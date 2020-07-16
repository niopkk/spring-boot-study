package com.bbz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysPermissions {

    /**
     * id
     */
    private int id;

    /**
     *  权限名称
     */
    private String name;

    /**
     * 链接页面
     */
    private String url;

    /**
     * 父级ID
     */
    private int pid;

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

}
