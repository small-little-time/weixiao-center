package com.zjw.graduation.repository.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.student.StudentReport;
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
 * 举报表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-27 10:50:34
 */

@Repository("StudentReportDao")
public interface StudentReportDao extends JpaRepository<StudentReport, Long>, JpaSpecificationExecutor<StudentReport> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_student_report " +
                    "WHERE " +
                    "`logic_flag` = 1 AND " +
                    "(:state = 0 OR state = :state)",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_student_report " +
                    "WHERE " +
                    "`logic_flag` = 1 AND " +
                    "(:state = 0 OR state = :state)")
    Page<StudentReport> findAll(@Param("state")int state,
                                Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE " +
                    "   z_student_report " +
                    "SET " +
                    "   reply = :content, " +
                    "   state = 2," +
                    "   updated = :now " +
                    "WHERE " +
                    "   id IN :collect")
    void batchReply(@Param("collect") List<Long> collect,
                    @Param("content") String content,
                    @Param("now") LocalDateTime now);
}

