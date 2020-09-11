package com.zjw.graduation.entity.post;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@Entity
@Table(name = "z_post_activity")
@DynamicInsert
@DynamicUpdate
public class PostActivity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 发布者主键
	 */
		@Column(name = "student_id", nullable = false)
	private Long studentId;
    	/**
	 * 院部主键
	 */
		@Column(name = "academy_id", nullable = false)
	private Long academyId;
    	/**
	 * 标题
	 */
	    @Column(name = "title")
	private String title;
		/**
	 * 摘要
	 */
	    @Column(name = "abs")
	private String abs;
		/**
	 * 内容
	 */
	    @Column(name = "content")
	private String content;
		/**
	 * 图片
	 */
	    @Column(name = "images")
	private String images;
		/**
	 * 活动类型
	 */
	    @Column(name = "category")
	private Long category;
		/**
	 * 开始时间
	 */
	    @Column(name = "start_time")
	private LocalDateTime startTime;
		/**
	 * 结束时间
	 */
	    @Column(name = "end_time")
	private LocalDateTime endTime;
		/**
	 * 发布时间
	 */
	    @Column(name = "release_time")
	private LocalDateTime releaseTime;
		/**
	 * 活动类型 1-组织活动 2-报名活动
	 */
	    @Column(name = "type")
	private Integer type;
		/**
	 * 报名开始时间
	 */
	    @Column(name = "sign_start_time")
	private LocalDateTime signStartTime;
		/**
	 * 报名截止时间
	 */
	    @Column(name = "sign_end_time")
	private LocalDateTime signEndTime;
		/**
	 * 人数上限
	 */
	    @Column(name = "max_number")
	private Integer maxNumber;
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
	 * 逻辑删除 0-否 1-是
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
	
    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
