package com.zjw.graduation.entity.adm;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 后台用户和角色关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@Entity
@Table(name = "z_adm_admin_role_relation")
@DynamicInsert
@DynamicUpdate
public class AdmAdminRoleRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 用户主键
	 */
	    @Column(name = "admin_id")
	private Long adminId;
		/**
	 * 角色主键
	 */
	    @Column(name = "role_id")
	private Long roleId;
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
		    public Long getAdminId() {
        return adminId;
    }

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
		    public Long getRoleId() {
        return roleId;
    }

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
