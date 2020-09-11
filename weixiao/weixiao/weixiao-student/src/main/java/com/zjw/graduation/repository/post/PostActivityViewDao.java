package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostActivityView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("PostActivityViewDao")
public interface PostActivityViewDao extends JpaRepository<PostActivityView, Long>, JpaSpecificationExecutor<PostActivityView> {

    @Query(nativeQuery = true,value =
                    "SELECT " +
                    "   pa.id," +
                    "   pa.student_id," +
                    "   pa.academy_id," +
                    "   pa.title," +
                    "   pa.abs," +
                    "   pa.content," +
                    "   pa.images," +
                    "   pa.release_time," +
                    "   pa.sign_start_time," +
                    "   pa.sign_end_time," +
                    "   pa.max_number," +
                    "   pa.type," +
                    "   pa.state," +
                    "   sm.truename," +
                    "   sa.academy_name," +
                    "   pc.category_name AS category " +
                    "FROM " +
                    "   z_post_activity pa " +
                    "LEFT JOIN " +
                    "   z_student_member sm ON pa.student_id = sm.id AND sm.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "   z_school_academy sa ON pa.academy_id = sa.id AND sa.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "   z_post_category pc ON pa.category = pc.id AND pc.logic_flag = 1 " +
                    "WHERE " +
                    "   pa.logic_flag = 1 AND " +
                    "   (:truename = '' OR sm.truename LIKE CONCAT('%',:truename,'%')) AND " +
                    "   (:title = '' OR pa.title LIKE CONCAT('%',:truename,'%')) AND " +
                    "   (:categoryId = 0 OR pa.category = :categoryId) AND " +
                    "   (:academyId = 0 OR pa.academy_id = :academyId) AND " +
                    "   (:type = 0 OR pa.type = :type) AND " +
                    "   (:state = 0 OR pa.state = :state)" ,
            countQuery =
                    "SELECT " +
                    "   COUNT(*) " +
                    "FROM " +
                    "   z_post_activity pa " +
                    "LEFT JOIN " +
                    "   z_student_member sm ON pa.student_id = sm.id AND sm.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "   z_school_academy sa ON pa.academy_id = sa.id AND sa.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "   z_post_category pc ON pa.category = pc.id AND pc.logic_flag = 1 " +
                    "WHERE " +
                    "   pa.logic_flag = 1 AND " +
                    "   (:truename = '' OR sm.truename LIKE CONCAT('%',:truename,'%')) AND " +
                    "   (:title = '' OR pa.title LIKE CONCAT('%',:title,'%')) AND " +
                    "   (:categoryId = 0 OR pa.category = :categoryId) AND " +
                    "   (:academyId = 0 OR pa.academy_id = :academyId) AND " +
                    "   (:type = 0 OR pa.type = :type) AND " +
                    "   (:state = 0 OR pa.state = :state)" )
    Page<PostActivityView> findAll(@Param("truename") String truename,
                                   @Param("title")String title,
                                   @Param("categoryId")Long categoryId,
                                   @Param("academyId")Long academyId,
                                   @Param("type")int type,
                                   @Param("state")int state,
                                   Pageable pageable);
}
