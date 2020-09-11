package com.zjw.graduation.service.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.student.StudentFeedback;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-23 15:19:03
 */
public interface StudentFeedbackService {
    PagingResult<StudentFeedback> page(int pageIndex, int pageSize);

    StudentFeedback get(Long id);

    StudentFeedback save(StudentFeedback Admin);

    StudentFeedback update(StudentFeedback Admin);

    void delete(Long id);
}

