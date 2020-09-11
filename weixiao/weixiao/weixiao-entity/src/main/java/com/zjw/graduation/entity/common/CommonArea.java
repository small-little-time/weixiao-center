package com.zjw.graduation.entity.common;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;


/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-23 10:04:49
 */
@Entity
@Table(name = "z_common_area")
@DynamicInsert
@DynamicUpdate
public class CommonArea implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 编号
	 */
		@Column(name = "number", nullable = false)
	private Integer number;
    	/**
	 * 名称
	 */
	    @Column(name = "name")
	private String name;
		/**
	 * 城市类型
	 */
	    @Column(name = "area_type")
	private Integer areaType;
		/**
	 * 父城市编号
	 */
	    @Column(name = "parent_number")
	private Integer parentNumber;
	

	    public Long getId() {
        return id;
    }

	public void setId(Long id) {
		this.id = id;
	}
		    public Integer getNumber() {
        return number;
    }

	public void setNumber(Integer number) {
		this.number = number;
	}
		    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}
		    public Integer getAreaType() {
        return areaType;
    }

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
		    public Integer getParentNumber() {
        return parentNumber;
    }

	public void setParentNumber(Integer parentNumber) {
		this.parentNumber = parentNumber;
	}
	
    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
