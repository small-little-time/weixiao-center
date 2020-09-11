package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostContentAppView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostContentAppViewDao")
public interface PostContentAppViewDao extends JpaRepository<PostContentAppView, Long>, JpaSpecificationExecutor<PostContentAppView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pc.id," +
                    "pc.student_id," +
                    "pc.content," +
                    "pc.images as image," +
                    "pc.release_time," +
                    "pc.look_num," +
                    "pc.like_num," +
                    "pc.review_state," +
                    "sm.face_img_min AS avatar, " +
                    "sm.nickname " +
                    "FROM " +
                    "z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1 AND " +
                    "pc.review_state = 2 AND " +
                    "pc.state = 1 AND " +
                    "(:valueContent = '' OR pc.content LIKE CONCAT('%', :valueContent, '%')) AND " +
                    "(:sex = 0 OR sm.sex = :sex) AND " +
                    "(pc.category IN :category) AND " +
                    "(:departmentId = 0 OR pc.academy_id = :departmentId) " +
                    "ORDER BY " +
                    "pc.id DESC",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1 AND " +
                    "pc.review_state = 2 AND " +
                    "pc.state = 1 AND " +
                    "(:valueContent = '' OR pc.content LIKE CONCAT('%', :valueContent, '%')) AND " +
                    "(:sex = 0 OR sm.sex = :sex) AND " +
                    "(pc.category IN :category) AND " +
                    "(:departmentId = 0 OR pc.academy_id = :departmentId)")
    Page<PostContentAppView> appList(@Param("valueContent") String valueContent,
                                     @Param("sex") int sex,
                                     @Param("category") List<Long> category,
                                     @Param("departmentId") Long departmentId,
                                     Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pc.id," +
                    "pc.student_id," +
                    "sm.face_img_min AS avatar," +
                    "sm.nickname," +
                    "pc.content," +
                    "pc.images AS image," +
                    "pc.look_num," +
                    "pc.like_num," +
                    "pc.release_time," +
                    "pc.review_state " +
                    "FROM z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE pc.id IN " +
                    "(SELECT pct.content_id FROM z_post_collect pct " +
                    "WHERE pct.student_id = :id AND pct.logic_flag = 1) AND " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE pc.id IN " +
                    "(SELECT pct.content_id FROM z_post_collect pct " +
                    "WHERE pct.student_id = :id AND pct.logic_flag = 1) AND " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1")
    Page<PostContentAppView> getMyCollect(@Param("id") Long id,
                                          Pageable pageable );

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pc.id," +
                    "pc.student_id," +
                    "sm.face_img_min AS avatar," +
                    "sm.nickname,pc.content," +
                    "pc.images AS image,pc.look_num," +
                    "pc.like_num," +
                    "pc.release_time," +
                    "pc.review_state " +
                    "FROM z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.student_id = :id AND " +
                    "pc.logic_flag = 1 AND  " +
                    "sm.logic_flag = 1",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.student_id = :id AND " +
                    "pc.logic_flag = 1 AND  " +
                    "sm.logic_flag = 1")
    Page<PostContentAppView> getMyContent(@Param("id") Long id,
                                          Pageable pageable );

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pc.id," +
                    "pc.student_id," +
                    "pc.content," +
                    "pc.images as image," +
                    "pc.release_time," +
                    "pc.look_num," +
                    "pc.like_num," +
                    "pc.review_state," +
                    "sm.face_img_min AS avatar, " +
                    "sm.nickname " +
                    "FROM " +
                    "z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1 AND " +
                    "pc.review_state = 2 AND " +
                    "pc.state = 1 " +
                    "ORDER BY " +
                    "pc.look_num DESC",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_content pc " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1 AND " +
                    "pc.review_state = 2 AND " +
                    "pc.state = 1 " +
                    "ORDER BY " +
                    "pc.look_num DESC")
    Page<PostContentAppView> appHotList(Pageable pageable);
}
