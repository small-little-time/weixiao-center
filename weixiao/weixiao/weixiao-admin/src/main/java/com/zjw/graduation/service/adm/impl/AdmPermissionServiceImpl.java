package com.zjw.graduation.service.adm.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.adm.AdmPermission;
import com.zjw.graduation.repository.adm.AdmPermissionDao;
import com.zjw.graduation.service.adm.AdmPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("admPermissionService")
public class AdmPermissionServiceImpl implements AdmPermissionService  {

    @Autowired
    private AdmPermissionDao admPermissionDao;

    public PagingResult<AdmPermission> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<AdmPermission> page = admPermissionDao.findAll(pageable);

        PagingResult<AdmPermission> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public AdmPermission get(Long id) {
        return admPermissionDao.findById(id).orElse(new AdmPermission());
    }

    @Override
    public AdmPermission save(AdmPermission admPermission) {
        return admPermissionDao.save(admPermission);
    }

    @Override
    public void delete(Long id) {
        AdmPermission admPermission = admPermissionDao.findById(id).orElse(null);
        if (admPermission != null){
            admPermission.setLogicFlag(EnumLogicType.DELETE.getValue());
            admPermissionDao.save(admPermission);
        }
    }

}
