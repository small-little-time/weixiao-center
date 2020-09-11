package com.zjw.graduation.service.school.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.school.SchoolAcademy;
import com.zjw.graduation.repository.school.SchoolAcademyDao;
import com.zjw.graduation.service.school.SchoolAcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("schoolAcademyService")
public class SchoolAcademyServiceImpl implements SchoolAcademyService  {

    @Autowired
    private SchoolAcademyDao schoolAcademyDao;

    public PagingResult<SchoolAcademy> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<SchoolAcademy> page = schoolAcademyDao.findAll(pageable);

        PagingResult<SchoolAcademy> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public SchoolAcademy get(Long id) {
        return schoolAcademyDao.findById(id).orElse(new SchoolAcademy());
    }

    @Override
    public SchoolAcademy save(SchoolAcademy schoolAcademy) {
        return schoolAcademyDao.save(schoolAcademy);
    }

    @Override
    public SchoolAcademy update(SchoolAcademy schoolAcademy) {
        return schoolAcademyDao.save(schoolAcademy);
    }

    @Override
    public void delete(Long id) {
        SchoolAcademy schoolAcademy = schoolAcademyDao.findById(id).orElse(null);
        if (schoolAcademy != null){
            schoolAcademy.setLogicFlag(EnumLogicType.DELETE.getValue());
            schoolAcademyDao.save(schoolAcademy);
        }
    }

    @Override
    public SchoolAcademy findByStudentAcademyId(Long studentId) {
        return schoolAcademyDao.findByStudentAcademyId(studentId);
    }

}
