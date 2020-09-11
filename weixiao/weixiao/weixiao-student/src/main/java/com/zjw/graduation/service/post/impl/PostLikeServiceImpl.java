package com.zjw.graduation.service.post.impl;

import com.zjw.graduation.entity.post.PostContent;
import com.zjw.graduation.model.post.PostLikeUpdateModel;
import com.zjw.graduation.repository.post.PostContentDao;
import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.post.PostLike;
import com.zjw.graduation.repository.post.PostLikeDao;
import com.zjw.graduation.service.post.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service("postLikeService")
public class PostLikeServiceImpl implements PostLikeService  {

    @Autowired
    private PostLikeDao postLikeDao;

    @Autowired
    private PostContentDao postContentDao;

    public PagingResult<PostLike> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostLike> page = postLikeDao.findAll(pageable);

        PagingResult<PostLike> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PostLike get(Long id) {
        return postLikeDao.findById(id).orElse(new PostLike());
    }

    @Override
    @Transactional
    public PostLike save(PostLike postLike) {
        PostLike entity = postLikeDao.findByStudentIdAndContentId(postLike.getStudentId(), postLike.getContentId());
        PostContent one = postContentDao.getOne(postLike.getContentId());
        one.setLikeNum(one.getLikeNum() + 1);
        postContentDao.save(one);
        if (entity == null){
            return postLikeDao.save(postLike);
        } else {
            entity.setLogicFlag(EnumLogicType.NORMAL.getValue());
            entity.setUpdated(LocalDateTime.now());
            postLikeDao.save(entity);
            return entity;
        }
    }

    @Override
    public PostLike update(PostLike postLike) {
        return postLikeDao.save(postLike);
    }

    @Override
    public void delete(Long id) {
        PostLike postLike = postLikeDao.findById(id).orElse(null);
        if (postLike != null){
            postLike.setLogicFlag(EnumLogicType.DELETE.getValue());
            postLikeDao.save(postLike);
        }
    }

    @Override
    @Transactional
    public PostLike modify(PostLikeUpdateModel postLikeUpdateModel) {
        PostLike entity = postLikeDao.findByStudentIdAndContentId(postLikeUpdateModel.getStudentId(), postLikeUpdateModel.getContentId());
        if (entity != null) {
            entity.setLogicFlag(EnumLogicType.DELETE.getValue());
            entity.setUpdated(LocalDateTime.now());
            postLikeDao.save(entity);
            PostContent one = postContentDao.getOne(entity.getId());
            one.setLikeNum(one.getLikeNum() - 1);
            postContentDao.save(one);
            return entity;
        }
        return null;
    }

}
