package com.zjw.graduation.service.post.impl;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.post.PostActivity;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.repository.post.PostActivityAppViewDao;
import com.zjw.graduation.repository.post.PostActivityDao;
import com.zjw.graduation.repository.post.PostActivityViewDao;
import com.zjw.graduation.service.post.PostActivityService;
import com.zjw.graduation.view.post.PostActivityAppView;
import com.zjw.graduation.view.post.PostActivityView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service("postActivityService")
public class PostActivityServiceImpl implements PostActivityService  {

    @Autowired
    private PostActivityDao postActivityDao;

    @Autowired
    private PostActivityViewDao postActivityViewDao;

    @Autowired
    private PostActivityAppViewDao postActivityAppViewDao;

    public PagingResult<PostActivityView> page(String truename,
                                               String title,
                                               Long categoryId,
                                               Long academyId,
                                               int type,
                                               int state,
                                               int pageIndex,
                                               int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostActivityView> page = postActivityViewDao.findAll(truename, title, categoryId, academyId, type ,state, pageable);

        PagingResult<PostActivityView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public void review(Long id, int state) {
        PostActivity postActivity = postActivityDao.findById(id).orElse(null);
        if (postActivity != null){
            postActivity.setState(state);
            postActivity.setUpdated(LocalDateTime.now());
            postActivityDao.save(postActivity);
        }
    }

    @Override
    public void batchPass(String ids, int state) {
        List<Long> collect =
                Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        LocalDateTime now = LocalDateTime.now();
        postActivityDao.batchPass(collect, state, now);
    }

    @Override
    public PagingResult<PostActivityAppView> appList(String title, int sex, int activityState, int activityType, String activityTime, String category, Long departmentId, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        LocalDateTime time;
        if (!activityTime.equals("")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            time = LocalDateTime.parse(activityTime, formatter);
        } else {
            time = null;
        }

        List<Long> collect = new ArrayList<>();
        if (category != null && !category.equals("")) {
            collect = Arrays.stream(category.split(",")).map(Long::parseLong).collect(Collectors.toList());
        }else {
            collect.add(-1L);
        }

        Page<PostActivityAppView> page = postActivityAppViewDao.appList(title, sex, activityState, activityType, time, collect, departmentId, pageable);

        PagingResult<PostActivityAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PagingResult<PostActivityAppView> getMyPublish(Long id, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostActivityAppView> page = postActivityAppViewDao.getMyPublish(id, pageable);

        PagingResult<PostActivityAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());
        return pagingResult;
    }

    @Override
    public void cancel(Long id) {
        PostActivity one = postActivityDao.getOne(id);
        one.setState(5);
        postActivityDao.save(one);
    }

    @Override
    public PagingResult<PostActivityAppView> getMyParticipation(Long id, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostActivityAppView> page = postActivityAppViewDao.getMyParticipation(id, pageable);

        PagingResult<PostActivityAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());
        return pagingResult;
    }

    @Override
    public PagingResult<PostActivityAppView> appHotList(int pageIndex, int pageSize) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostActivityAppView> page = postActivityAppViewDao.appHotList(pageable);

        PagingResult<PostActivityAppView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());
        return pagingResult;
    }

    @Override
    public PostActivity get(Long id) {
        return postActivityDao.findById(id).orElse(new PostActivity());
    }

    @Override
    public PostActivity save(PostActivity postActivity) {
        return postActivityDao.save(postActivity);
    }

    @Override
    public PostActivity update(PostActivity postActivity) {
        return postActivityDao.save(postActivity);
    }

    @Override
    public void delete(Long id) {
        PostActivity postActivity = postActivityDao.findById(id).orElse(null);
        if (postActivity != null){
            postActivity.setLogicFlag(EnumLogicType.DELETE.getValue());
            postActivityDao.save(postActivity);
        }
    }

}
