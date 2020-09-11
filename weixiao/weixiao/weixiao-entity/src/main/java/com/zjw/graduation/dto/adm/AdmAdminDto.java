package com.zjw.graduation.dto.adm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 后台用户表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:15
 */
@ApiModel(value = "adm.AdmAdminDto", description = "后台用户表")
public class AdmAdminDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", name = "id", required = true)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像", name = "icon")
    private String icon;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", name = "nickName")
    private String nickName;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", name = "note")
    private String note;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @ApiModelProperty(value = "最后登录时间", name = "loginTime", example = "2019-01-01 09:01:01")
    private LocalDateTime loginTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @ApiModelProperty(value = "创建时间", name = "created", example = "2019-01-01 09:01:01")
    private LocalDateTime created;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @ApiModelProperty(value = "更新时间", name = "updated", example = "2019-01-01 09:01:01")
    private LocalDateTime updated;

    /**
     * 帐号启用状态：0-禁用 1-启用
     */
    @ApiModelProperty(value = "帐号启用状态：0-禁用 1-启用", name = "status")
    private Integer status;

    /**
     * 逻辑删除 0-是 1-否
     */
    @ApiModelProperty(value = "逻辑删除 0-是 1-否", name = "logicFlag")
    private Integer logicFlag;


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

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

}
