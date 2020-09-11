package com.zjw.graduation.service.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.student.StudentMember;
import com.zjw.graduation.entity.student.StudentPermission;
import com.zjw.graduation.view.post.PostInfoView;
import com.zjw.graduation.view.stu.StudentMemberView;

import java.util.List;

/**
 * 学生表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-25 10:30:03
 */
public interface StudentMemberService {
    PagingResult<StudentMember> page(int pageIndex, int pageSize);

    StudentMember get(Long id);

    StudentMember save(StudentMember Admin);

    void delete(Long id);

    StudentMember getStudentByUsername(String username);

    List<StudentPermission> getPermissionList(Long id);

    String login(String username, String password);

    StudentMember update(StudentMember studentMember);

    void disableOrEnable(Long id);

    StudentMember check(String username);

    PagingResult<StudentMemberView> getStudentViewList(String username, int sex, Long academyId, Long areaId, Long state, int pageIndex, int pageSize);

    void batchDelete(List<Long> collect);

    StudentMember updateFace(Long id, String avatar);

    PostInfoView getPostInfo(Long id);

    PagingResult<StudentMemberView> getMyFollow(Long id, int pageIndex, int pageSize);

    StudentMember saveAmd(StudentMember studentMember);
}

