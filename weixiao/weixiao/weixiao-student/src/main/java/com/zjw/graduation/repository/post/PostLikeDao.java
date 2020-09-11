package com.zjw.graduation.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.post.PostLike;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 点赞表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-21 20:08:05
 */

@Repository("PostLikeDao")
public interface PostLikeDao extends JpaRepository<PostLike, Long>, JpaSpecificationExecutor<PostLike> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_like " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_like " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<PostLike> findAll(Pageable pageable);

    PostLike findByStudentIdAndContentId(Long studentId, Long contentId);
}

