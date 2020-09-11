package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostContentAppDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("PostContentAppDetailViewDao")
public interface PostContentAppDetailViewDao  extends JpaRepository<PostContentAppDetailView, Long>, JpaSpecificationExecutor<PostContentAppDetailView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "sm.nickname," +
                    "sm.face_img_min AS avatar," +
                    "pct.*," +
                    "IF(pl.id IS NULL ,'false', 'true') as `like`," +
                    "IF(pcc.id IS NULL ,'false', 'true') as `collect` FROM " +
                    "z_post_content pct " +
                    "LEFT JOIN " +
                    "z_post_like pl ON pl.student_id = :studentId AND pl.content_id = :id AND pl.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_post_collect pcc ON pcc.student_id = :studentId AND pcc.content_id = :id AND pcc.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "z_student_member sm ON pct.student_id = sm.id " +
                    "WHERE " +
                    "pct.logic_flag = 1 AND " +
                    "pct.id = :id")
    PostContentAppDetailView getDetail(@Param("id") Long id,
                                       @Param("studentId") Long studentId);
}
