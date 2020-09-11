package com.zjw.graduation.service.adm.impl;

import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.adm.AdmRole;
import com.zjw.graduation.repository.adm.AdmRoleDao;
import com.zjw.graduation.service.adm.AdmRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("admRoleService")
public class AdmRoleServiceImpl implements AdmRoleService  {

    @Autowired
    private AdmRoleDao admRoleDao;

    public PagingResult<AdmRole> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<AdmRole> page = admRoleDao.findAll(pageable);

        PagingResult<AdmRole> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public AdmRole get(Long id) {
        return admRoleDao.findById(id).orElse(new AdmRole());
    }

    @Override
    public AdmRole save(AdmRole admRole) {
        return admRoleDao.save(admRole);
    }

    @Override
    public void delete(Long id) {
        AdmRole admRole = admRoleDao.findById(id).orElse(null);
        if (admRole != null){
            admRole.setLogicFlag(EnumLogicType.DELETE.getValue());
            admRoleDao.save(admRole);
        }
    }

}
