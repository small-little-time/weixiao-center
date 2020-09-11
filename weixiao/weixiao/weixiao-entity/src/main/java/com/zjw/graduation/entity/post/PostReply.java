package com.zjw.graduation.entity.post;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 回复表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@Entity
@Table(name = "z_post_reply")
@DynamicInsert
@DynamicUpdate
public class PostReply implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 发布内容主键
	 */
		@Column(name = "post_id", nullable = false)
	private Long postId;
    	/**
	 * 评论主键
	 */
		@Column(name = "comment_id", nullable = false)
	private Long commentId;
    	/**
	 * 回复者主键
	 */
		@Column(name = "student_id", nullable = false)
	private Long studentId;
    	/**
	 * 回复内容
	 */
	    @Column(name = "content")
	private String content;
		/**
	 * 回复时间
	 */
	    @Column(name = "replay_time")
	private LocalDateTime replayTime;
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
	 * 逻辑删除 0-是 1否
	 */
	    @Column(name = "logic_flag")
	private Integer logicFlag;
	

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
