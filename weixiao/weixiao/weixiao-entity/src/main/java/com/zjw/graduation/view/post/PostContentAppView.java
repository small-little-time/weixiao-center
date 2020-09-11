package com.zjw.graduation.view.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "z_post_content")
public class PostContentAppView {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "release_time", nullable = false)
    private LocalDateTime releaseTime;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "look_num", nullable = false)
    private int lookNum;

    @Column(name = "like_num", nullable = false)
    private int likeNum;

    @Column(name = "review_state", nullable = false)
    private int reviewState;

    public int getReviewState() {
        return reviewState;
    }

    public void setReviewState(int reviewState) {
        this.reviewState = reviewState;
    }

    public int getLookNum() {
        return lookNum;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getImages() {
        return image;
    }

    public void setImages(String image) {
        this.image = image;
    }
}
