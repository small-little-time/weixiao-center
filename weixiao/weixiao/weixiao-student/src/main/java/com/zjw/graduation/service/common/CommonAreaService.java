package com.zjw.graduation.service.common;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.common.CommonArea;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-23 10:04:49
 */
public interface CommonAreaService {
    PagingResult<CommonArea> page(int pageIndex, int pageSize);

    CommonArea get(Long id);

    CommonArea save(CommonArea Admin);

    CommonArea update(CommonArea Admin);

    void delete(Long id);

    CommonArea findByNumber(int number);
}

