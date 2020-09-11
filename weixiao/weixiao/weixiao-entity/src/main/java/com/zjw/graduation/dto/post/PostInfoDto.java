package com.zjw.graduation.dto.post;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "post.PostHotDto", description = "发布数量")
public class PostInfoDto {

    private int contentNum;

    private int collectNum;

    private int activityPublishNum;

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
