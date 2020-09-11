package com.zjw.graduation.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.post.PostHot;
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
 * 热点内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 18:25:52
 */

@Repository("PostHotDao")
public interface PostHotDao extends JpaRepository<PostHot, Long>, JpaSpecificationExecutor<PostHot> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_hot " +
                    "WHERE " +
                    "`logic_flag` = 1 AND " +
                    "(:title = '' OR title LIKE CONCAT('%',:title,'%')) " ,
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_hot " +
                    "WHERE " +
                    "`logic_flag` = 1 " +
                    "(:title = '' OR title LIKE CONCAT('%',:title,'%'))")
    Page<PostHot> findAll(@Param("title")String title,
                          Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE " +
                    "   z_post_hot " +
                    "SET " +
                    "   `logic_flag` = 0," +
                    "   `updated` = :now " +
                    "WHERE " +
                    "   `id` IN :collect")
    void batchDelete(@Param("collect") List<Long> collect,
                     @Param("now") LocalDateTime now);

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_hot " +
                    "WHERE " +
                    "logic_flag = 1 AND " +
                    "start_time <= :now AND " +
                    "end_time >= :now " +
                    "ORDER BY " +
                    "id DESC ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_hot " +
                    "WHERE " +
                    "logic_flag = 1 AND " +
                    "start_time <= :now AND " +
                    "end_time >= :now " +
                    "ORDER BY " +
                    "id DESC ")
    Page<PostHot> appList(@Param("now") LocalDateTime now,
                          Pageable pageable);
}

