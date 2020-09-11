package com.zjw.graduation.model.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 收藏表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-07 15:00:56
 */
@ApiModel(value = "post.PostCollectCreateModel", description = "收藏表")
public class PostCollectCreateModel {


    /**
     * 学生主键
     */
    @NotNull(message = "学生主键 不能为空")


    @ApiModelProperty(value = "学生主键", required = true)
    private Long studentId;


    /**
     * 内容主键
     */
    @NotNull(message = "内容主键 不能为空")


    @ApiModelProperty(value = "内容主键", required = true)
    private Long contentId;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

}
