package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostLike;
import com.zjw.graduation.model.post.PostLikeUpdateModel;

/**
 * 点赞表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-21 20:08:05
 */
public interface PostLikeService {
    PagingResult<PostLike> page(int pageIndex, int pageSize);

    PostLike get(Long id);

    PostLike save(PostLike Admin);

    PostLike update(PostLike Admin);

    void delete(Long id);

    PostLike modify(PostLikeUpdateModel postLikeUpdateModel);
}

