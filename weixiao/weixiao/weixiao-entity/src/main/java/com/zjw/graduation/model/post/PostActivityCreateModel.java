package com.zjw.graduation.model.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value = "post.PostActivityCreateModel", description = "活动发布表")
public class PostActivityCreateModel {


    /**
     * 发布者主键
     */
    @NotNull(message = "发布者主键 不能为空")
    @ApiModelProperty(value = "发布者主键", required = true)
    private Long studentId;

    /**
     * 标题
     */
    @Size(min = 0, max = 255, message = "标题 长度需要在0和255之间")
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 摘要
     */
    @Size(min = 0, max = 255, message = "摘要 长度需要在0和255之间")
    @ApiModelProperty(value = "摘要")
    private String abs;

    /**
     * 内容
     */
    @Size(min = 0, max = 65535, message = "内容 长度需要在0和65535之间")
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 图片
     */
    @Size(min = 0, max = 999, message = "图片 长度需要在0和999之间")
    @ApiModelProperty(value = "图片")
    private String images;

    /**
     * 活动类型
     */
    @ApiModelProperty(value = "活动类型")
    private Long category;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", example = "2019-01-01 09:01:01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", example = "2019-01-01 09:01:01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 活动类型 1-组织活动 2-报名活动
     */
    @ApiModelProperty(value = "活动类型 1-组织活动 2-报名活动")
    private Integer type;

    /**
     * 人数上限
     */
    @ApiModelProperty(value = "人数上限")
    private Integer maxNumber;



    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }


}
