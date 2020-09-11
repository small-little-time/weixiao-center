package com.zjw.graduation.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@ApiModel(value="post.PostActivityDto", description="活动发布表")
public class PostActivityDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
@ApiModelProperty(value="主键", name="id", required=true)
	private Long id;

	/**
	 * 发布者主键
	 */
@ApiModelProperty(value="发布者主键", name="studentId", required=true)
	private Long studentId;

	/**
	 * 院部主键
	 */
@ApiModelProperty(value="院部主键", name="academyId", required=true)
	private Long academyId;

	/**
	 * 标题
	 */
@ApiModelProperty(value="标题", name="title")
	private String title;

	/**
	 * 摘要
	 */
@ApiModelProperty(value="摘要", name="abs")
	private String abs;

	/**
	 * 内容
	 */
@ApiModelProperty(value="内容", name="content")
	private String content;

	/**
	 * 图片
	 */
@ApiModelProperty(value="图片", name="images")
	private String images;

	/**
	 * 活动类型
	 */
@ApiModelProperty(value="活动类型", name="category")
	private Long category;

	/**
	 * 开始时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="开始时间", name="startTime", example="2019-01-01 09:01:01")
	private LocalDateTime startTime;

	/**
	 * 结束时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="结束时间", name="endTime", example="2019-01-01 09:01:01")
	private LocalDateTime endTime;

	/**
	 * 发布时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="发布时间", name="releaseTime", example="2019-01-01 09:01:01")
	private LocalDateTime releaseTime;

	/**
	 * 活动类型 1-组织活动 2-报名活动
	 */
@ApiModelProperty(value="活动类型 1-组织活动 2-报名活动", name="type")
	private Integer type;

	/**
	 * 报名开始时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="报名开始时间", name="signStartTime", example="2019-01-01 09:01:01")
	private LocalDateTime signStartTime;

	/**
	 * 报名截止时间
	 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")
	@ApiModelProperty(value="报名截止时间", name="signEndTime", example="2019-01-01 09:01:01")
	private LocalDateTime signEndTime;

	/**
	 * 人数上限
	 */
@ApiModelProperty(value="人数上限", name="maxNumber")
	private Integer maxNumber;

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
	 * 逻辑删除 0-否 1-是
	 */
@ApiModelProperty(value="逻辑删除 0-否 1-是", name="logicFlag")
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
