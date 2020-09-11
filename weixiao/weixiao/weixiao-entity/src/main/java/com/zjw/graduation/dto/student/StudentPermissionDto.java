package com.zjw.graduation.dto.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * 学生权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@ApiModel(value="student.StudentPermissionDto", description="学生权限表")
public class StudentPermissionDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
@ApiModelProperty(value="主键", name="id", required=true)
	private Long id;

	/**
	 * 父级权限id
	 */
@ApiModelProperty(value="父级权限id", name="pid")
	private Long pid;

	/**
	 * 名称
	 */
@ApiModelProperty(value="名称", name="name")
	private String name;

	/**
	 * 权限值
	 */
@ApiModelProperty(value="权限值", name="value")
	private String value;

	/**
	 * 图标
	 */
@ApiModelProperty(value="图标", name="icon")
	private String icon;

	/**
	 * 权限类型：0-目录 1-菜单 2-按钮（接口绑定权限）
	 */
@ApiModelProperty(value="权限类型：0-目录 1-菜单 2-按钮（接口绑定权限）", name="type")
	private Integer type;

	/**
	 * 前端资源路径
	 */
@ApiModelProperty(value="前端资源路径", name="uri")
	private String uri;

	/**
	 * 启用状态；0-禁用 1-启用
	 */
@ApiModelProperty(value="启用状态；0-禁用 1-启用", name="status")
	private Integer status;

	/**
	 * 排序
	 */
@ApiModelProperty(value="排序", name="sort")
	private Integer sort;

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
