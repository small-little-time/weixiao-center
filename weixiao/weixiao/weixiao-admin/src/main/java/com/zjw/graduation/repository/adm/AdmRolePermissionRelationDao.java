package com.zjw.graduation.repository.adm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zjw.graduation.entity.adm.AdmRolePermissionRelation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 后台用户角色和权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */

@Repository("AdmRolePermissionRelationDao")
public interface AdmRolePermissionRelationDao extends JpaRepository<AdmRolePermissionRelation, Long>, JpaSpecificationExecutor<AdmRolePermissionRelation> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "* " +
                    "FROM " +
                    "z_adm_role_permission_relation " +
                    "WHERE " +
                    "`logic_flag` = 1 ",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "z_adm_role_permission_relation " +
                    "WHERE " +
                    "`logic_flag` = 1 ")
    Page<AdmRolePermissionRelation> findAll(Pageable pageable);

    List<AdmRolePermissionRelation> findAllByRoleIdInAndLogicFlagIs(List<Long> roleList, Integer value);
}

