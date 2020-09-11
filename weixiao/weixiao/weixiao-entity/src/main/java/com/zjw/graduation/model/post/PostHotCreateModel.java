package com.zjw.graduation.model.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 热点内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 18:25:52
 */
@ApiModel(value = "post.PostHotCreateModel", description = "热点内容表")
public class PostHotCreateModel {


    /**
     * 标题
     */
    @Size(min = 0, max = 255, message = "标题 长度需要在0和255之间")


    @ApiModelProperty(value = "标题")
    private String title;


    /**
     * 发布内容
     */
    @Size(min = 0, max = 65535, message = "发布内容 长度需要在0和65535之间")


    @ApiModelProperty(value = "发布内容")
    private String content;


    /**
     * 图片
     */
    @Size(min = 0, max = 999, message = "图片 长度需要在0和999之间")


    @ApiModelProperty(value = "图片")
    private String images;


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
     * 状态 0-禁止 1-正常
     */
    @ApiModelProperty(value = "状态 0-禁止 1-正常")
    private Integer state;


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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
