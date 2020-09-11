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
 * 后台用户表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:15
 */
@ApiModel(value = "adm.AdmAdminUpdateModel", description = "后台用户表")
public class AdmAdminUpdateModel {


	/**
	 * 主键
	 */
			@NotNull(message = "主键 不能为空")
							@ApiModelProperty(value = "主键", required = true)
				private Long id;


	/**
	 * 用户名
	 */
							@ApiModelProperty(value = "用户名")
				private String username;


	/**
	 * 密码
	 */
							@ApiModelProperty(value = "密码")
				private String password;


	/**
	 * 头像
	 */
							@ApiModelProperty(value = "头像")
				private String icon;


	/**
	 * 邮箱
	 */
							@ApiModelProperty(value = "邮箱")
				private String email;


	/**
	 * 昵称
	 */
							@ApiModelProperty(value = "昵称")
				private String nickName;


	/**
	 * 备注信息
	 */
							@ApiModelProperty(value = "备注信息")
				private String note;


	/**
	 * 最后登录时间
	 */
							@ApiModelProperty(value = "最后登录时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime loginTime;


	/**
	 * 帐号启用状态：0-禁用 1-启用
	 */
							@ApiModelProperty(value = "帐号启用状态：0-禁用 1-启用")
				private Integer status;


		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
			public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
			public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
			public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
			public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
			public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
			public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
			public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}
					public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
		
}
