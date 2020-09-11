package com.zjw.graduation.dto.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 学生表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-25 10:30:03
 */
@ApiModel(value = "student.StudentMemberDto", description = "学生表")
public class StudentMemberDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", name = "truename")
    private String truename;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", name = "nickname")
    private String nickname;

    /**
     * 性别 0-不详 1-男 2-女
     */
    @ApiModelProperty(value = "性别 0-不详 1-男 2-女", name = "sex")
    private Integer sex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄", name = "age")
    private Integer age;

    /**
     * 地区
     */
    @ApiModelProperty(value = "地区", name = "area")
    private String area;

    /**
     * 学号
     */
    @ApiModelProperty(value = "学号", name = "number")
    private String number;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像", name = "faceImg")
    private String faceImg;

    /**
     * 聊天头像
     */
    @ApiModelProperty(value = "聊天头像", name = "faceImgMin")
    private String faceImgMin;

    /**
     * 专业id
     */
    @ApiModelProperty(value = "专业id", name = "academyId")
    private Long academyId;

    /**
     * 状态 0-启用 1-禁用
     */
    @ApiModelProperty(value = "状态 0-启用 1-禁用", name = "state")
    private Integer state;

    /**
     * 个人签名
     */
    @ApiModelProperty(value = "个人签名", name = "autograph")
    private String autograph;

    /**
     * 是否隐藏个人信息 1-不隐藏 2-隐藏
     */
    @ApiModelProperty(value = "是否隐藏个人信息 1-不隐藏 2-隐藏", name = "hide")
    private Integer hide;

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
     * 逻辑删除 0-是 1-否
     */
    @ApiModelProperty(value = "逻辑删除 0-是 1-否", name = "logicFlag")
    private Integer logicFlag;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getFaceImgMin() {
        return faceImgMin;
    }

    public void setFaceImgMin(String faceImgMin) {
        this.faceImgMin = faceImgMin;
    }

    public Long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
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

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }
}
