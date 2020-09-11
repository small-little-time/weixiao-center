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
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value = "post.PostActivityUpdateModel", description = "活动发布表")
public class PostActivityUpdateModel {


	/**
	 * 主键
	 */
			@NotNull(message = "主键 不能为空")
							@ApiModelProperty(value = "主键", required = true)
				private Long id;


	/**
	 * 发布者主键
	 */
			@NotNull(message = "发布者主键 不能为空")
									@ApiModelProperty(value = "发布者主键", required = true)
				private Long studentId;


	/**
	 * 院部主键
	 */
			@NotNull(message = "院部主键 不能为空")
									@ApiModelProperty(value = "院部主键", required = true)
				private Long academyId;


	/**
	 * 标题
	 */
							@ApiModelProperty(value = "标题")
				private String title;


	/**
	 * 摘要
	 */
							@ApiModelProperty(value = "摘要")
				private String abs;


	/**
	 * 内容
	 */
							@ApiModelProperty(value = "内容")
				private String content;


	/**
	 * 图片
	 */
							@ApiModelProperty(value = "图片")
				private String images;


	/**
	 * 活动类型
	 */
							@ApiModelProperty(value = "活动类型")
				private Long category;


	/**
	 * 开始时间
	 */
							@ApiModelProperty(value = "开始时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime startTime;


	/**
	 * 结束时间
	 */
							@ApiModelProperty(value = "结束时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime endTime;


	/**
	 * 发布时间
	 */
							@ApiModelProperty(value = "发布时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime releaseTime;


	/**
	 * 活动类型 1-组织活动 2-报名活动
	 */
							@ApiModelProperty(value = "活动类型 1-组织活动 2-报名活动")
				private Integer type;


	/**
	 * 报名开始时间
	 */
							@ApiModelProperty(value = "报名开始时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime signStartTime;


	/**
	 * 报名截止时间
	 */
							@ApiModelProperty(value = "报名截止时间", example = "2019-01-01 09:01:01")
		    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
		private LocalDateTime signEndTime;


	/**
	 * 人数上限
	 */
							@ApiModelProperty(value = "人数上限")
				private Integer maxNumber;


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
			public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
			public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
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
			public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
			public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
			public LocalDateTime getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(LocalDateTime releaseTime) {
		this.releaseTime = releaseTime;
	}
			public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
			public LocalDateTime getSignStartTime() {
		return signStartTime;
	}

	public void setSignStartTime(LocalDateTime signStartTime) {
		this.signStartTime = signStartTime;
	}
			public LocalDateTime getSignEndTime() {
		return signEndTime;
	}

	public void setSignEndTime(LocalDateTime signEndTime) {
		this.signEndTime = signEndTime;
	}
			public Integer getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}
			public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
				
}
