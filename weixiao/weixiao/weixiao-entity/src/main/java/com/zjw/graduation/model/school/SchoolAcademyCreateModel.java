package com.zjw.graduation.model.school;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;


/**
 * 院部专业信息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-12 15:30:59
 */
@ApiModel(value = "school.SchoolAcademyCreateModel", description = "院部专业信息表")
public class SchoolAcademyCreateModel {

		
		/**
		 * 名称
		 */
								@Size(min = 0, max = 255, message = "名称 长度需要在0和255之间")
					

									@ApiModelProperty(value = "名称")
							private String academyName;

		
		/**
		 * 
		 */
							

									@ApiModelProperty(value = "")
							private Long parentId;

		
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
		
}
