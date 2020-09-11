package com.zjw.graduation.service.post.impl;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostContent;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.repository.post.PostContentAppDetailViewDao;
import com.zjw.graduation.repository.post.PostContentAppViewDao;
import com.zjw.graduation.repository.post.PostContentDao;
import com.zjw.graduation.repository.post.PostContentViewDao;
import com.zjw.graduation.service.post.PostContentService;
import com.zjw.graduation.view.post.PostContentAppDetailView;
import com.zjw.graduation.view.post.PostContentAppView;
import com.zjw.graduation.view.post.PostContentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service("postContentService")
public class PostContentServiceImpl implements PostContentService  {

    @Autowired
    private PostContentDao postContentDao;

    @Autowired
    private PostContentViewDao postContentViewDao;

    @Autowired
    private PostContentAppViewDao postContentAppViewDao;

    @Autowired
    private PostContentAppDetailViewDao postContentAppDetailViewDao;

    public PagingResult<PostContentView> page(String truename, Long academyId, Long categoryId, int reviewState, int state, int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostContentView> page = postContentViewDao.findAll(truename, academyId, categoryId, reviewState, state,pageable);

        PagingResult<PostContentView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public void enableOrDisable(Long id) {
        PostContent postContent = postContentDao.findById(id).orElse(null);
        if (postContent != null){
            postContent.setState(postContent.getState().equals(1) ? 2 : 1);
            postContent.setUpdated(LocalDateTime.now());
            postContentDao.save(postContent);
        }
    }

    @Override
    public void review(Long id, int reviewState) {
        PostContent postContent = postContentDao.findById(id).orElse(null);
        if (postContent != null){
            postContent.setReviewState(reviewState);
            postContent.setUpdated(LocalDateTime.now());
            postContentDao.save(postContent);
        }
    }

    @Override
    public void batchReview(String ids, int reviewState) {
        List<Long> collect =
                Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        LocalDateTime now = LocalDateTime.now();
        postContentDao.batchReview(collect, reviewState, now);
    }

    @Override
    public PagingResult<PostContentAppView> appList(String valueContent, int sex, String category, Long departmentId, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        List<Long> collect = new ArrayList<>();
        if (category != null && !category.equals("")) {
            collect = Arrays.stream(category.split(",")).map(Long::parseLong).collect(Collectors.toList());
        }else {
            collect.add(-1L);
        }

        Page<PostContentAppView> page = postContentAppViewDao.appList(valueContent, sex, collect, departmentId, pageable);

        PagingResult<PostContentAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PostContentAppDetailView getDetail(Long id, Long studentId) {
        PostContent one = postContentDao.getOne(id);
        one.setLookNum(one.getLookNum() + 1);
        postContentDao.save(one);
        return postContentAppDetailViewDao.getDetail(id, studentId);
    }

    @Override
    public PagingResult<PostContentAppView> getMyCollect(Long id, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<PostContentAppView> page = postContentAppViewDao.getMyCollect(id, pageable);

        PagingResult<PostContentAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PagingResult<PostContentAppView> getMyContent(Long id, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<PostContentAppView> page = postContentAppViewDao.getMyContent(id, pageable);

        PagingResult<PostContentAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PagingResult<PostContentAppView> appHotList(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<PostContentAppView> page = postContentAppViewDao.appHotList(pageable);

        PagingResult<PostContentAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PostContent get(Long id) {
        return postContentDao.findById(id).orElse(new PostContent());
    }

    @Override
    public PostContent save(PostContent postContent) {
        return postContentDao.save(postContent);
    }

    @Override
    public PostContent update(PostContent postContent) {
        return postContentDao.save(postContent);
    }

    @Override
    public void delete(Long id) {
        PostContent postContent = postContentDao.findById(id).orElse(null);
        if (postContent != null){
            postContent.setLogicFlag(EnumLogicType.DELETE.getValue());
            postContentDao.save(postContent);
        }
    }

}
