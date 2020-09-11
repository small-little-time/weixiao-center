package com.zjw.graduation.view.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@Entity
@Table(name = "z_post_activity")
public class PostActivityAppView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;
    /**
     * 发布者主键
     */
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    /**
     * 发布者主键
     */
    @Column(name = "nickname", nullable = false)
    private String nickname;
    /**
     * 院部主键
     */
    @Column(name = "academy_id", nullable = false)
    private Long academyId;

    @Column(name = "avatar", nullable = false)
    private String avatar;
    /**
     * 标题
     */
    @Column(name = "title")
    private String title;
    /**
     * 摘要
     */
    @Column(name = "abs")
    private String abs;
    /**
     * 内容
     */
    @Column(name = "content")
    private String content;
    /**
     * 图片
     */
    @Column(name = "images")
    private String image;
    /**
     * 活动类型
     */
    @Column(name = "category")
    private Long category;
    /**
     * 发布时间
     */
    @Column(name = "release_time")
    private LocalDateTime releaseTime;
    /**
     * 活动类型 1-组织活动 2-报名活动
     */
    @Column(name = "type")
    private Integer type;
    /**
     * 报名开始时间
     */
    @Column(name = "start_time")
    private LocalDateTime startTime;
    /**
     * 报名截止时间
     */
    @Column(name = "end_time")
    private LocalDateTime endTime;
    /**
     * 人数上限
     */
    @Column(name = "max_number")
    private Integer maxNumber;

    @Column(name = "sign_number")
    private int signNumber;

    @Column(name = "state")
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getCategory() {
        return category;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public int getSignNumber() {
        return signNumber;
    }

    public void setSignNumber(int signNumber) {
        this.signNumber = signNumber;
    }

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

    public Long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
