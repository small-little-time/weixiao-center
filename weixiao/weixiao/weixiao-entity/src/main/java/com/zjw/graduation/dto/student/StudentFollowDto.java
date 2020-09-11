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
 * @date 2020-04-24 11:47:21
 */
@ApiModel(value="student.StudentFollowDto", description="")
public class StudentFollowDto {

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
	 * 被关注学生主键
	 */
@ApiModelProperty(value="被关注学生主键", name="followStudentId", required=true)
	private Long followStudentId;

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
@ApiModelProperty(value="是否逻辑删除 0-是 1-否", name="logicFlag")
	private String logicFlag;



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
	public Long getFollowStudentId() {
		return followStudentId;
	}

	public void setFollowStudentId(Long followStudentId) {
		this.followStudentId = followStudentId;
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
	public String getLogicFlag() {
		return logicFlag;
	}

	public void setLogicFlag(String logicFlag) {
		this.logicFlag = logicFlag;
	}

}
