package com.zjw.graduation.repository.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.common.CommonArea;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-23 10:04:49
 */

@Repository("CommonAreaDao")
public interface CommonAreaDao extends JpaRepository<CommonArea, Long>, JpaSpecificationExecutor<CommonArea> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_common_area " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_common_area " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<CommonArea> findAll(Pageable pageable);

    CommonArea findByNumber(int number);
}

