package com.zjw.graduation.dto.adm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * 后台用户角色表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@ApiModel(value="adm.AdmRoleDto", description="后台用户角色表")
public class AdmRoleDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
@ApiModelProperty(value="", name="id", required=true)
	private Long id;

	/**
	 * 名称
	 */
@ApiModelProperty(value="名称", name="name")
	private String name;

	/**
	 * 描述
	 */
@ApiModelProperty(value="描述", name="description")
	private String description;

	/**
	 * 后台用户数量
	 */
@ApiModelProperty(value="后台用户数量", name="adminCount")
	private Integer adminCount;

	/**
	 * 启用状态：0-禁用 1-启用
	 */
@ApiModelProperty(value="启用状态：0-禁用 1-启用", name="status")
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
