package com.zjw.graduation.repository.school;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.school.SchoolAcademy;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 院部专业信息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-12 15:30:59
 */

@Repository("SchoolAcademyDao")
public interface SchoolAcademyDao extends JpaRepository<SchoolAcademy, Long>, JpaSpecificationExecutor<SchoolAcademy> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_school_academy " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_school_academy " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<SchoolAcademy> findAll(Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_school_academy " +
                    "WHERE " +
                    "id = (SELECT parent_id FROM z_school_academy WHERE id = (SELECT academy_id FROM z_student_member sm WHERE sm.id = 41))")
    SchoolAcademy findByStudentAcademyId(@Param("studentId") Long studentId);
}

