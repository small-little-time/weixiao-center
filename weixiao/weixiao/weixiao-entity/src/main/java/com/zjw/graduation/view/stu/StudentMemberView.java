package com.zjw.graduation.view.stu;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 学生表视图
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 11:26:42
 */
@Entity
@Table(name = "z_student_member")
public class StudentMemberView implements Serializable {

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
     * 专业名称
     */
    @Column(name = "academy_name")
    private String academyName;
    /**
     * 个人签名
     */
    @Column(name = "autograph")
    private String autograph;

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

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}
