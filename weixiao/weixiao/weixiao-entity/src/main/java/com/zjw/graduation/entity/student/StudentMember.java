package com.zjw.graduation.entity.student;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 学生表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-25 10:30:03
 */
@Entity
@Table(name = "z_student_member")
@DynamicInsert
@DynamicUpdate
public class StudentMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;
    /**
     * 用户名
     */
    @Column(name = "username", nullable = false)
    private String username;
    /**
     * 密码
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 姓名
     */
    @Column(name = "truename", nullable = false)
    private String truename;
    /**
     * 昵称
     */
    @Column(name = "nickname", nullable = false)
    private String nickname;
    /**
     * 性别 0-不详 1-男 2-女
     */
    @Column(name = "sex")
    private Integer sex;
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;
    /**
     * 地区
     */
    @Column(name = "area")
    private String area;

    @Column(name = "area_id")
    private Long areaId;
    /**
     * 学号
     */
    @Column(name = "number", nullable = false)
    private String number;
    /**
     * 手机号
     */
    @Column(name = "phone", nullable = false)
    private String phone;
    /**
     * 头像
     */
    @Column(name = "face_img")
    private String faceImg;
    /**
     * 聊天头像
     */
    @Column(name = "face_img_min")
    private String faceImgMin;
    /**
     * 专业id
     */
    @Column(name = "academy_id")
    private Long academyId;
    /**
     * 个人签名
     */
    @Column(name = "autograph")
    private String autograph;
    /**
     * 是否隐藏个人信息 1-不隐藏 2-隐藏
     */
    @Column(name = "hide")
    private Integer hide;
    /**
     * 状态 0-禁用 1-启用
     */
    @Column(name = "state")
    private Integer state;
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

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getFaceImgMin() {
        return faceImgMin;
    }

    public void setFaceImgMin(String faceImgMin) {
        this.faceImgMin = faceImgMin;
    }

    public Long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
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
