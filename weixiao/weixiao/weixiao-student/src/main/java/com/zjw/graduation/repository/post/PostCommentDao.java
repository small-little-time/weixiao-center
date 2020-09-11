package com.zjw.graduation.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.post.PostComment;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */

@Repository("PostCommentDao")
public interface PostCommentDao extends JpaRepository<PostComment, Long>, JpaSpecificationExecutor<PostComment> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_comment " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_comment " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<PostComment> findAll(Pageable pageable);
}

