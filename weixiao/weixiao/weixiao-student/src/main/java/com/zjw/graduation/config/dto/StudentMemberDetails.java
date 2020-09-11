package com.zjw.graduation.config.dto;

import com.zjw.graduation.entity.student.StudentMember;
import com.zjw.graduation.entity.student.StudentPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * Created by macro on 2018/4/26.
 */
public class StudentMemberDetails implements UserDetails {
    private StudentMember studentMember;
    private List<StudentPermission> studentPermissionList;
    public StudentMemberDetails(StudentMember studentMember, List<StudentPermission> studentPermissionList) {

        this.studentMember = studentMember;
        this.studentPermissionList = studentPermissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return studentPermissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return studentMember.getPassword();
    }

    @Override
    public String getUsername() {
        return studentMember.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return studentMember.getState() == 1;
    }

}
