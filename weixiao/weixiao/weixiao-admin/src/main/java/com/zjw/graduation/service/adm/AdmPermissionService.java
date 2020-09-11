package com.zjw.graduation.service.adm;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.adm.AdmPermission;

/**
 * 后台用户权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
public interface AdmPermissionService {
    PagingResult<AdmPermission> page(int pageIndex, int pageSize);

    AdmPermission get(Long id);

    AdmPermission save(AdmPermission Admin);

    void delete(Long id);
}

