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
 * 学生权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@ApiModel(value = "student.StudentPermissionUpdateModel", description = "学生权限表")
public class StudentPermissionUpdateModel {


	/**
	 * 主键
	 */
			@NotNull(message = "主键 不能为空")
							@ApiModelProperty(value = "主键", required = true)
				private Long id;


	/**
	 * 父级权限id
	 */
							@ApiModelProperty(value = "父级权限id")
				private Long pid;


	/**
	 * 名称
	 */
							@ApiModelProperty(value = "名称")
				private String name;


	/**
	 * 权限值
	 */
							@ApiModelProperty(value = "权限值")
				private String value;


	/**
	 * 图标
	 */
							@ApiModelProperty(value = "图标")
				private String icon;


	/**
	 * 权限类型：0-目录 1-菜单 2-按钮（接口绑定权限）
	 */
							@ApiModelProperty(value = "权限类型：0-目录 1-菜单 2-按钮（接口绑定权限）")
				private Integer type;


	/**
	 * 前端资源路径
	 */
							@ApiModelProperty(value = "前端资源路径")
				private String uri;


	/**
	 * 启用状态；0-禁用 1-启用
	 */
							@ApiModelProperty(value = "启用状态；0-禁用 1-启用")
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
			public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
			public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
			public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
			public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
			public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
			public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
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
