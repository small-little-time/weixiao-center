package com.zjw.graduation.repository.post;

import com.zjw.graduation.view.post.PostInfoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostInfoViewDao extends JpaRepository<PostInfoView, Long>, JpaSpecificationExecutor<PostInfoView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "(SELECT COUNT(*) AS collect_num FROM z_post_collect WHERE logic_flag = 1 AND student_id = :id) AS pc ," +
                    "(SELECT COUNT(*) AS content_num FROM z_post_content WHERE logic_flag = 1 AND student_id = :id) AS pct," +
                    "(SELECT COUNT(*) AS activity_publish_num FROM z_post_activity WHERE logic_flag = 1 AND student_id = :id) AS pa," +
                    "(SELECT COUNT(*) AS activity_sign_num FROM z_post_sign WHERE logic_flag = 1 AND student_id = :id) AS ps")
    PostInfoView getById(@Param("id") Long id);
}
