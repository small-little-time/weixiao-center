package com.zjw.graduation.model.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 学生设置表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@ApiModel(value = "student.StudentSettingUpdateModel", description = "学生设置表")
public class StudentSettingUpdateModel {


    /**
     * 用户主键
     */
    @NotNull(message = "用户主键 不能为空")
    @ApiModelProperty(value = "用户主键", required = true)
    private Long studentId;


    /**
     * 是否允许私聊 0-否 1-是
     */
    @ApiModelProperty(value = "是否允许私聊 0-否 1-是")
    private Integer chatSet;


    /**
     * 是否展示性别 0-否 1-是
     */
    @ApiModelProperty(value = "是否展示性别 0-否 1-是")
    private Integer sexSet;


    /**
     * 是否显示院部 0-否 1-是
     */
    @ApiModelProperty(value = "是否显示院部 0-否 1-是")
    private Integer academySet;

    private Integer hide;

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getChatSet() {
        return chatSet;
    }

    public void setChatSet(Integer chatSet) {
        this.chatSet = chatSet;
    }

    public Integer getSexSet() {
        return sexSet;
    }

    public void setSexSet(Integer sexSet) {
        this.sexSet = sexSet;
    }

    public Integer getAcademySet() {
        return academySet;
    }

    public void setAcademySet(Integer academySet) {
        this.academySet = academySet;
    }

}
