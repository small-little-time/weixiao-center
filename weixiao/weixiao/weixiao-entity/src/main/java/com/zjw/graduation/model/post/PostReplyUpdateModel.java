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
 * 回复表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@ApiModel(value = "post.PostReplyUpdateModel", description = "回复表")
public class PostReplyUpdateModel {


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
	 * 评论主键
	 */
			@NotNull(message = "评论主键 不能为空")
									@ApiModelProperty(value = "评论主键", required = true)
				private Long commentId;


	/**
	 * 回复者主键
	 */
			@NotNull(message = "回复者主键 不能为空")
									@ApiModelProperty(value = "回复者主键", required = true)
				private Long studentId;


	/**
	 * 回复内容
	 */
							@ApiModelProperty(value = "回复内容")
				private String content;


	/**
	 * 回复时间
	 */
							@ApiModelProperty(value = "回复时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime replayTime;


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
			public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
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
			public LocalDateTime getReplayTime() {
		return replayTime;
	}

	public void setReplayTime(LocalDateTime replayTime) {
		this.replayTime = replayTime;
	}
				
}
