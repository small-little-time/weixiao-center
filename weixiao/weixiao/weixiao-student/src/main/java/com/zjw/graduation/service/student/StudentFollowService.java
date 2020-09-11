package com.zjw.graduation.service.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.student.StudentFollow;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-24 11:47:21
 */
public interface StudentFollowService {
    PagingResult<StudentFollow> page(int pageIndex, int pageSize);

    StudentFollow get(Long id);

    StudentFollow save(StudentFollow Admin);

    StudentFollow update(StudentFollow Admin);

    void delete(Long id);

    boolean check(Long studentId, Long followStudentId);

    void cancel(Long studentId, Long followStudentId);
}

