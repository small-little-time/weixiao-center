package com.zjw.graduation.service.school;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.school.SchoolAcademy;

/**
 * 院部专业信息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-12 15:30:59
 */
public interface SchoolAcademyService {
    PagingResult<SchoolAcademy> page(int pageIndex, int pageSize);

    SchoolAcademy get(Long id);

    SchoolAcademy save(SchoolAcademy Admin);

    SchoolAcademy update(SchoolAcademy Admin);

    void delete(Long id);

    SchoolAcademy findByStudentAcademyId(Long studentId);
}

