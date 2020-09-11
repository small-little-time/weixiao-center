package com.zjw.graduation.service.post.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.post.PostCategory;
import com.zjw.graduation.repository.post.PostCategoryDao;
import com.zjw.graduation.service.post.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("postCategoryService")
public class PostCategoryServiceImpl implements PostCategoryService  {

    @Autowired
    private PostCategoryDao postCategoryDao;

    public PagingResult<PostCategory> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostCategory> page = postCategoryDao.findAll(pageable);

        PagingResult<PostCategory> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PostCategory get(Long id) {
        return postCategoryDao.findById(id).orElse(new PostCategory());
    }

    @Override
    public PostCategory save(PostCategory postCategory) {
        return postCategoryDao.save(postCategory);
    }

    @Override
    public PostCategory update(PostCategory postCategory) {
        return postCategoryDao.save(postCategory);
    }

    @Override
    public void delete(Long id) {
        PostCategory postCategory = postCategoryDao.findById(id).orElse(null);
        if (postCategory != null){
            postCategory.setLogicFlag(EnumLogicType.DELETE.getValue());
            postCategoryDao.save(postCategory);
        }
    }

}
