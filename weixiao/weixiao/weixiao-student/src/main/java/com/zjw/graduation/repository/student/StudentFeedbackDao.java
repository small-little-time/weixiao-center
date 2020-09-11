package com.zjw.graduation.repository.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.student.StudentFeedback;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-23 15:19:03
 */

@Repository("StudentFeedbackDao")
public interface StudentFeedbackDao extends JpaRepository<StudentFeedback, Long>, JpaSpecificationExecutor<StudentFeedback> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_student_feedback " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_student_feedback " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<StudentFeedback> findAll(Pageable pageable);
}

