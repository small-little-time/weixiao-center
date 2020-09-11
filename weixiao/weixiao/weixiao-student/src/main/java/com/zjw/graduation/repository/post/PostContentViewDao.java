package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostContentView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("PostContentViewDao")
public interface PostContentViewDao extends JpaRepository<PostContentView, Long>, JpaSpecificationExecutor<PostContentView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pc.id," +
                    "pc.student_id," +
                    "sm.truename," +
                    "sa.academy_name," +
                    "pc.academy_id," +
                    "pc.category," +
                    "pcy.category_name," +
                    "pc.content," +
                    "pc.images," +
                    "pc.release_time," +
                    "pc.look_num," +
                    "pc.like_num," +
                    "pc.review_state," +
                    "pc.state," +
                    "pc.created," +
                    "pc.updated," +
                    "pc.logic_flag " +
                    "FROM " +
                    "z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id AND sm.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_school_academy sa ON pc.academy_id = sa.id AND sa.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_post_category pcy ON pc.category = pcy.id AND pcy.logic_flag = 1 " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "(:truename= '' OR sm.truename LIKE CONCAT('%',:truename,'%')) AND " +
                    "(:academyId = 0 OR pc.academy_id = :academyId) AND " +
                    "(:categoryId = 0 OR pc.category = :categoryId) AND " +
                    "(:reviewState = 0 OR pc.review_state = :reviewState) AND " +
                    "(:state = 0 OR pc.state = :state) ",
            countQuery =
                    "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id AND sm.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_school_academy sa ON pc.academy_id = sa.id AND sa.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_post_category pcy ON pc.category = pcy.id AND pcy.logic_flag = 1 " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "(:truename= '' OR sm.truename LIKE CONCAT('%',:truename,'%')) AND " +
                    "(:academyId = 0 OR pc.academy_id = :academyId) AND " +
                    "(:categoryId = 0 OR pc.category = :categoryId) AND " +
                    "(:reviewState = 0 OR pc.review_state = :reviewState) AND " +
                    "(:state = 0 OR pc.state = :state) ")
    Page<PostContentView> findAll(@Param("truename") String truename,
                                  @Param("academyId") Long academyId,
                                  @Param("categoryId") Long categoryId,
                                  @Param("reviewState") int reviewState,
                                  @Param("state") int state,
                                  Pageable pageable);
}
