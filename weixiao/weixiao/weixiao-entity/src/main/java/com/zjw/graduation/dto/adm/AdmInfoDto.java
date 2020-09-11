package com.zjw.graduation.dto.adm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value="adm.AdmInfoDto", description="后台用户信息表")
public class AdmInfoDto {

    private String token;

    private int code = 0;

    @ApiModelProperty(value="昵称", name="name")
    private String name;

    @ApiModelProperty(value="头像", name="avatar")
    private String avatar;

    @ApiModelProperty(value="角色", name="roles")
    private List roles = new ArrayList<>();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }
}
