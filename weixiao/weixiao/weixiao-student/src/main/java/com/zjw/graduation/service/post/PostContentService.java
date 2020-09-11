package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostContent;
import com.zjw.graduation.view.post.PostContentAppDetailView;
import com.zjw.graduation.view.post.PostContentAppView;
import com.zjw.graduation.view.post.PostContentView;

/**
 * 发布内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
public interface PostContentService {
    PostContent get(Long id);

    PostContent save(PostContent Admin);

    PostContent update(PostContent Admin);

    void delete(Long id);

    PagingResult<PostContentView> page(String truename, Long academyId, Long categoryId, int reviewState, int state, int pageIndex, int pageSize);

    void enableOrDisable(Long id);

    void review(Long id, int reviewState);

    void batchReview(String ids, int reviewState);

    PagingResult<PostContentAppView> appList(String valueContent, int sex, String category, Long departmentId, int pageIndex, int pageSize);

    PostContentAppDetailView getDetail(Long id, Long studentId);

    PagingResult<PostContentAppView> getMyCollect(Long id, int pageIndex, int pageSize);

    PagingResult<PostContentAppView> getMyContent(Long id, int pageIndex, int pageSize);

    PagingResult<PostContentAppView> appHotList(int pageIndex, int pageSize);
}

