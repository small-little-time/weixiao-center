package com.zjw.graduation.service.common.impl;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.common.CommonArea;
import com.zjw.graduation.repository.common.CommonAreaDao;
import com.zjw.graduation.service.common.CommonAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("commonAreaService")
public class CommonAreaServiceImpl implements CommonAreaService  {

    @Autowired
    private CommonAreaDao commonAreaDao;

    public PagingResult<CommonArea> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<CommonArea> page = commonAreaDao.findAll(pageable);

        PagingResult<CommonArea> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public CommonArea get(Long id) {
        return commonAreaDao.findById(id).orElse(new CommonArea());
    }

    @Override
    public CommonArea save(CommonArea commonArea) {
        return commonAreaDao.save(commonArea);
    }

    @Override
    public CommonArea update(CommonArea commonArea) {
        return commonAreaDao.save(commonArea);
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public CommonArea findByNumber(int number) {
        return commonAreaDao.findByNumber(number);
    }

}
