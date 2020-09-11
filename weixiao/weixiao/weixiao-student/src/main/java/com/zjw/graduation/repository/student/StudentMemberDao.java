package com.zjw.graduation.repository.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.student.StudentMember;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 学生表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-25 10:30:03
 */

@Repository("StudentMemberDao")
public interface StudentMemberDao extends JpaRepository<StudentMember, Long>, JpaSpecificationExecutor<StudentMember> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_student_member " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_student_member " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<StudentMember> findAll(Pageable pageable);

    StudentMember findByUsernameAndLogicFlagIs(String username, Integer value);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE " +
                    "   z_student_member " +
                    "SET " +
                    "   `logic_flag` = 0 AND " +
                    "   `updated` = :now " +
                    "WHERE " +
                    "   id IN :collect")
    void batchDelete(@Param("collect") List<Long> collect,
                     @Param("now") LocalDateTime now);
}

