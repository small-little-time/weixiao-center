package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostComment;
import com.zjw.graduation.view.post.PostCommentAppView;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
public interface PostCommentService {
    PagingResult<PostComment> page(int pageIndex, int pageSize);

    PostComment get(Long id);

    PostComment save(PostComment Admin);

    PostComment update(PostComment Admin);

    void delete(Long id);

    PagingResult<PostCommentAppView> appList(Long postId, Long category, int pageIndex, int pageSize);
}

