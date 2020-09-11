package com.zjw.graduation.service.student.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.student.StudentFollow;
import com.zjw.graduation.repository.student.StudentFollowDao;
import com.zjw.graduation.service.student.StudentFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service("studentFollowService")
public class StudentFollowServiceImpl implements StudentFollowService  {

    @Autowired
    private StudentFollowDao studentFollowDao;

    public PagingResult<StudentFollow> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentFollow> page = studentFollowDao.findAll(pageable);

        PagingResult<StudentFollow> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentFollow get(Long id) {
        return studentFollowDao.findById(id).orElse(new StudentFollow());
    }

    @Override
    public StudentFollow save(StudentFollow studentFollow) {
        studentFollow.setLogicFlag(EnumLogicType.NORMAL.getValue());
        return studentFollowDao.save(studentFollow);
    }

    @Override
    public StudentFollow update(StudentFollow studentFollow) {
        return studentFollowDao.save(studentFollow);
    }

    @Override
    public void delete(Long id) {
        StudentFollow studentFollow = studentFollowDao.findById(id).orElse(null);
        if (studentFollow != null){
            studentFollow.setLogicFlag(EnumLogicType.DELETE.getValue());
            studentFollowDao.save(studentFollow);
        }
    }

    @Override
    public boolean check(Long studentId, Long followStudentId) {
        StudentFollow studentFollow =
                studentFollowDao.findByStudentIdAndFollowStudentIdAndLogicFlagIs(studentId, followStudentId, EnumLogicType.NORMAL.getValue());
        return studentFollow != null;
    }

    @Override
    public void cancel(Long studentId, Long followStudentId) {
        StudentFollow studentFollow =
                studentFollowDao.findByStudentIdAndFollowStudentIdAndLogicFlagIs(studentId, followStudentId, EnumLogicType.NORMAL.getValue());
        if (studentFollow != null) {
            studentFollow.setLogicFlag(EnumLogicType.DELETE.getValue());
            studentFollow.setUpdated(LocalDateTime.now());
            studentFollowDao.save(studentFollow);
        }
    }

}
