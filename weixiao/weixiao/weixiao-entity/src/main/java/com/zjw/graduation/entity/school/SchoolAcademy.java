package com.zjw.graduation.entity.school;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;


/**
 * 院部专业信息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-12 15:30:59
 */
@Entity
@Table(name = "z_school_academy")
@DynamicInsert
@DynamicUpdate
public class SchoolAcademy implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 名称
	 */
	    @Column(name = "academy_name")
	private String academyName;
		/**
	 * 
	 */
	    @Column(name = "parent_id")
	private Long parentId;
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
		    public String getAcademyName() {
        return academyName;
    }

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
		    public Long getParentId() {
        return parentId;
    }

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
