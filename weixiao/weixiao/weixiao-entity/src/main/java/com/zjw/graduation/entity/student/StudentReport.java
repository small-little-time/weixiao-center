package com.zjw.graduation.entity.student;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 举报表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 10:50:34
 */
@Entity
@Table(name = "z_student_report")
@DynamicInsert
@DynamicUpdate
public class StudentReport implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 举报人主键
	 */
		@Column(name = "student_id", nullable = false)
	private Long studentId;
    	/**
	 * 举报人姓名
	 */
		@Column(name = "student_name", nullable = false)
	private String studentName;
    	/**
	 * 被举报人主键
	 */
		@Column(name = "report_student_id", nullable = false)
	private Long reportStudentId;
    	/**
	 * 被举报人姓名
	 */
		@Column(name = "report_student_name", nullable = false)
	private String reportStudentName;
    	/**
	 * 内容类型
	 */
	    @Column(name = "category_id")
	private Long categoryId;
		/**
	 * 发布内容主键
	 */
	    @Column(name = "post_id")
	private Long postId;
		/**
	 * 举报说明
	 */
	    @Column(name = "content")
	private String content;
		/**
	 * 举报状态 0-全部 1-正在处理 2-已处理
	 */
	    @Column(name = "state")
	private Integer state;
		/**
	 * 反馈
	 */
	    @Column(name = "reply")
	private String reply;
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
		    public String getStudentName() {
        return studentName;
    }

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
		    public Long getReportStudentId() {
        return reportStudentId;
    }

	public void setReportStudentId(Long reportStudentId) {
		this.reportStudentId = reportStudentId;
	}
		    public String getReportStudentName() {
        return reportStudentName;
    }

	public void setReportStudentName(String reportStudentName) {
		this.reportStudentName = reportStudentName;
	}
		    public Long getCategoryId() {
        return categoryId;
    }

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
		    public Long getPostId() {
        return postId;
    }

	public void setPostId(Long postId) {
		this.postId = postId;
	}
		    public String getContent() {
        return content;
    }

	public void setContent(String content) {
		this.content = content;
	}
		    public Integer getState() {
        return state;
    }

	public void setState(Integer state) {
		this.state = state;
	}
		    public String getReply() {
        return reply;
    }

	public void setReply(String reply) {
		this.reply = reply;
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
