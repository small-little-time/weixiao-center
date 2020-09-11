package com.zjw.graduation.service.student.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.student.StudentSetting;
import com.zjw.graduation.repository.student.StudentSettingDao;
import com.zjw.graduation.service.student.StudentSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("studentSettingService")
public class StudentSettingServiceImpl implements StudentSettingService  {

    @Autowired
    private StudentSettingDao studentSettingDao;

    public PagingResult<StudentSetting> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentSetting> page = studentSettingDao.findAll(pageable);

        PagingResult<StudentSetting> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentSetting get(Long id) {
        return studentSettingDao.findById(id).orElse(new StudentSetting());
    }

    @Override
    public StudentSetting save(StudentSetting studentSetting) {
        return studentSettingDao.save(studentSetting);
    }

    @Override
    public StudentSetting update(StudentSetting studentSetting) {
        return studentSettingDao.save(studentSetting);
    }

    @Override
    public void delete(Long id) {
        StudentSetting studentSetting = studentSettingDao.findById(id).orElse(null);
        if (studentSetting != null){
            studentSetting.setLogicFlag(EnumLogicType.DELETE.getValue());
            studentSettingDao.save(studentSetting);
        }
    }

    @Override
    public void setByStudentId(Long id, Integer chat, Integer sexs, Integer academy) {
        studentSettingDao.setByStudentId(id, chat, sexs, academy);
    }

    @Override
    public StudentSetting findByStudentId(Long id) {
        return studentSettingDao.findByStudentId(id);
    }

}
