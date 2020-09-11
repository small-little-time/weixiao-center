package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostCommentAppView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("PostCommentAppViewDao")
public interface PostCommentAppViewDao extends JpaRepository<PostCommentAppView, Long>, JpaSpecificationExecutor<PostCommentAppView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "pc.*," +
                    "sm.face_img AS avatar," +
                    "sm.nickname " +
                    "FROM " +
                    "z_post_comment pc " +
                    "LEFT JOIN " +
                    "z_student_member sm " +
                    "ON " +
                    "pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1 AND " +
                    "pc.category = :category AND " +
                    "pc.post_id = :postId " +
                    "ORDER BY " +
                    "pc.id DESC",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_post_comment pc " +
                    "LEFT JOIN " +
                    "z_student_member sm " +
                    "ON " +
                    "pc.student_id = sm.id " +
                    "WHERE " +
                    "pc.logic_flag = 1 AND " +
                    "sm.logic_flag = 1 AND " +
                    "pc.category = :category AND " +
                    "pc.post_id = :postId")
    Page<PostCommentAppView> appList(@Param("postId")Long postId,
                                     @Param("category") Long category,
                                     Pageable pageable);
}
