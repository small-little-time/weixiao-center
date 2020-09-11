package com.zjw.graduation.service.student.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.student.StudentPermission;
import com.zjw.graduation.repository.student.StudentPermissionDao;
import com.zjw.graduation.service.student.StudentPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("studentPermissionService")
public class StudentPermissionServiceImpl implements StudentPermissionService  {

    @Autowired
    private StudentPermissionDao studentPermissionDao;

    public PagingResult<StudentPermission> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentPermission> page = studentPermissionDao.findAll(pageable);

        PagingResult<StudentPermission> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentPermission get(Long id) {
        return studentPermissionDao.findById(id).orElse(new StudentPermission());
    }

    @Override
    public StudentPermission save(StudentPermission studentPermission) {
        return studentPermissionDao.save(studentPermission);
    }

    @Override
    public StudentPermission update(StudentPermission studentPermission) {
        return studentPermissionDao.save(studentPermission);
    }

    @Override
    public void delete(Long id) {
        StudentPermission studentPermission = studentPermissionDao.findById(id).orElse(null);
        if (studentPermission != null){
            studentPermission.setLogicFlag(EnumLogicType.DELETE.getValue());
            studentPermissionDao.save(studentPermission);
        }
    }

}
