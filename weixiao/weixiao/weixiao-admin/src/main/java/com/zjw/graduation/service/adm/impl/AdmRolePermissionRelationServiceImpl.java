package com.zjw.graduation.service.adm.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.adm.AdmRolePermissionRelation;
import com.zjw.graduation.repository.adm.AdmRolePermissionRelationDao;
import com.zjw.graduation.service.adm.AdmRolePermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("admRolePermissionRelationService")
public class AdmRolePermissionRelationServiceImpl implements AdmRolePermissionRelationService  {

    @Autowired
    private AdmRolePermissionRelationDao admRolePermissionRelationDao;

    public PagingResult<AdmRolePermissionRelation> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<AdmRolePermissionRelation> page = admRolePermissionRelationDao.findAll(pageable);

        PagingResult<AdmRolePermissionRelation> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public AdmRolePermissionRelation get(Long id) {
        return admRolePermissionRelationDao.findById(id).orElse(new AdmRolePermissionRelation());
    }

    @Override
    public AdmRolePermissionRelation save(AdmRolePermissionRelation admRolePermissionRelation) {
        return admRolePermissionRelationDao.save(admRolePermissionRelation);
    }

    @Override
    public void delete(Long id) {
        AdmRolePermissionRelation admRolePermissionRelation = admRolePermissionRelationDao.findById(id).orElse(null);
        if (admRolePermissionRelation != null){
            admRolePermissionRelation.setLogicFlag(EnumLogicType.DELETE.getValue());
            admRolePermissionRelationDao.save(admRolePermissionRelation);
        }
    }

}
