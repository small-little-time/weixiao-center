package com.zjw.graduation.service.post.impl;

import com.zjw.graduation.repository.post.PostCommentAppViewDao;
import com.zjw.graduation.view.post.PostCommentAppView;
import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.post.PostComment;
import com.zjw.graduation.repository.post.PostCommentDao;
import com.zjw.graduation.service.post.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service("postCommentService")
public class PostCommentServiceImpl implements PostCommentService {

    @Autowired
    private PostCommentDao postCommentDao;
    @Autowired
    private PostCommentAppViewDao postCommentAppViewDao;

    public PagingResult<PostComment> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostComment> page = postCommentDao.findAll(pageable);

        PagingResult<PostComment> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PostComment get(Long id) {
        return postCommentDao.findById(id).orElse(new PostComment());
    }

    @Override
    public PostComment save(PostComment postComment) {
        postComment.setCommentTime(LocalDateTime.now());
        return postCommentDao.save(postComment);
    }

    @Override
    public PostComment update(PostComment postComment) {
        return postCommentDao.save(postComment);
    }

    @Override
    public void delete(Long id) {
        PostComment postComment = postCommentDao.findById(id).orElse(null);
        if (postComment != null){
            postComment.setLogicFlag(EnumLogicType.DELETE.getValue());
            postCommentDao.save(postComment);
        }
    }

    @Override
    public PagingResult<PostCommentAppView> appList(Long postId, Long category, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostCommentAppView> page = postCommentAppViewDao.appList(postId, category, pageable);

        PagingResult<PostCommentAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

}
