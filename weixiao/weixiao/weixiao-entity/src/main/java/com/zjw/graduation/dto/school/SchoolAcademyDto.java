package com.zjw.graduation.dto.school;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 院部专业信息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-12 15:30:59
 */
@ApiModel(value="school.SchoolAcademyDto", description="院部专业信息表")
public class SchoolAcademyDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
@ApiModelProperty(value="主键", name="id", required=true)
	private Long id;

	/**
	 * 名称
	 */
@ApiModelProperty(value="名称", name="academyName")
	private String academyName;

	/**
	 * 
	 */
@ApiModelProperty(value="", name="parentId")
	private Long parentId;

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
	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getLogicFlag() {
		return logicFlag;
	}

	public void setLogicFlag(Integer logicFlag) {
		this.logicFlag = logicFlag;
	}

}
