package com.zjw.graduation.view.post;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@Entity
@Table(name = "z_post_comment")
public class PostCommentAppView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;
    /**
     * 发布内容主键
     */
    @Column(name = "post_id", nullable = false)
    private Long postId;
    /**
     * 用户主键
     */
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Column(name = "avatar", nullable = false)
    private String avatar;
    @Column(name = "nickname", nullable = false)
    private String nickname;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;
    /**
     * 内容类型 0-所有 1-活动 2-动态 3-热点
     */
    @Column(name = "category")
    private Long category;
    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    private LocalDateTime commentTime;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
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
