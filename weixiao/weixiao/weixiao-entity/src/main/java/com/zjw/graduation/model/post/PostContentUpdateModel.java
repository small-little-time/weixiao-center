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
 * 发布内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value = "post.PostContentUpdateModel", description = "发布内容表")
public class PostContentUpdateModel {


	/**
	 * 主键
	 */
			@NotNull(message = "主键 不能为空")
							@ApiModelProperty(value = "主键", required = true)
				private Long id;


	/**
	 * 用户主键
	 */
			@NotNull(message = "用户主键 不能为空")
									@ApiModelProperty(value = "用户主键", required = true)
				private Long studentId;


	/**
	 * 院部主键
	 */
			@NotNull(message = "院部主键 不能为空")
									@ApiModelProperty(value = "院部主键", required = true)
				private Long academyId;


	/**
	 * 发布内容
	 */
							@ApiModelProperty(value = "发布内容")
				private String content;


	/**
	 * 图片
	 */
							@ApiModelProperty(value = "图片")
				private String images;


	/**
	 * 内容类型
	 */
							@ApiModelProperty(value = "内容类型")
				private Long category;


	/**
	 * 发布时间
	 */
							@ApiModelProperty(value = "发布时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime releaseTime;


	/**
	 * 浏览次数
	 */
							@ApiModelProperty(value = "浏览次数")
				private Integer lookNum;


	/**
	 * 点赞次数
	 */
							@ApiModelProperty(value = "点赞次数")
				private Integer likeNum;


	/**
	 * 审核状态 0-审核失败 1-审核中 2-审核完成
	 */
							@ApiModelProperty(value = "审核状态 0-审核失败 1-审核中 2-审核完成")
				private Integer reviewState;


	/**
	 * 状态 0-禁止 1-正常
	 */
							@ApiModelProperty(value = "状态 0-禁止 1-正常")
				private Integer state;


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
			public Long getAcademyId() {
		return academyId;
	}

	public void setAcademyId(Long academyId) {
		this.academyId = academyId;
	}
			public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
			public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
			public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
			public LocalDateTime getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(LocalDateTime releaseTime) {
		this.releaseTime = releaseTime;
	}
			public Integer getLookNum() {
		return lookNum;
	}

	public void setLookNum(Integer lookNum) {
		this.lookNum = lookNum;
	}
			public Integer getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}
			public Integer getReviewState() {
		return reviewState;
	}

	public void setReviewState(Integer reviewState) {
		this.reviewState = reviewState;
	}
			public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
				
}
