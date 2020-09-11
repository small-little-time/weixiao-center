package com.zjw.graduation.entity.student;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 学生权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@Entity
@Table(name = "z_student_permission")
@DynamicInsert
@DynamicUpdate
public class StudentPermission implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 父级权限id
	 */
	    @Column(name = "pid")
	private Long pid;
		/**
	 * 名称
	 */
	    @Column(name = "name")
	private String name;
		/**
	 * 权限值
	 */
	    @Column(name = "value")
	private String value;
		/**
	 * 图标
	 */
	    @Column(name = "icon")
	private String icon;
		/**
	 * 权限类型：0-目录 1-菜单 2-按钮（接口绑定权限）
	 */
	    @Column(name = "type")
	private Integer type;
		/**
	 * 前端资源路径
	 */
	    @Column(name = "uri")
	private String uri;
		/**
	 * 启用状态；0-禁用 1-启用
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
		    public Long getPid() {
        return pid;
    }

	public void setPid(Long pid) {
		this.pid = pid;
	}
		    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}
		    public String getValue() {
        return value;
    }

	public void setValue(String value) {
		this.value = value;
	}
		    public String getIcon() {
        return icon;
    }

	public void setIcon(String icon) {
		this.icon = icon;
	}
		    public Integer getType() {
        return type;
    }

	public void setType(Integer type) {
		this.type = type;
	}
		    public String getUri() {
        return uri;
    }

	public void setUri(String uri) {
		this.uri = uri;
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
