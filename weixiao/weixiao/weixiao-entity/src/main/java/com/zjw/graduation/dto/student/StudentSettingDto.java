package com.zjw.graduation.dto.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 学生设置表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@ApiModel(value="student.StudentSettingDto", description="学生设置表")
public class StudentSettingDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
@ApiModelProperty(value="主键", name="id", required=true)
	private Long id;

	/**
	 * 用户主键
	 */
@ApiModelProperty(value="用户主键", name="studentId", required=true)
	private Long studentId;

	/**
	 * 是否允许私聊 0-否 1-是
	 */
@ApiModelProperty(value="是否允许私聊 0-否 1-是", name="chatSet")
	private Integer chatSet;

	/**
	 * 是否展示性别 0-否 1-是
	 */
@ApiModelProperty(value="是否展示性别 0-否 1-是", name="sexSet")
	private Integer sexSet;

	/**
	 * 是否显示院部 0-否 1-是
	 */
@ApiModelProperty(value="是否显示院部 0-否 1-是", name="academySet")
	private Integer academySet;




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
	public Integer getChatSet() {
		return chatSet;
	}

	public void setChatSet(Integer chatSet) {
		this.chatSet = chatSet;
	}
	public Integer getSexSet() {
		return sexSet;
	}

	public void setSexSet(Integer sexSet) {
		this.sexSet = sexSet;
	}
	public Integer getAcademySet() {
		return academySet;
	}

	public void setAcademySet(Integer academySet) {
		this.academySet = academySet;
	}

}
