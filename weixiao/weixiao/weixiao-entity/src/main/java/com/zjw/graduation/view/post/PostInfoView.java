package com.zjw.graduation.view.post;

import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApiModel(value = "post.PostHotDto", description = "发布数量")
@Entity
public class PostInfoView {

    @Id
    @Column(name = "content_num")
    private int contentNum;

    @Column(name = "collect_num")
    private int collectNum;

    @Column(name = "activity_publish_num")
    private int activityPublishNum;

    @Column(name = "activity_sign_num")
    private int activitySignNum;

    public int getActivityPublishNum() {
        return activityPublishNum;
    }

    public void setActivityPublishNum(int activityPublishNum) {
        this.activityPublishNum = activityPublishNum;
    }

    public int getActivitySignNum() {
        return activitySignNum;
    }

    public void setActivitySignNum(int activitySignNum) {
        this.activitySignNum = activitySignNum;
    }

    public int getContentNum() {
        return contentNum;
    }

    public void setContentNum(int contentNum) {
        this.contentNum = contentNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

}
