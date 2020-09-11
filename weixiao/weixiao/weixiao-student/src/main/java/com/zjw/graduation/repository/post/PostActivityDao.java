package com.zjw.graduation.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.post.PostActivity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */

@Repository("PostActivityDao")
public interface PostActivityDao extends JpaRepository<PostActivity, Long>, JpaSpecificationExecutor<PostActivity> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_activity " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_activity " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<PostActivity> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE " +
                    "z_post_activity " +
                    "SET " +
                    "state = :state, " +
                    "updated = :now " +
                    "WHERE " +
                    "id IN :collect")
    void batchPass(@Param("collect") List<Long> collect,
                   @Param("state") int state,
                   @Param("now") LocalDateTime now);
}

