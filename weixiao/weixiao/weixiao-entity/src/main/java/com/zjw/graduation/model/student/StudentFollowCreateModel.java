package com.zjw.graduation.model.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-24 11:47:21
 */
@ApiModel(value = "student.StudentFollowCreateModel", description = "")
public class StudentFollowCreateModel {


    /**
     * 学生主键
     */
    @NotNull(message = "学生主键 不能为空")


    @ApiModelProperty(value = "学生主键", required = true)
    private Long studentId;


    /**
     * 被关注学生主键
     */
    @NotNull(message = "被关注学生主键 不能为空")


    @ApiModelProperty(value = "被关注学生主键", required = true)
    private Long followStudentId;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getFollowStudentId() {
        return followStudentId;
    }

    public void setFollowStudentId(Long followStudentId) {
        this.followStudentId = followStudentId;
    }

}
