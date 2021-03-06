package com.zjw.graduation.model.adm;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 后台用户角色表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@ApiModel(value = "adm.AdmRoleUpdateModel", description = "后台用户角色表")
public class AdmRoleUpdateModel {


	/**
	 * 
	 */
			@NotNull(message = " 不能为空")
							@ApiModelProperty(value = "", required = true)
				private Long id;


	/**
	 * 名称
	 */
							@ApiModelProperty(value = "名称")
				private String name;


	/**
	 * 描述
	 */
							@ApiModelProperty(value = "描述")
				private String description;


	/**
	 * 后台用户数量
	 */
							@ApiModelProperty(value = "后台用户数量")
				private Integer adminCount;


	/**
	 * 启用状态：0-禁用 1-启用
	 */
							@ApiModelProperty(value = "启用状态：0-禁用 1-启用")
				private Integer status;


	/**
	 * 排序
	 */
							@ApiModelProperty(value = "排序")
				private Integer sort;


		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
			public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
			public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
			public Integer getAdminCount() {
		return adminCount;
	}

	public void setAdminCount(Integer adminCount) {
		this.adminCount = adminCount;
	}
			public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
			public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
				
}
