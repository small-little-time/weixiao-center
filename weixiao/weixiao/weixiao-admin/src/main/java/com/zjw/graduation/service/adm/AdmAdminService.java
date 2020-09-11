package com.zjw.graduation.service.adm;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.adm.AdmAdmin;
import com.zjw.graduation.entity.adm.AdmPermission;
import com.zjw.graduation.entity.adm.AdmRole;
import com.zjw.graduation.model.adm.AdmAdminCreateModel;
import com.zjw.graduation.view.adm.AdmAdminRolesView;

import java.util.List;

/**
 * 后台用户表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:15
 */
public interface AdmAdminService {
    PagingResult<AdmAdmin> page(int pageIndex, int pageSize);

    AdmAdmin get(Long id);

    AdmAdmin save(AdmAdmin Admin);

    void delete(Long id);

    AdmAdmin getAdminByUsername(String username);

    List<AdmPermission> getPermissionList(Long id);

    String login(String username, String password);

    AdmAdmin adminAdd(AdmAdminCreateModel model);

    List<AdmRole> getRolesByAdmId(Long id);

    void enableOrDisable(Long id);

    void batchDelete(String ids);

    PagingResult<AdmAdminRolesView> getAdminRolesList(String username, Long roleId, int pageIndex, int pageSize);
}

