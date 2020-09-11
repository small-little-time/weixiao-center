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
 * 收藏表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-07 15:00:56
 */
@ApiModel(value = "post.PostCollectUpdateModel", description = "收藏表")
public class PostCollectUpdateModel {

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
