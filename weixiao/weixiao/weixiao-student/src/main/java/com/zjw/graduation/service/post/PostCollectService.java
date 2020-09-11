package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostCollect;
import com.zjw.graduation.model.post.PostCollectUpdateModel;

/**
 * 收藏表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-07 15:00:56
 */
public interface PostCollectService {
    PagingResult<PostCollect> page(int pageIndex, int pageSize);

    PostCollect get(Long id);

    PostCollect save(PostCollect Admin);

    PostCollect update(PostCollect Admin);

    void delete(Long id);

    PostCollect modify(PostCollectUpdateModel postCollectUpdateModel);
}

