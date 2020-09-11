package com.zjw.graduation.model.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value = "post.PostCommantCreateModel", description = "")
public class PostCommantCreateModel {


    /**
     * 发布内容主键
     */
    @NotNull(message = "发布内容主键 不能为空")


    @ApiModelProperty(value = "发布内容主键", required = true)
    private Long postId;


    /**
     * 用户主键
     */
    @NotNull(message = "用户主键 不能为空")


    @ApiModelProperty(value = "用户主键", required = true)
    private Long studentId;


    /**
     * 内容
     */
    @Size(min = 0, max = 65535, message = "内容 长度需要在0和65535之间")


    @ApiModelProperty(value = "内容")
    private String content;


    /**
     * 内容类型 0-所有 1-活动 2-动态 3-热点
     */


    @ApiModelProperty(value = "内容类型 0-所有 1-活动 2-动态 3-热点")
    private Long category;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

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

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

}
