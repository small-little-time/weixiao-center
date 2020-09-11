package com.zjw.graduation.service.adm;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.adm.AdmRolePermissionRelation;

/**
 * 后台用户角色和权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
public interface AdmRolePermissionRelationService {
    PagingResult<AdmRolePermissionRelation> page(int pageIndex, int pageSize);

    AdmRolePermissionRelation get(Long id);

    AdmRolePermissionRelation save(AdmRolePermissionRelation Admin);

    void delete(Long id);
}

