package com.zjw.graduation.entity.student;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 学生设置表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@Entity
@Table(name = "z_student_setting")
@DynamicInsert
@DynamicUpdate
public class StudentSetting implements Serializable {

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
	 * 是否允许私聊 0-否 1-是
	 */
	    @Column(name = "chat_set")
	private Integer chatSet;
		/**
	 * 是否展示性别 0-否 1-是
	 */
	    @Column(name = "sex_set")
	private Integer sexSet;
		/**
	 * 是否显示院部 0-否 1-是
	 */
	    @Column(name = "academy_set")
	private Integer academySet;
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
		    public Integer getChatSet() {
        return chatSet;
    }

	public void setChatSet(Integer chatSet) {
		this.chatSet = chatSet;
	}
		    public Integer getSexSet() {
        return sexSet;
    }

	public void setSexSet(Integer sexSet) {
		this.sexSet = sexSet;
	}
		    public Integer getAcademySet() {
        return academySet;
    }

	public void setAcademySet(Integer academySet) {
		this.academySet = academySet;
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
