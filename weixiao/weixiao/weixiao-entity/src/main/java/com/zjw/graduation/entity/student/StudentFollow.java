package com.zjw.graduation.entity.student;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-24 11:47:21
 */
@Entity
@Table(name = "z_student_follow")
@DynamicInsert
@DynamicUpdate
public class StudentFollow implements Serializable {

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
	 * 被关注学生主键
	 */
		@Column(name = "follow_student_id", nullable = false)
	private Long followStudentId;
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
	    @Column(name = "logic_flag")
	private int logicFlag;

	public int getLogicFlag() {
		return logicFlag;
	}

	public void setLogicFlag(int logicFlag) {
		this.logicFlag = logicFlag;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

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
		    public Long getFollowStudentId() {
        return followStudentId;
    }

	public void setFollowStudentId(Long followStudentId) {
		this.followStudentId = followStudentId;
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
	
    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
