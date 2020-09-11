package com.zjw.graduation.service.post.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.post.PostReply;
import com.zjw.graduation.repository.post.PostReplyDao;
import com.zjw.graduation.service.post.PostReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("postReplyService")
public class PostReplyServiceImpl implements PostReplyService  {

    @Autowired
    private PostReplyDao postReplyDao;

    public PagingResult<PostReply> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<PostReply> page = postReplyDao.findAll(pageable);

        PagingResult<PostReply> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public PostReply get(Long id) {
        return postReplyDao.findById(id).orElse(new PostReply());
    }

    @Override
    public PostReply save(PostReply postReply) {
        return postReplyDao.save(postReply);
    }

    @Override
    public PostReply update(PostReply postReply) {
        return postReplyDao.save(postReply);
    }

    @Override
    public void delete(Long id) {
        PostReply postReply = postReplyDao.findById(id).orElse(null);
        if (postReply != null){
            postReply.setLogicFlag(EnumLogicType.DELETE.getValue());
            postReplyDao.save(postReply);
        }
    }

}
