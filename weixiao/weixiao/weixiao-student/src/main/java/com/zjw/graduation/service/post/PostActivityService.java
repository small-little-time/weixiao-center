package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostActivity;
import com.zjw.graduation.view.post.PostActivityAppView;
import com.zjw.graduation.view.post.PostActivityView;

/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
public interface PostActivityService {

    PostActivity get(Long id);

    PostActivity save(PostActivity Admin);

    PostActivity update(PostActivity Admin);

    void delete(Long id);

    PagingResult<PostActivityView> page(String truename, String title, Long categoryId, Long academyId, int type, int state, int pageIndex, int pageSize);

    void review(Long id, int state);

    void batchPass(String ids, int state);

    PagingResult<PostActivityAppView> appList(String title, int sex, int activityState, int activityType, String activityTime, String category, Long departmentId, int pageIndex, int pageSize);

    PagingResult<PostActivityAppView> getMyPublish(Long id, int pageIndex, int pageSize);

    void cancel(Long id);

    PagingResult<PostActivityAppView> getMyParticipation(Long id, int pageIndex, int pageSize);

    PagingResult<PostActivityAppView> appHotList(int pageIndex, int pageSize);
}

