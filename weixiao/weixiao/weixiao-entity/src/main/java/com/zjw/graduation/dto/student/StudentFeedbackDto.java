package com.zjw.graduation.dto.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-23 15:19:03
 */
@ApiModel(value="student.StudentFeedbackDto", description="")
public class StudentFeedbackDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
@ApiModelProperty(value="主键", name="id", required=true)
	private Long id;

	/**
	 * 学生主键
	 */
@ApiModelProperty(value="学生主键", name="studentId", required=true)
	private Long studentId;

	/**
	 * 内容
	 */
@ApiModelProperty(value="内容", name="content", required=true)
	private String content;

	/**
	 * 是否已处理 0-已处理 1-未处理
	 */
@ApiModelProperty(value="是否已处理 0-已处理 1-未处理", name="handle")
	private Integer handle;

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
	 * 是否逻辑删除 0-是 1-否
	 */
@ApiModelProperty(value="是否逻辑删除 0-是 1-否", name="logicFalg")
	private Integer logicFalg;



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
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Integer getHandle() {
		return handle;
	}

	public void setHandle(Integer handle) {
		this.handle = handle;
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
	public Integer getLogicFalg() {
		return logicFalg;
	}

	public void setLogicFalg(Integer logicFalg) {
		this.logicFalg = logicFalg;
	}

}
