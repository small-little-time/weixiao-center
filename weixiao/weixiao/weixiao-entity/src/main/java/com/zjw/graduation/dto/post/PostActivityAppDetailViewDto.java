package com.zjw.graduation.dto.post;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
public class PostActivityAppDetailViewDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 发布者主键
     */
    private Long studentId;
    /**
     * 院部主键
     */
    private Long academyId;
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
    private Long category;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * 发布时间
     */
    private LocalDateTime releaseTime;
    /**
     * 活动类型 1-组织活动 2-报名活动
     */
    private Integer type;
    /**
     * 报名开始时间
     */
    private LocalDateTime signStartTime;
    /**
     * 报名截止时间
     */
    private LocalDateTime signEndTime;
    /**
     * 人数上限
     */
    private Integer maxNumber;
    /**
     * 状态 0-禁止 1-正常
     */
    private Integer state;
    /**
     * 创建时间
     */
    private LocalDateTime created;
    /**
     * 更新时间
     */
    private LocalDateTime updated;
    /**
     * 逻辑删除 0-否 1-是
     */
    private Integer logicFlag;


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

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
