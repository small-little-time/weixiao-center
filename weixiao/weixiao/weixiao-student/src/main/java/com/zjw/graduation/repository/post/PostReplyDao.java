package com.zjw.graduation.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.post.PostReply;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 回复表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */

@Repository("PostReplyDao")
public interface PostReplyDao extends JpaRepository<PostReply, Long>, JpaSpecificationExecutor<PostReply> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_reply " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_reply " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<PostReply> findAll(Pageable pageable);
}

