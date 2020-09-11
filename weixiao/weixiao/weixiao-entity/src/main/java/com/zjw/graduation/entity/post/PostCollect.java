package com.zjw.graduation.entity.post;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 收藏表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-07 15:00:56
 */
@Entity
@Table(name = "z_post_collect")
@DynamicInsert
@DynamicUpdate
public class PostCollect implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 学生主键
	 */
		@Column(name = "student_id", nullable = false)
	private Long studentId;
    	/**
	 * 内容主键
	 */
		@Column(name = "content_id", nullable = false)
	private Long contentId;
    	/**
	 * 创建时间
	 */
		@Column(name = "created", nullable = false)
	private LocalDateTime created;
    	/**
	 * 更新时间
	 */
		@Column(name = "updated", nullable = false)
	private LocalDateTime updated;
    	/**
	 * 是否逻辑删除 0-是 1-否
	 */
		@Column(name = "logic_flag", nullable = false)
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
		    public Long getContentId() {
        return contentId;
    }

	public void setContentId(Long contentId) {
		this.contentId = contentId;
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
