package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostSignAppView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("PostSignAppViewDao")
public interface PostSignAppViewDao extends JpaRepository<PostSignAppView, Long>,JpaSpecificationExecutor<PostSignAppView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "ps.*," +
                    "sm.truename," +
                    "sm.face_img_min AS avatar," +
                    "sm.sex," +
                    "sm.age," +
                    "sa." +
                    "academy_name " +
                    "FROM " +
                    "z_post_sign ps " +
                    "LEFT JOIN " +
                    "z_student_member sm ON ps.student_id = sm.id " +
                    "LEFT JOIN " +
                    "z_school_academy sa ON sa.id = sm.academy_id " +
                    "WHERE " +
                    "ps.activity_id = :activityId AND " +
                    "ps.logic_flag = 1 AND " +
                    "sm.logic_flag = 1",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_sign ps " +
                    "LEFT JOIN " +
                    "z_student_member sm ON ps.student_id = sm.id " +
                    "LEFT JOIN " +
                    "z_school_academy sa ON sa.id = sm.academy_id " +
                    "WHERE " +
                    "ps.activity_id = :activityId AND " +
                    "ps.logic_flag = 1 AND " +
                    "sm.logic_flag = 1")
    Page<PostSignAppView> signList(@Param("activityId") Long activityId,
                                   Pageable pageable);
}
