package com.zjw.graduation.service.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.student.StudentMemberPermissionRelation;

/**
 * 学生权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
public interface StudentMemberPermissionRelationService {
    PagingResult<StudentMemberPermissionRelation> page(int pageIndex, int pageSize);

    StudentMemberPermissionRelation get(Long id);

    StudentMemberPermissionRelation save(StudentMemberPermissionRelation Admin);

    StudentMemberPermissionRelation update(StudentMemberPermissionRelation Admin);

    void delete(Long id);
}

