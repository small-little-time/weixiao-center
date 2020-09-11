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
 * 举报表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 10:50:34
 */
@ApiModel(value = "student.StudentReportCreateModel", description = "举报表")
public class StudentReportCreateModel {

    /**
     * 举报人主键
     */
    @NotNull(message = "举报人主键 不能为空")
    @ApiModelProperty(value = "举报人主键", required = true)
    private Long studentId;

    /**
     * 举报人姓名
     */
    @Size(min = 0, max = 255, message = "举报人姓名 长度需要在0和255之间")
    @ApiModelProperty(value = "举报人姓名")
    private String studentName;

    @ApiModelProperty(value = "被举报人主键", required = true)
    private Long reportStudentId;

    @ApiModelProperty(value = "被举报人姓名")
    private String reportStudentName;

    @ApiModelProperty(value = "内容类型")
    private Long categoryId;

    @ApiModelProperty(value = "发布内容主键")
    private Long postId;

    @ApiModelProperty(value = "举报说明")
    private String content;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getReportStudentId() {
        return reportStudentId;
    }

    public void setReportStudentId(Long reportStudentId) {
        this.reportStudentId = reportStudentId;
    }

    public String getReportStudentName() {
        return reportStudentName;
    }

    public void setReportStudentName(String reportStudentName) {
        this.reportStudentName = reportStudentName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
