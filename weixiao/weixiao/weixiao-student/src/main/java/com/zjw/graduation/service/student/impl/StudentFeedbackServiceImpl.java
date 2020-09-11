package com.zjw.graduation.service.student.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.student.StudentFeedback;
import com.zjw.graduation.repository.student.StudentFeedbackDao;
import com.zjw.graduation.service.student.StudentFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("studentFeedbackService")
public class StudentFeedbackServiceImpl implements StudentFeedbackService  {

    @Autowired
    private StudentFeedbackDao studentFeedbackDao;

    public PagingResult<StudentFeedback> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentFeedback> page = studentFeedbackDao.findAll(pageable);

        PagingResult<StudentFeedback> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentFeedback get(Long id) {
        return studentFeedbackDao.findById(id).orElse(new StudentFeedback());
    }

    @Override
    public StudentFeedback save(StudentFeedback studentFeedback) {
        return studentFeedbackDao.save(studentFeedback);
    }

    @Override
    public StudentFeedback update(StudentFeedback studentFeedback) {
        return studentFeedbackDao.save(studentFeedback);
    }

    @Override
    public void delete(Long id) {
        StudentFeedback studentFeedback = studentFeedbackDao.findById(id).orElse(null);
        if (studentFeedback != null){
            studentFeedback.setLogicFalg(EnumLogicType.DELETE.getValue());
            studentFeedbackDao.save(studentFeedback);
        }
    }

}
