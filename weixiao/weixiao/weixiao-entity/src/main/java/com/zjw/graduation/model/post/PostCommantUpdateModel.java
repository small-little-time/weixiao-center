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
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value = "post.PostCommantUpdateModel", description = "")
public class PostCommantUpdateModel {


	/**
	 * 主键
	 */
			@NotNull(message = "主键 不能为空")
							@ApiModelProperty(value = "主键", required = true)
				private Long id;


	/**
	 * 发布内容主键
	 */
			@NotNull(message = "发布内容主键 不能为空")
									@ApiModelProperty(value = "发布内容主键", required = true)
				private Long postId;


	/**
	 * 用户主键
	 */
			@NotNull(message = "用户主键 不能为空")
									@ApiModelProperty(value = "用户主键", required = true)
				private Long studentId;


	/**
	 * 内容
	 */
							@ApiModelProperty(value = "内容")
				private String content;


	/**
	 * 内容类型 0-所有 1-活动 2-动态 3-热点
	 */
							@ApiModelProperty(value = "内容类型 0-所有 1-活动 2-动态 3-热点")
				private Long category;


	/**
	 * 评论时间
	 */
							@ApiModelProperty(value = "评论时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime commentTime;


		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
			public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
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
			public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
			public LocalDateTime getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(LocalDateTime commentTime) {
		this.commentTime = commentTime;
	}
				
}
