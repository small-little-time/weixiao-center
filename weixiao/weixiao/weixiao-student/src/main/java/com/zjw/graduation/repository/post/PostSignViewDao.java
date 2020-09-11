package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostSignView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("PostSignViewDao")
public interface PostSignViewDao extends JpaRepository<PostSignView, Long>, JpaSpecificationExecutor<PostSignView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "ps.id," +
                    "ps.activity_id," +
                    "ps.student_id," +
                    "sm.truename," +
                    "sa.academy_name," +
                    "ps.qq,ps.phone," +
                    "ps.message," +
                    "ps.sign_time," +
                    "ps.created," +
                    "ps.updated," +
                    "ps.logic_flag " +
                    "FROM " +
                    "z_post_sign ps " +
                    "LEFT JOIN " +
                    "z_student_member sm ON ps.student_id = sm.id AND sm.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_school_academy sa ON sm.academy_id = sa.id AND sa.logic_flag = 1 " +
                    "WHERE " +
                    "ps.logic_flag = 1 AND " +
                    "(:activityId = 0 OR ps.activity_id = :activityId) AND " +
                    "(:truename = '' OR sm.truename LIKE CONCAT('%',:truename,'%'))" ,
            countQuery =
                    "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_sign ps " +
                    "LEFT JOIN " +
                    "z_student_member sm ON ps.student_id = sm.id AND sm.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_school_academy sa ON sm.academy_id = sa.id AND sa.logic_flag = 1 " +
                    "WHERE " +
                    "ps.logic_flag = 1 AND " +
                    "(:activityId = 0 OR ps.activity_id = :activityId) AND " +
                    "(:truename = '' OR sm.truename LIKE CONCAT('%',:truename,'%'))")
    Page<PostSignView> findAll(@Param("activityId") Long activityId,
                               @Param("truename") String truename,
                               Pageable pageable);
}
