package com.zjw.graduation.repository.adm;

import com.zjw.graduation.view.adm.AdmAdminRolesView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("AdmAdminRolesViewDao")
public interface AdmAdminRolesViewDao extends JpaRepository<AdmAdminRolesView, Long>, JpaSpecificationExecutor<AdmAdminRolesView> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "@init \\:=@init+1 AS init," +
                    "a.`id`," +
                    "a.`username`," +
                    "arr.`role_id`," +
                    "ar.`name`," +
                    "ar.`description` " +
                    "FROM " +
                    "   (SELECT @init \\:=0) r," +
                    "   z_adm_admin a " +
                    "LEFT JOIN " +
                    "   z_adm_admin_role_relation arr ON a.`id` = arr.`admin_id` AND arr.`logic_flag` = 1 " +
                    "LEFT JOIN " +
                    "   z_adm_role ar ON arr.`role_id` = ar.`id` AND ar.`logic_flag`= 1 " +
                    "WHERE " +
                    "   a.`logic_flag` = 1 AND " +
                    "   arr.role_id IS NOT NULL AND " +
                    "   (:username = '' OR a.username = :username) AND " +
                    "   (:roleId = 0 OR arr.role_id = :roleId)" +
                    "ORDER BY a.id",
            countQuery =
                    "SELECT " +
                    "   COUNT(*) " +
                    "FROM " +
                    "   z_adm_admin a " +
                    "LEFT JOIN " +
                    "   z_adm_admin_role_relation arr ON a.id = arr.admin_id AND arr.logic_flag = 1 " +
                    "LEFT JOIN " +
                    "   z_adm_role ar ON arr.role_id = ar.id AND ar.logic_flag = 1 " +
                    "WHERE " +
                    "   a.logic_flag = 1 AND " +
                    "   arr.role_id IS NOT NULL AND " +
                    "   (:username = '' OR a.username = :username) AND " +
                    "   (:roleId = 0 OR arr.role_id = :roleId)" +
                    "ORDER BY a.id")
    Page<AdmAdminRolesView> getAdminRolesList(@Param("username") String username,
                                              @Param("roleId")Long roleId,
                                              Pageable pageable);
}
