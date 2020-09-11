package com.zjw.graduation.model.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 活动报名表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@ApiModel(value = "post.PostSignUpdateModel", description = "活动报名表")
public class PostSignUpdateModel {


	/**
	 * 
	 */
			@NotNull(message = " 不能为空")
							@ApiModelProperty(value = "", required = true)
				private Long id;


	/**
	 * 
	 */
			@NotNull(message = " 不能为空")
									@ApiModelProperty(value = "", required = true)
				private Long activityId;


	/**
	 * 
	 */
							@ApiModelProperty(value = "")
				private Long studentId;


	/**
	 * qq号码
	 */
							@ApiModelProperty(value = "qq号码")
				private String qq;


	/**
	 * 电话
	 */
							@ApiModelProperty(value = "电话")
				private String phone;


	/**
	 * 备注
	 */
							@ApiModelProperty(value = "备注")
				private String message;


		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
			public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
			public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
			public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
			public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
			public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
				
}
