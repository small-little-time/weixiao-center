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
@ApiModel(value = "student.StudentReportUpdateModel", description = "举报表")
public class StudentReportUpdateModel {


	/**
	 * 主键
	 */
			@NotNull(message = "主键 不能为空")
							@ApiModelProperty(value = "主键", required = true)
				private Long id;


	/**
	 * 举报人主键
	 */
			@NotNull(message = "举报人主键 不能为空")
									@ApiModelProperty(value = "举报人主键", required = true)
				private Long studentId;


	/**
	 * 举报人姓名
	 */
							@ApiModelProperty(value = "举报人姓名")
				private String studentName;


	/**
	 * 被举报人主键
	 */
			@NotNull(message = "被举报人主键 不能为空")
									@ApiModelProperty(value = "被举报人主键", required = true)
				private Long reportStudentId;


	/**
	 * 被举报人姓名
	 */
							@ApiModelProperty(value = "被举报人姓名")
				private String reportStudentName;


	/**
	 * 内容类型
	 */
							@ApiModelProperty(value = "内容类型")
				private Long categoryId;


	/**
	 * 发布内容主键
	 */
							@ApiModelProperty(value = "发布内容主键")
				private Long postId;


	/**
	 * 举报说明
	 */
							@ApiModelProperty(value = "举报说明")
				private String content;


	/**
	 * 举报状态 0-全部 1-正在处理 2-已处理
	 */
							@ApiModelProperty(value = "举报状态 0-全部 1-正在处理 2-已处理")
				private Integer state;


	/**
	 * 反馈
	 */
							@ApiModelProperty(value = "反馈")
				private String reply;


		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
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
			public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
			public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
				
}
