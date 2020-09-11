package com.zjw.graduation.dto.adm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;

@ApiModel(value="adm.AdmAdminRolesViewDto", description="管理员角色信息")
public class AdmAdminRolesViewDto {

    @ApiModelProperty(value="主键", name="id")
    private Long id;

    @ApiModelProperty(value="用户名", name="username")
    private String username;

    @ApiModelProperty(value="角色主键", name="roleId")
    private Long roleId;

    @ApiModelProperty(value="角色名称", name="name")
    private String name;

    @ApiModelProperty(value="角色描述", name="description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
