package com.zjw.graduation.model.adm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台用户和角色关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@ApiModel(value = "adm.AdmAdminRoleRelationCreateModel", description = "后台用户和角色关系表")
public class AdmAdminRoleRelationCreateModel {


    /**
     * 用户主键
     */


    @ApiModelProperty(value = "用户主键")
    private Long adminId;


    /**
     * 角色主键
     */


    @ApiModelProperty(value = "角色主键")
    private Long roleId;


    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
