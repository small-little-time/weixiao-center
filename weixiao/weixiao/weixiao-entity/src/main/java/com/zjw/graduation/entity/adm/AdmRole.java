package com.zjw.graduation.entity.adm;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 后台用户角色表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@Entity
@Table(name = "z_adm_role")
@DynamicInsert
@DynamicUpdate
public class AdmRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 名称
	 */
	    @Column(name = "name")
	private String name;
		/**
	 * 描述
	 */
	    @Column(name = "description")
	private String description;
		/**
	 * 后台用户数量
	 */
	    @Column(name = "admin_count")
	private Integer adminCount;
		/**
	 * 启用状态：0-禁用 1-启用
	 */
	    @Column(name = "status")
	private Integer status;
		/**
	 * 排序
	 */
	    @Column(name = "sort")
	private Integer sort;
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
		    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}
		    public String getDescription() {
        return description;
    }

	public void setDescription(String description) {
		this.description = description;
	}
		    public Integer getAdminCount() {
        return adminCount;
    }

	public void setAdminCount(Integer adminCount) {
		this.adminCount = adminCount;
	}
		    public Integer getStatus() {
        return status;
    }

	public void setStatus(Integer status) {
		this.status = status;
	}
		    public Integer getSort() {
        return sort;
    }

	public void setSort(Integer sort) {
		this.sort = sort;
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
