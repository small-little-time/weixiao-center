package com.zjw.graduation.repository.adm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.adm.AdmRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 后台用户角色表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */

@Repository("AdmRoleDao")
public interface AdmRoleDao extends JpaRepository<AdmRole, Long>, JpaSpecificationExecutor<AdmRole> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_adm_role " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_adm_role " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<AdmRole> findAll(Pageable pageable);

    List<AdmRole> findAllByIdInAndLogicFlagIs(List<Long> ids, Integer value);
}

