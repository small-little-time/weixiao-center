package com.zjw.graduation.service.adm;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.adm.AdmAdminRoleRelation;
import com.zjw.graduation.model.adm.AdmAdminRoleRelationBatchDeleteModel;

import java.util.List;

/**
 * 后台用户和角色关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
public interface AdmAdminRoleRelationService {
    PagingResult<AdmAdminRoleRelation> page(int pageIndex, int pageSize);

    AdmAdminRoleRelation get(Long id);

    AdmAdminRoleRelation save(AdmAdminRoleRelation Admin);

    void delete(Long id);

    void deleteRelation(Long adminId, Long roleId);

    void batchDelete(List<AdmAdminRoleRelationBatchDeleteModel> models);
}

