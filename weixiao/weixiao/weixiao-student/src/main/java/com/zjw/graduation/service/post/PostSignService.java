package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostSign;
import com.zjw.graduation.view.post.PostSignAppView;
import com.zjw.graduation.view.post.PostSignView;

/**
 * 活动报名表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
public interface PostSignService {

    PostSign get(Long id);

    PostSign save(PostSign Admin);

    PostSign update(PostSign Admin);

    void delete(Long id);

    PagingResult<PostSignView> page(Long activityId, String truename, int pageIndex, int pageSize);

    void cancel(Long activityId, Long studentId);

    boolean check(Long activityId, Long studentId);

    PagingResult<PostSignAppView> signList(Long activityId, int pageIndex, int pageSize);
}

