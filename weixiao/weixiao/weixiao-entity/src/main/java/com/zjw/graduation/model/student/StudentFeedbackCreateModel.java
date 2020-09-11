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
 * @date 2020-04-23 15:19:03
 */
@ApiModel(value = "student.StudentFeedbackCreateModel", description = "")
public class StudentFeedbackCreateModel {

    /**
     * 学生主键
     */
    @ApiModelProperty(value = "学生主键", required = true)
    private Long studentId;

    @ApiModelProperty(value = "内容", required = true)
    private String content;

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

}
