package com.zjw.graduation.model.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 发布内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value = "post.PostContentCreateModel", description = "发布内容表")
public class PostContentCreateModel {


    /**
     * 用户主键
     */
    @NotNull(message = "用户主键 不能为空")
    @ApiModelProperty(value = "用户主键", required = true)
    private Long studentId;


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
     * 内容类型
     */
    @ApiModelProperty(value = "内容类型")
    private Long category;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

}
