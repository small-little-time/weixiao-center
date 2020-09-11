package com.zjw.graduation.service.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostCategory;

/**
 * 内容类别表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
public interface PostCategoryService {
    PagingResult<PostCategory> page(int pageIndex, int pageSize);

    PostCategory get(Long id);

    PostCategory save(PostCategory Admin);

    PostCategory update(PostCategory Admin);

    void delete(Long id);
}

