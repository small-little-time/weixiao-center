package com.zjw.graduation.service.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.student.StudentPermission;

/**
 * 学生权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
public interface StudentPermissionService {
    PagingResult<StudentPermission> page(int pageIndex, int pageSize);

    StudentPermission get(Long id);

    StudentPermission save(StudentPermission Admin);

    StudentPermission update(StudentPermission Admin);

    void delete(Long id);
}

