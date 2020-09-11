package com.zjw.graduation.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;

import java.time.LocalDateTime;


/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value="post.PostActivityViewDto", description="活动视图信息")
public class PostActivityViewDto{

    /**
     * 主键
     */
    private Long id;
    /**
     * 发布者主键
     */
    private Long studentId;
    /**
     * 发布者主键
     */
    private String truename;
    /**
     * 院部主键
     */
    private Long academyId;
    /**
     * 院部名称
     */
    private String academyName;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String abs;
    /**
     * 内容
     */
    private String content;
    /**
     * 图片
     */
    private String images;
    /**
     * 活动类型
     */
    private String category;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
    private LocalDateTime releaseTime;
    /**
     * 活动类型 1-组织活动 2-报名活动
     */
    private Integer type;
    /**
     * 报名开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
    private LocalDateTime signStartTime;
    /**
     * 报名截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
    private LocalDateTime signEndTime;
    /**
     * 人数上限
     */
    private Integer maxNumber;
    /**
     * 状态 0-禁止 1-正常
     */
    private Integer state;

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getSignStartTime() {
        return signStartTime;
    }

    public void setSignStartTime(LocalDateTime signStartTime) {
        this.signStartTime = signStartTime;
    }

    public LocalDateTime getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(LocalDateTime signEndTime) {
        this.signEndTime = signEndTime;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
