package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostActivityAppView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("PostActivityAppViewDao")
public interface PostActivityAppViewDao extends JpaRepository<PostActivityAppView, Long>, JpaSpecificationExecutor<PostActivityAppView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pa.id," +
                    "pa.student_id," +
                    "sm.nickname," +
                    "sm.face_img_min AS avatar," +
                    "pa.academy_id," +
                    "pa.title," +
                    "pa.abs," +
                    "pa.content," +
                    "pa.images," +
                    "pa.category," +
                    "pa.start_time," +
                    "pa.end_time," +
                    "pa.release_time," +
                    "pa.type," +
                    "pa.max_number," +
                    "pa.state," +
                    "IF(ps1.sign_number IS NULL,0,ps1.sign_number) AS sign_number " +
                    "FROM " +
                    "z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) AND " +
                    "(pa.category IN :collect) AND" +
                    "(:title = '' OR pa.title LIKE CONCAT('%', :title, '%')) AND " +
                    "(:sex = 0 OR sm.sex = :sex) AND " +
                    "(:activityState = 0 OR pa.state = :activityState) AND " +
                    "(:activityType = 0 OR pa.type = :activityType) AND " +
                    "(:dateTime IS NULL OR (:dateTime >= pa.start_time AND :dateTime <= pa.end_time)) AND " +
                    "(:departmentId = 0 OR pa.academy_id = :departmentId)" +
                    "ORDER BY " +
                    "pa.id DESC",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) AND " +
                    "(:title = '' OR pa.title LIKE CONCAT('%', :title, '%')) AND " +
                    "(pa.category IN :collect) AND" +
                    "(:sex = 0 OR sm.sex = :sex) AND " +
                    "(:activityState = 0 OR pa.state = :activityState) AND " +
                    "(:activityType = 0 OR pa.type = :activityType) AND " +
                    "(:dateTime IS NULL OR (:dateTime >= pa.start_time AND :dateTime <= pa.end_time)) AND " +
                    "(:departmentId = 0 OR pa.academy_id = :departmentId)")
    Page<PostActivityAppView> appList(@Param("title") String title,
                                      @Param("sex") int sex,
                                      @Param("activityState") int activityState,
                                      @Param("activityType") int activityType,
                                      @Param("dateTime") LocalDateTime dateTime,
                                      @Param("collect") List<Long> collect,
                                      @Param("departmentId") Long departmentId,
                                      Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pa.id," +
                    "pa.student_id," +
                    "sm.nickname," +
                    "sm.face_img_min AS avatar," +
                    "pa.academy_id," +
                    "pa.title," +
                    "pa.abs," +
                    "pa.content," +
                    "pa.images," +
                    "pa.category," +
                    "pa.start_time," +
                    "pa.end_time," +
                    "pa.release_time," +
                    "pa.type," +
                    "pa.max_number," +
                    "pa.state," +
                    "IF(ps1.sign_number IS NULL,0,ps1.sign_number) AS sign_number " +
                    "FROM " +
                    "z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) AND " +
                    "(pa.student_id = :id)" +
                    "ORDER BY " +
                    "pa.id DESC",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) AND " +
                    "(pa.student_id = :id)" +
                    "ORDER BY " +
                    "pa.id DESC")
    Page<PostActivityAppView> getMyPublish(@Param("id") Long id,
                                           Pageable pageable);


    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pa.id," +
                    "pa.student_id," +
                    "sm.nickname," +
                    "sm.face_img_min AS avatar," +
                    "pa.academy_id," +
                    "pa.title," +
                    "pa.abs," +
                    "pa.content," +
                    "pa.images," +
                    "pa.category," +
                    "pa.start_time," +
                    "pa.end_time," +
                    "pa.release_time," +
                    "pa.type," +
                    "pa.max_number," +
                    "pa.state," +
                    "IF(ps1.sign_number IS NULL,0,ps1.sign_number) AS sign_number " +
                    "FROM " +
                    "z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) AND " +
                    "(pa.id IN (SELECT activity_id FROM z_post_sign WHERE student_id = :id AND logic_flag = 1))" +
                    "ORDER BY " +
                    "pa.id DESC",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) AND " +
                    "(pa.id IN (SELECT activity_id FROM z_post_sign WHERE student_id = :id AND logic_flag = 1))" +
                    "ORDER BY " +
                    "pa.id DESC")
    Page<PostActivityAppView> getMyParticipation(@Param("id") Long id,
                                                 Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pa.id," +
                    "pa.student_id," +
                    "sm.nickname," +
                    "sm.face_img_min AS avatar," +
                    "pa.academy_id," +
                    "pa.title," +
                    "pa.abs," +
                    "pa.content," +
                    "pa.images," +
                    "pa.category," +
                    "pa.start_time," +
                    "pa.end_time," +
                    "pa.release_time," +
                    "pa.type," +
                    "pa.max_number," +
                    "pa.state," +
                    "IF(ps1.sign_number IS NULL,0,ps1.sign_number) AS sign_number " +
                    "FROM " +
                    "z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) " +
                    "ORDER BY " +
                    "sign_number DESC",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_activity pa " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pa.student_id = sm.id " +
                    "LEFT JOIN " +
                    "(SELECT " +
                    "ps.activity_id," +
                    "COUNT(*) AS sign_number " +
                    "FROM z_post_sign ps " +
                    "WHERE ps.logic_flag = 1 " +
                    "GROUP BY ps.activity_id) ps1 ON ps1.activity_id = pa.id " +
                    "WHERE " +
                    "(pa.logic_flag = 1) " +
                    "ORDER BY " +
                    "sign_number DESC")
    Page<PostActivityAppView> appHotList(Pageable pageable);
}
