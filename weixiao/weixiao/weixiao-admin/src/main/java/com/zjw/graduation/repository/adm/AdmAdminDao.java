package com.zjw.graduation.repository.adm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.adm.AdmAdmin;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 后台用户表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:15
 */

@Repository("AdmAdminDao")
public interface AdmAdminDao extends JpaRepository<AdmAdmin, Long>, JpaSpecificationExecutor<AdmAdmin> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_adm_admin " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_adm_admin " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<AdmAdmin> findAll(Pageable pageable);

    AdmAdmin findByUsername(String username);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE " +
                    "z_adm_admin " +
                    "SET " +
                    "`logic_flag` = 0 AND " +
                    "`updated` = :now " +
                    "WHERE " +
                    "`id` IN :collect")
    void batchDelete(@Param("collect") List<Integer> collect,
                     @Param("now") LocalDateTime now );
}

