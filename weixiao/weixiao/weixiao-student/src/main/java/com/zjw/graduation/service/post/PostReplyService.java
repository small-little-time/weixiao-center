package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostReply;

/**
 * 回复表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
public interface PostReplyService {
    PagingResult<PostReply> page(int pageIndex, int pageSize);

    PostReply get(Long id);

    PostReply save(PostReply Admin);

    PostReply update(PostReply Admin);

    void delete(Long id);
}

