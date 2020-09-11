package com.zjw.graduation.repository.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.student.StudentPermission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 学生权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */

@Repository("StudentPermissionDao")
public interface StudentPermissionDao extends JpaRepository<StudentPermission, Long>, JpaSpecificationExecutor<StudentPermission> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_student_permission " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_student_permission " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<StudentPermission> findAll(Pageable pageable);

    List<StudentPermission> findAllByIdInAndLogicFlagIs(List<Long> permissionIds, Integer value);
}

