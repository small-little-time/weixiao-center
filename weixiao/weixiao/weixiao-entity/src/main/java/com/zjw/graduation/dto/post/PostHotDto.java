package com.zjw.graduation.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 热点内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 18:25:52
 */
@ApiModel(value = "post.PostHotDto", description = "热点内容表")
public class PostHotDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", name = "id", required = true)
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", name = "title")
    private String title;

    /**
     * 发布内容
     */
    @ApiModelProperty(value = "发布内容", name = "content")
    private String content;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片", name = "images")
    private String images;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @ApiModelProperty(value = "发布时间", name = "releaseTime", example = "2019-01-01 09:01:01")
    private LocalDateTime releaseTime;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @ApiModelProperty(value = "开始时间", name = "startTime", example = "2019-01-01 09:01:01")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @ApiModelProperty(value = "结束时间", name = "endTime", example = "2019-01-01 09:01:01")
    private LocalDateTime endTime;

    /**
     * 浏览次数
     */
    @ApiModelProperty(value = "浏览次数", name = "lookNum")
    private Integer lookNum;

    /**
     * 点赞次数
     */
    @ApiModelProperty(value = "点赞次数", name = "likeNum")
    private Integer likeNum;

    /**
     * 状态 0-禁止 1-正常
     */
    @ApiModelProperty(value = "状态 0-禁止 1-正常", name = "state")
    private Integer state;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
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

    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
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

}
