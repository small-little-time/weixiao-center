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
 * @date 2020-04-23 15:19:03
 */
@Entity
@Table(name = "z_student_feedback")
@DynamicInsert
@DynamicUpdate
public class StudentFeedback implements Serializable {

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
	 * 内容
	 */
		@Column(name = "content", nullable = false)
	private String content;
    	/**
	 * 是否已处理 0-已处理 1-未处理
	 */
		@Column(name = "handle", nullable = false)
	private Integer handle;
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
		@Column(name = "logic_falg", nullable = false)
	private Integer logicFalg;
    

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
		    public String getContent() {
        return content;
    }

	public void setContent(String content) {
		this.content = content;
	}
		    public Integer getHandle() {
        return handle;
    }

	public void setHandle(Integer handle) {
		this.handle = handle;
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
		    public Integer getLogicFalg() {
        return logicFalg;
    }

	public void setLogicFalg(Integer logicFalg) {
		this.logicFalg = logicFalg;
	}
	
    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
