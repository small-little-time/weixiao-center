package com.zjw.graduation.repository.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.student.StudentFollow;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-24 11:47:21
 */

@Repository("StudentFollowDao")
public interface StudentFollowDao extends JpaRepository<StudentFollow, Long>, JpaSpecificationExecutor<StudentFollow> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_student_follow " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_student_follow " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<StudentFollow> findAll(Pageable pageable);

    StudentFollow findByStudentIdAndFollowStudentIdAndLogicFlagIs(Long studentId, Long followStudentId, Integer value);
}

