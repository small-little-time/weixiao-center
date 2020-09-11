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
 * 学生权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@ApiModel(value = "student.StudentMemberPermissionRelationCreateModel", description = "学生权限关系表")
public class StudentMemberPermissionRelationCreateModel {

		
		/**
		 * 用户主键
		 */
							

									@ApiModelProperty(value = "用户主键")
							private Long studentId;

		
		/**
		 * 权限主键
		 */
							

									@ApiModelProperty(value = "权限主键")
							private Long permissionId;

				
			public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
			public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
				
}
