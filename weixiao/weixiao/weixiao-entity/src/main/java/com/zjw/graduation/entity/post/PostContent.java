package com.zjw.graduation.entity.post;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 发布内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@Entity
@Table(name = "z_post_content")
@DynamicInsert
@DynamicUpdate
public class PostContent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 用户主键
	 */
		@Column(name = "student_id", nullable = false)
	private Long studentId;
    	/**
	 * 院部主键
	 */
		@Column(name = "academy_id", nullable = false)
	private Long academyId;
    	/**
	 * 发布内容
	 */
	    @Column(name = "content")
	private String content;
		/**
	 * 图片
	 */
	    @Column(name = "images")
	private String images;
		/**
	 * 内容类型
	 */
	    @Column(name = "category")
	private Long category;
		/**
	 * 发布时间
	 */
	    @Column(name = "release_time")
	private LocalDateTime releaseTime;
		/**
	 * 浏览次数
	 */
	    @Column(name = "look_num")
	private Integer lookNum;
		/**
	 * 点赞次数
	 */
	    @Column(name = "like_num")
	private Integer likeNum;
		/**
	 * 审核状态 0-审核失败 1-审核中 2-审核完成
	 */
	    @Column(name = "review_state")
	private Integer reviewState;
		/**
	 * 状态 0-禁止 1-正常
	 */
	    @Column(name = "state")
	private Integer state;
		/**
	 * 创建时间
	 */
	    @Column(name = "created")
	private LocalDateTime created;
		/**
	 * 更新时间
	 */
	    @Column(name = "updated")
	private LocalDateTime updated;
		/**
	 * 逻辑删除 0-是 1-否
	 */
	    @Column(name = "logic_flag")
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
	
    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
