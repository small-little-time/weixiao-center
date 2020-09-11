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
 * 后台用户角色和权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@ApiModel(value = "adm.AdmRolePermissionRelationCreateModel", description = "后台用户角色和权限关系表")
public class AdmRolePermissionRelationCreateModel {

		
		/**
		 * 角色主键
		 */
							

									@ApiModelProperty(value = "角色主键")
							private Long roleId;

		
		/**
		 * 权限主键
		 */
							

									@ApiModelProperty(value = "权限主键")
							private Long permissionId;

				
			public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
			public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
				
}
