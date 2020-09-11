package com.zjw.graduation.model.adm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * 后台用户表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:15
 */
@ApiModel(value = "adm.AdmAdminCreateModel", description = "后台用户表")
public class AdmAdminCreateModel {


    /**
     * 用户名
     */
    @Size(min = 0, max = 64, message = "用户名 长度需要在0和64之间")


    @ApiModelProperty(value = "用户名")
    private String username;


    /**
     * 密码
     */
    @Size(min = 0, max = 64, message = "密码 长度需要在0和64之间")


    @ApiModelProperty(value = "密码")
    private String password;


    /**
     * 头像
     */
    @Size(min = 0, max = 500, message = "头像 长度需要在0和500之间")


    @ApiModelProperty(value = "头像")
    private String icon;


    /**
     * 邮箱
     */
    @Size(min = 0, max = 100, message = "邮箱 长度需要在0和100之间")


    @ApiModelProperty(value = "邮箱")
    private String email;


    /**
     * 昵称
     */
    @Size(min = 0, max = 200, message = "昵称 长度需要在0和200之间")


    @ApiModelProperty(value = "昵称")
    private String nickName;


    /**
     * 备注信息
     */
    @Size(min = 0, max = 500, message = "备注信息 长度需要在0和500之间")


    @ApiModelProperty(value = "备注信息")
    private String note;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
