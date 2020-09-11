package com.zjw.graduation.dto.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * 举报表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 10:50:34
 */
@ApiModel(value="student.StudentReportDto", description="举报表")
public class StudentReportDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
@ApiModelProperty(value="主键", name="id", required=true)
	private Long id;

	/**
	 * 举报人主键
	 */
@ApiModelProperty(value="举报人主键", name="studentId", required=true)
	private Long studentId;

	/**
	 * 举报人姓名
	 */
@ApiModelProperty(value="举报人姓名", name="studentName")
	private String studentName;

	/**
	 * 被举报人主键
	 */
@ApiModelProperty(value="被举报人主键", name="reportStudentId", required=true)
	private Long reportStudentId;

	/**
	 * 被举报人姓名
	 */
@ApiModelProperty(value="被举报人姓名", name="reportStudentName")
	private String reportStudentName;

	/**
	 * 内容类型
	 */
@ApiModelProperty(value="内容类型", name="categoryId")
	private Long categoryId;

	/**
	 * 发布内容主键
	 */
@ApiModelProperty(value="发布内容主键", name="postId")
	private Long postId;

	/**
	 * 举报说明
	 */
@ApiModelProperty(value="举报说明", name="content")
	private String content;

	/**
	 * 举报状态 0-全部 1-正在处理 2-已处理
	 */
@ApiModelProperty(value="举报状态 0-全部 1-正在处理 2-已处理", name="state")
	private Integer state;

	/**
	 * 反馈
	 */
@ApiModelProperty(value="反馈", name="reply")
	private String reply;

	/**
	 * 创建时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="创建时间", name="created", example="2019-01-01 09:01:01")
	private LocalDateTime created;

	/**
	 * 更新时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="更新时间", name="updated", example="2019-01-01 09:01:01")
	private LocalDateTime updated;

	/**
	 * 逻辑删除 0-是 1-否
	 */
@ApiModelProperty(value="逻辑删除 0-是 1-否", name="logicFlag")
	private Integer logicFlag;



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
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	public Integer getLogicFlag() {
		return logicFlag;
	}

	public void setLogicFlag(Integer logicFlag) {
		this.logicFlag = logicFlag;
	}

}
