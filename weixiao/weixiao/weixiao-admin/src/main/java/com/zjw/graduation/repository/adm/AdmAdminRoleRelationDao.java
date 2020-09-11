package com.zjw.graduation.repository.adm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.adm.AdmAdminRoleRelation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 后台用户和角色关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */

@Repository("AdmAdminRoleRelationDao")
public interface AdmAdminRoleRelationDao extends JpaRepository<AdmAdminRoleRelation, Long>, JpaSpecificationExecutor<AdmAdminRoleRelation> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_adm_admin_role_relation " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_adm_admin_role_relation " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<AdmAdminRoleRelation> findAll(Pageable pageable);

    List<AdmAdminRoleRelation> findAllByAdminIdAndLogicFlagIs(Long id, Integer value);

    AdmAdminRoleRelation findByAdminIdAndRoleIdAndLogicFlagIs(Long adminId, Long roleId, Integer value);
}

