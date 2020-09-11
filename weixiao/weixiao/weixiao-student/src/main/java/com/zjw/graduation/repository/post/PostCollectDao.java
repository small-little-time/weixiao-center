package com.zjw.graduation.repository.post;

import com.zjw.graduation.entity.post.PostCollect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 收藏表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-07 15:00:56
 */

@Repository("PostCollectDao")
public interface PostCollectDao extends JpaRepository<PostCollect, Long>, JpaSpecificationExecutor<PostCollect> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_collect " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_collect " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<PostCollect> findAll(Pageable pageable);

    PostCollect findByStudentIdAndContentId(Long studentId, Long contentId);
}

