package com.zjw.graduation.repository.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.student.StudentSetting;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生设置表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */

@Repository("StudentSettingDao")
public interface StudentSettingDao extends JpaRepository<StudentSetting, Long>, JpaSpecificationExecutor<StudentSetting> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_student_setting " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_student_setting " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<StudentSetting> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE " +
                    "z_student_setting " +
                    "SET " +
                    "chat_set = :chat, " +
                    "sex_set = :sexs, " +
                    "academy_set = :academy " +
                    "WHERE " +
                    "student_id = :id")
    void setByStudentId(@Param("id") Long id,
                        @Param("chat") Integer chat,
                        @Param("sexs") Integer sexs,
                        @Param("academy") Integer academy);

    StudentSetting findByStudentId(Long id);
}

