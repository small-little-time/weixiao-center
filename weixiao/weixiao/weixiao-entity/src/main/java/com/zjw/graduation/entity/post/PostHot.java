package com.zjw.graduation.entity.post;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 热点内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 18:25:52
 */
@Entity
@Table(name = "z_post_hot")
@DynamicInsert
@DynamicUpdate
public class PostHot implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 标题
	 */
	    @Column(name = "title")
	private String title;
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
	 * 发布时间
	 */
	    @Column(name = "release_time", nullable = false)
	private LocalDateTime releaseTime;
		/**
	 * 开始时间
	 */
		@Column(name = "start_time", nullable = false)
	private LocalDateTime startTime;
    	/**
	 * 结束时间
	 */
		@Column(name = "end_time", nullable = false)
	private LocalDateTime endTime;
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
		    public String getTitle() {
        return title;
    }

	public void setTitle(String title) {
		this.title = title;
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
		    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

	public void setReleaseTime(LocalDateTime releaseTime) {
		this.releaseTime = releaseTime;
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
