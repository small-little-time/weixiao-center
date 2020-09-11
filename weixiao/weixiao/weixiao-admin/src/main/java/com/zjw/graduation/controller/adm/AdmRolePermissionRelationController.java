package com.zjw.graduation.controller.adm;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.adm.AdmRolePermissionRelationDto;
import com.zjw.graduation.entity.adm.AdmRolePermissionRelation;
import com.zjw.graduation.model.adm.AdmRolePermissionRelationCreateModel;
import com.zjw.graduation.model.adm.AdmRolePermissionRelationUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.adm.AdmRolePermissionRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 后台用户角色和权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@RestController("AdmRolePermissionRelationController")
@RequestMapping("/adm")
@Api(value = "adm.AdmRolePermissionRelationController", tags = {"后台用户角色和权限关系表"})
public class AdmRolePermissionRelationController {

    @Autowired
    private AdmRolePermissionRelationService admRolePermissionRelationService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/admRolePermissionRelations")
    @PreAuthorize("hasAuthority('adm:admin:read')")
    @ApiOperation("后台用户角色和权限关系表列表")
    public JsonResult<PagingResult<AdmRolePermissionRelationDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<AdmRolePermissionRelation> page = admRolePermissionRelationService.page(pageIndex, pageSize);
        PagingResult<AdmRolePermissionRelationDto> convert = page.convert(item -> {
            AdmRolePermissionRelationDto admRolePermissionRelationDto = new AdmRolePermissionRelationDto();
            BeanUtils.copyProperties(item, admRolePermissionRelationDto);
            return admRolePermissionRelationDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/admRolePermissionRelation/{id}")
    @PreAuthorize("hasAuthority('adm:admin:read')")
    @ApiOperation("后台用户角色和权限关系表详情")
    public JsonResult<AdmRolePermissionRelationDto> detail(@PathVariable("id") Long id) {

        AdmRolePermissionRelation admRolePermissionRelation = admRolePermissionRelationService.get(id);

        AdmRolePermissionRelationDto admRolePermissionRelationDto = new AdmRolePermissionRelationDto();
        BeanUtils.copyProperties(admRolePermissionRelation, admRolePermissionRelationDto);

        return JsonResult.success(admRolePermissionRelationDto);
    }

    /**
     * 新增
     *
     * @param admRolePermissionRelationCreateModel
     * @return
     */
    @PostMapping("/admRolePermissionRelation")
    @PreAuthorize("hasAuthority('adm:admin:create')")
    @ApiOperation("后台用户角色和权限关系表新增")
    public JsonResult<AdmRolePermissionRelationDto> create(@Validated @RequestBody AdmRolePermissionRelationCreateModel admRolePermissionRelationCreateModel) {

        AdmRolePermissionRelation admRolePermissionRelation = new AdmRolePermissionRelation();
        BeanUtils.copyProperties(admRolePermissionRelationCreateModel, admRolePermissionRelation);
        admRolePermissionRelationService.save(admRolePermissionRelation);

        AdmRolePermissionRelationDto admRolePermissionRelationDto = new AdmRolePermissionRelationDto();
        BeanUtils.copyProperties(admRolePermissionRelation, admRolePermissionRelationDto);

        return JsonResult.success(admRolePermissionRelationDto);

    }

    /**
     * 修改
     *
     * @param admRolePermissionRelationUpdateModel
     * @return
     */
    @PutMapping("/admRolePermissionRelation")
    @PreAuthorize("hasAuthority('adm:admin:update')")
    @ApiOperation("后台用户角色和权限关系表修改")
    public JsonResult<AdmRolePermissionRelation> update(@Validated @RequestBody AdmRolePermissionRelationUpdateModel admRolePermissionRelationUpdateModel) {

        AdmRolePermissionRelation admRolePermissionRelation = admRolePermissionRelationService.get(admRolePermissionRelationUpdateModel.getId());
        if (admRolePermissionRelation.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(admRolePermissionRelationUpdateModel, admRolePermissionRelation, NullPropertyUtils.getNullPropertyNames(admRolePermissionRelationUpdateModel));
        admRolePermissionRelation.setUpdated(LocalDateTime.now());
        AdmRolePermissionRelation entity = admRolePermissionRelationService.save(admRolePermissionRelation);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/admRolePermissionRelation/{id}")
    @PreAuthorize("hasAuthority('adm:admin:delete')")
    @ApiOperation("后台用户角色和权限关系表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        admRolePermissionRelationService.delete(id);

        return JsonResult.success("删除成功");
    }

}
