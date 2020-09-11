package com.zjw.graduation.dto.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-23 10:04:49
 */
@ApiModel(value="common.CommonAreaDto", description="")
public class CommonAreaDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
@ApiModelProperty(value="", name="id", required=true)
	private Long id;

	/**
	 * 编号
	 */
@ApiModelProperty(value="编号", name="number")
	private Integer number;

	/**
	 * 名称
	 */
@ApiModelProperty(value="名称", name="name")
	private String name;

	/**
	 * 城市类型
	 */
@ApiModelProperty(value="城市类型", name="areaType")
	private Integer areaType;

	/**
	 * 父城市编号
	 */
@ApiModelProperty(value="父城市编号", name="parentNumber")
	private Integer parentNumber;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
	public Integer getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(Integer parentNumber) {
		this.parentNumber = parentNumber;
	}

}
