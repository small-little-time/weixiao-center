package com.zjw.graduation.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.post.PostSign;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 活动报名表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */

@Repository("PostSignDao")
public interface PostSignDao extends JpaRepository<PostSign, Long>, JpaSpecificationExecutor<PostSign> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_post_sign " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_sign " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<PostSign> findAll(Pageable pageable);

    PostSign findByActivityIdAndStudentIdAndLogicFlagIs(Long activityId, Long studentId, Integer value);
}

