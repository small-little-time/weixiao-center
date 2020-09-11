package com.zjw.graduation.service.adm.impl;

import com.zjw.graduation.model.adm.AdmAdminRoleRelationBatchDeleteModel;
import com.zjw.graduation.mvc.JsonResult;
import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.adm.AdmAdminRoleRelation;
import com.zjw.graduation.repository.adm.AdmAdminRoleRelationDao;
import com.zjw.graduation.service.adm.AdmAdminRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service("admAdminRoleRelationService")
public class AdmAdminRoleRelationServiceImpl implements AdmAdminRoleRelationService  {

    @Autowired
    private AdmAdminRoleRelationDao admAdminRoleRelationDao;

    public PagingResult<AdmAdminRoleRelation> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<AdmAdminRoleRelation> page = admAdminRoleRelationDao.findAll(pageable);

        PagingResult<AdmAdminRoleRelation> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public AdmAdminRoleRelation get(Long id) {
        return admAdminRoleRelationDao.findById(id).orElse(new AdmAdminRoleRelation());
    }

    @Override
    public AdmAdminRoleRelation save(AdmAdminRoleRelation admAdminRoleRelation) {
        AdmAdminRoleRelation entity =
                admAdminRoleRelationDao.findByAdminIdAndRoleIdAndLogicFlagIs(admAdminRoleRelation.getAdminId(),admAdminRoleRelation.getRoleId() , EnumLogicType.NORMAL.getValue());
        if (entity != null) {
            return null;
        }
        return admAdminRoleRelationDao.save(admAdminRoleRelation);
    }

    @Override
    public void delete(Long id) {
        AdmAdminRoleRelation admAdminRoleRelation = admAdminRoleRelationDao.findById(id).orElse(null);
        if (admAdminRoleRelation != null){
            admAdminRoleRelation.setLogicFlag(EnumLogicType.DELETE.getValue());
            admAdminRoleRelationDao.save(admAdminRoleRelation);
        }
    }

    @Override
    public void deleteRelation(Long adminId, Long roleId) {
        AdmAdminRoleRelation admAdminRoleRelation =
                admAdminRoleRelationDao.findByAdminIdAndRoleIdAndLogicFlagIs(adminId, roleId, EnumLogicType.NORMAL.getValue());
        if (admAdminRoleRelation != null){
            admAdminRoleRelation.setUpdated(LocalDateTime.now());
            admAdminRoleRelation.setLogicFlag(EnumLogicType.DELETE.getValue());
            admAdminRoleRelationDao.save(admAdminRoleRelation);
        }
    }

    @Override
    @Transactional
    public void batchDelete(List<AdmAdminRoleRelationBatchDeleteModel> models) {
        for (AdmAdminRoleRelationBatchDeleteModel model :models){
            deleteRelation(model.getAdminId(), model.getRoleId());
        }
    }

}
