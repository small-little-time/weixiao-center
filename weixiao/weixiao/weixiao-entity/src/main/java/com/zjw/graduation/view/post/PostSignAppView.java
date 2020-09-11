package com.zjw.graduation.view.post;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 活动报名表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@Entity
@Table(name = "z_post_sign")
public class PostSignAppView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;
    /**
     *
     */
    @Column(name = "activity_id", nullable = false)
    private Long activityId;
    /**
     *
     */
    @Column(name = "student_id")
    private Long studentId;
    /**
     * qq号码
     */
    @Column(name = "qq")
    private String qq;
    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 备注
     */
    @Column(name = "message")
    private String message;

    /**
     * 创建时间
     */
    @Column(name = "sign_time")
    private LocalDateTime signTime;
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

    @Column(name = "truename")
    private String truename;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private int sex;

    @Column(name = "academy_name")
    private String academyName;

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public LocalDateTime getSignTime() {
        return signTime;
    }

    public void setSignTime(LocalDateTime signTime) {
        this.signTime = signTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
