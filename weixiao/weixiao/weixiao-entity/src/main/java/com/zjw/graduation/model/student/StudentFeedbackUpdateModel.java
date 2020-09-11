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
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-23 15:19:03
 */
@ApiModel(value = "student.StudentFeedbackUpdateModel", description = "")
public class StudentFeedbackUpdateModel {


	/**
	 * 主键
	 */
			@NotNull(message = "主键 不能为空")
							@ApiModelProperty(value = "主键", required = true)
				private Long id;


	/**
	 * 学生主键
	 */
			@NotNull(message = "学生主键 不能为空")
									@ApiModelProperty(value = "学生主键", required = true)
				private Long studentId;


	/**
	 * 内容
	 */
			@NotNull(message = "内容 不能为空")
					@Size(min = 1, max = 65535, message = "内容 长度需要在1和65535之间")
									@ApiModelProperty(value = "内容", required = true)
				private String content;


	/**
	 * 是否已处理 0-已处理 1-未处理
	 */
							@ApiModelProperty(value = "是否已处理 0-已处理 1-未处理")
				private Integer handle;


	/**
	 * 是否逻辑删除 0-是 1-否
	 */
							@ApiModelProperty(value = "是否逻辑删除 0-是 1-否")
				private Integer logicFalg;


		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
			public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
			public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
			public Integer getHandle() {
		return handle;
	}

	public void setHandle(Integer handle) {
		this.handle = handle;
	}
					public Integer getLogicFalg() {
		return logicFalg;
	}

	public void setLogicFalg(Integer logicFalg) {
		this.logicFalg = logicFalg;
	}
	
}
