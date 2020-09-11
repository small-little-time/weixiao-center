package com.zjw.graduation.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * 发布内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value="post.PostContentDto", description="发布内容表")
public class PostContentDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
@ApiModelProperty(value="主键", name="id", required=true)
	private Long id;

	/**
	 * 用户主键
	 */
@ApiModelProperty(value="用户主键", name="studentId", required=true)
	private Long studentId;

	/**
	 * 院部主键
	 */
@ApiModelProperty(value="院部主键", name="academyId", required=true)
	private Long academyId;

	/**
	 * 发布内容
	 */
@ApiModelProperty(value="发布内容", name="content")
	private String content;

	/**
	 * 图片
	 */
@ApiModelProperty(value="图片", name="images")
	private String images;

	/**
	 * 内容类型
	 */
@ApiModelProperty(value="内容类型", name="category")
	private Long category;

	/**
	 * 发布时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="发布时间", name="releaseTime", example="2019-01-01 09:01:01")
	private LocalDateTime releaseTime;

	/**
	 * 浏览次数
	 */
@ApiModelProperty(value="浏览次数", name="lookNum")
	private Integer lookNum;

	/**
	 * 点赞次数
	 */
@ApiModelProperty(value="点赞次数", name="likeNum")
	private Integer likeNum;

	/**
	 * 审核状态 0-审核失败 1-审核中 2-审核完成
	 */
@ApiModelProperty(value="审核状态 0-审核失败 1-审核中 2-审核完成", name="reviewState")
	private Integer reviewState;

	/**
	 * 状态 0-禁止 1-正常
	 */
@ApiModelProperty(value="状态 0-禁止 1-正常", name="state")
	private Integer state;

	/**
	 * 创建时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="创建时间", name="created", example="2019-01-01 09:01:01")
	private LocalDateTime created;

	/**
	 * 更新时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="更新时间", name="updated", example="2019-01-01 09:01:01")
	private LocalDateTime updated;

	/**
	 * 逻辑删除 0-是 1-否
	 */
@ApiModelProperty(value="逻辑删除 0-是 1-否", name="logicFlag")
	private Integer logicFlag;



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
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	public Integer getLogicFlag() {
		return logicFlag;
	}

	public void setLogicFlag(Integer logicFlag) {
		this.logicFlag = logicFlag;
	}

}
