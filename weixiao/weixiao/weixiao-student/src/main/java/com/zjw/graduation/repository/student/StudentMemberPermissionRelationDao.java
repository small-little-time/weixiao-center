package com.zjw.graduation.repository.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.student.StudentMemberPermissionRelation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 学生权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */

@Repository("StudentMemberPermissionRelationDao")
public interface StudentMemberPermissionRelationDao extends JpaRepository<StudentMemberPermissionRelation, Long>, JpaSpecificationExecutor<StudentMemberPermissionRelation> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_student_member_permission_relation " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_student_member_permission_relation " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<StudentMemberPermissionRelation> findAll(Pageable pageable);

    List<StudentMemberPermissionRelation> findAllByStudentIdAndLogicFlagIs(Long id, Integer value);
}

