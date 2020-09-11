package com.zjw.graduation.model.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;


/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-23 10:04:49
 */
@ApiModel(value = "common.CommonAreaCreateModel", description = "")
public class CommonAreaCreateModel {

		
		/**
		 * 编号
		 */
							

									@ApiModelProperty(value = "编号")
							private Integer number;

		
		/**
		 * 名称
		 */
								@Size(min = 0, max = 255, message = "名称 长度需要在0和255之间")
					

									@ApiModelProperty(value = "名称")
							private String name;

		
		/**
		 * 城市类型
		 */
							

									@ApiModelProperty(value = "城市类型")
							private Integer areaType;

		
		/**
		 * 父城市编号
		 */
							

									@ApiModelProperty(value = "父城市编号")
							private Integer parentNumber;

	
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
