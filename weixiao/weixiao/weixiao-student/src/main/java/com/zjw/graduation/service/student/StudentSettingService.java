package com.zjw.graduation.service.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.student.StudentSetting;

/**
 * 学生设置表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
public interface StudentSettingService {
    PagingResult<StudentSetting> page(int pageIndex, int pageSize);

    StudentSetting get(Long id);

    StudentSetting save(StudentSetting Admin);

    StudentSetting update(StudentSetting Admin);

    void delete(Long id);

    void setByStudentId(Long id, Integer chat, Integer sexs, Integer academy);

    StudentSetting findByStudentId(Long id);
}

