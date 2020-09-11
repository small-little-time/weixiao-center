package com.zjw.graduation.service.student.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.student.StudentMemberPermissionRelation;
import com.zjw.graduation.repository.student.StudentMemberPermissionRelationDao;
import com.zjw.graduation.service.student.StudentMemberPermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("studentMemberPermissionRelationService")
public class StudentMemberPermissionRelationServiceImpl implements StudentMemberPermissionRelationService  {

    @Autowired
    private StudentMemberPermissionRelationDao studentMemberPermissionRelationDao;

    public PagingResult<StudentMemberPermissionRelation> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentMemberPermissionRelation> page = studentMemberPermissionRelationDao.findAll(pageable);

        PagingResult<StudentMemberPermissionRelation> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentMemberPermissionRelation get(Long id) {
        return studentMemberPermissionRelationDao.findById(id).orElse(new StudentMemberPermissionRelation());
    }

    @Override
    public StudentMemberPermissionRelation save(StudentMemberPermissionRelation studentMemberPermissionRelation) {
        return studentMemberPermissionRelationDao.save(studentMemberPermissionRelation);
    }

    @Override
    public StudentMemberPermissionRelation update(StudentMemberPermissionRelation studentMemberPermissionRelation) {
        return studentMemberPermissionRelationDao.save(studentMemberPermissionRelation);
    }

    @Override
    public void delete(Long id) {
        StudentMemberPermissionRelation studentMemberPermissionRelation = studentMemberPermissionRelationDao.findById(id).orElse(null);
        if (studentMemberPermissionRelation != null){
            studentMemberPermissionRelation.setLogicFlag(EnumLogicType.DELETE.getValue());
            studentMemberPermissionRelationDao.save(studentMemberPermissionRelation);
        }
    }

}
