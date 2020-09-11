package com.zjw.graduation.model.adm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "adm.AdmAdminRoleRelationBatchDeleteModel", description = "批量删除管理员角色")
public class AdmAdminRoleRelationBatchDeleteModel {

    @ApiModelProperty(value = "管理员主键")
    private Long adminId;

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
