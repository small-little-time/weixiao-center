package com.zjw.graduation.service.adm;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.adm.AdmRole;

/**
 * 后台用户角色表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
public interface AdmRoleService {
    PagingResult<AdmRole> page(int pageIndex, int pageSize);

    AdmRole get(Long id);

    AdmRole save(AdmRole Admin);

    void delete(Long id);
}

