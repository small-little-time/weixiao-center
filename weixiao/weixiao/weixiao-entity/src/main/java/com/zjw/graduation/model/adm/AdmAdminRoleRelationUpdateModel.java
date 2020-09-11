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
 * 后台用户和角色关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@ApiModel(value = "adm.AdmAdminRoleRelationUpdateModel", description = "后台用户和角色关系表")
public class AdmAdminRoleRelationUpdateModel {


	/**
	 * 
	 */
			@NotNull(message = " 不能为空")
							@ApiModelProperty(value = "", required = true)
				private Long id;


	/**
	 * 用户主键
	 */
							@ApiModelProperty(value = "用户主键")
				private Long adminId;


	/**
	 * 角色主键
	 */
							@ApiModelProperty(value = "角色主键")
				private Long roleId;


		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
			public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
			public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
				
}
