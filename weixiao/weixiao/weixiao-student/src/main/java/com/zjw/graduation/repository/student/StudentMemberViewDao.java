package com.zjw.graduation.repository.student;

import com.zjw.graduation.view.stu.StudentMemberView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("StudentMemberViewDao")
public interface StudentMemberViewDao extends JpaRepository<StudentMemberView, Long>, JpaSpecificationExecutor<StudentMemberView> {
    @Query(nativeQuery = true,
            value = "SELECT " +
                    "   sm.id,sm.username," +
                    "   sm.truename," +
                    "   sm.nickname," +
                    "   sm.sex," +
                    "   sm.age," +
                    "   sm.area," +
                    "   sm.number," +
                    "   sm.phone," +
                    "   sm.face_img," +
                    "   asy.academy_name," +
                    "   sm.autograph," +
                    "   sm.state," +
                    "   sm.created," +
                    "   sm.updated " +
                    "FROM " +
                    "   z_student_member sm " +
                    "LEFT JOIN " +
                    "   z_school_academy asy ON sm.academy_id = asy.id AND asy.logic_flag = 1 " +
                    "WHERE " +
                    "   sm.academy_id != 999 AND" +
                    "   sm.logic_flag = 1 AND" +
                    "   (:username = '' OR sm.username LIKE CONCAT('%',:username,'%')) AND " +
                    "   (:sex = 0 OR sm.sex = :sex) AND " +
                    "   (:academyId = 0 OR sm.academy_id = :academyId) AND " +
                    "   (:areaId = 0 OR sm.area_id = :areaId) AND " +
                    "   (:state = 2 OR sm.state = :state)",
            countQuery =
                    "SELECT " +
                    "   COUNT(*) " +
                    "FROM " +
                    "   z_student_member sm " +
                    "LEFT JOIN " +
                    "   z_school_academy asy ON sm.academy_id = asy.id AND asy.logic_flag = 1 " +
                    "WHERE " +
                    "   sm.academy_id != 999 AND" +
                    "   sm.logic_flag = 1 AND" +
                    "   (:username = '' OR sm.username like CONCAT('%',:username,'%')) AND " +
                    "   (:sex = 0 OR sm.sex = :sex) AND " +
                    "   (:academyId = 0 OR sm.academy_id = :academyId) AND " +
                    "   (:areaId = 0 OR sm.area_id = :areaId) AND " +
                    "   (:state = 2 OR sm.state = :state)")
    Page<StudentMemberView> getStudentViewList(@Param("username") String username,
                                               @Param("sex") int sex,
                                               @Param("academyId") Long academyId,
                                               @Param("areaId") Long areaId,
                                               @Param("state") Long state,
                                               Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "   sm.id,sm.username," +
                    "   sm.truename," +
                    "   sm.nickname," +
                    "   sm.sex," +
                    "   sm.age," +
                    "   sm.area," +
                    "   sm.number," +
                    "   sm.phone," +
                    "   sm.face_img," +
                    "   asy.academy_name," +
                    "   sm.autograph," +
                    "   sm.state," +
                    "   sm.created," +
                    "   sm.updated " +
                    "FROM " +
                    "   z_student_member sm " +
                    "LEFT JOIN " +
                    "   z_school_academy asy ON sm.academy_id = asy.id AND asy.logic_flag = 1 " +
                    "WHERE " +
                    "   sm.academy_id != 999 AND" +
                    "   sm.logic_flag = 1 AND " +
                    "   sm.id IN " +
                    "(SELECT sf.follow_student_id FROM " +
                    "z_student_follow sf WHERE sf.logic_flag = 1 AND sf.student_id = :id)",
            countQuery = "SELECT " +
                    "   COUNT(*) " +
                    "FROM " +
                    "   z_student_member sm " +
                    "LEFT JOIN " +
                    "   z_school_academy asy ON sm.academy_id = asy.id AND asy.logic_flag = 1 " +
                    "WHERE " +
                    "   sm.academy_id != 999 AND" +
                    "   sm.logic_flag = 1 AND " +
                    "   sm.id IN " +
                    "(SELECT sf.follow_student_id FROM " +
                    "z_student_follow sf WHERE sf.logic_flag = 1 AND sf.student_id = :id)")
    Page<StudentMemberView> getMyFollow(@Param("id") Long id,
                                        Pageable pageable);
}
