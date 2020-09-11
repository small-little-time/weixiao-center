package com.zjw.graduation.service.post.impl;

import com.zjw.graduation.model.post.PostCollectUpdateModel;
import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.post.PostCollect;
import com.zjw.graduation.repository.post.PostCollectDao;
import com.zjw.graduation.service.post.PostCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service("postCollectService")
public class PostCollectServiceImpl implements PostCollectService  {

    @Autowired
    private PostCollectDao postCollectDao;

    public PagingResult<PostCollect> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostCollect> page = postCollectDao.findAll(pageable);

        PagingResult<PostCollect> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PostCollect get(Long id) {
        return postCollectDao.findById(id).orElse(new PostCollect());
    }

    @Override
    public PostCollect save(PostCollect postCollect) {
        PostCollect entity = postCollectDao.findByStudentIdAndContentId(postCollect.getStudentId(), postCollect.getContentId());
        if (entity == null){
            return postCollectDao.save(postCollect);
        } else {
            entity.setLogicFlag(EnumLogicType.NORMAL.getValue());
            entity.setUpdated(LocalDateTime.now());
            postCollectDao.save(entity);
            return entity;
        }
    }

    @Override
    public PostCollect update(PostCollect postCollect) {
        return postCollectDao.save(postCollect);
    }

    @Override
    public void delete(Long id) {
        PostCollect postCollect = postCollectDao.findById(id).orElse(null);
        if (postCollect != null){
            postCollect.setLogicFlag(EnumLogicType.DELETE.getValue());
            postCollectDao.save(postCollect);
        }
    }

    @Override
    public PostCollect modify(PostCollectUpdateModel postCollectUpdateModel) {
        PostCollect entity = postCollectDao.findByStudentIdAndContentId(postCollectUpdateModel.getStudentId(), postCollectUpdateModel.getContentId());
        if (entity != null) {
            entity.setUpdated(LocalDateTime.now());
            return postCollectDao.save(entity);
        }
        return null;
    }

}
