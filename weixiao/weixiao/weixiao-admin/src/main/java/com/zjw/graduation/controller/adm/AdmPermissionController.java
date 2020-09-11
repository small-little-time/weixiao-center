package com.zjw.graduation.controller.adm;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.adm.AdmPermissionDto;
import com.zjw.graduation.entity.adm.AdmPermission;
import com.zjw.graduation.model.adm.AdmPermissionCreateModel;
import com.zjw.graduation.model.adm.AdmPermissionUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.adm.AdmPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 后台用户权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@RestController("AdmPermissionController")
@RequestMapping("/adm")
@Api(value = "adm.AdmPermissionController", tags = {"后台用户权限表"})
public class AdmPermissionController {

    @Autowired
    private AdmPermissionService admPermissionService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/admPermissions")
    @PreAuthorize("hasAuthority('adm:admin:read')")
    @ApiOperation("后台用户权限表列表")
    public JsonResult<PagingResult<AdmPermissionDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<AdmPermission> page = admPermissionService.page(pageIndex, pageSize);
        PagingResult<AdmPermissionDto> convert = page.convert(item -> {
            AdmPermissionDto admPermissionDto = new AdmPermissionDto();
            BeanUtils.copyProperties(item, admPermissionDto);
            return admPermissionDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/admPermission/{id}")
    @PreAuthorize("hasAuthority('adm:admin:read')")
    @ApiOperation("后台用户权限表详情")
    public JsonResult<AdmPermissionDto> detail(@PathVariable("id") Long id) {

        AdmPermission admPermission = admPermissionService.get(id);

        AdmPermissionDto admPermissionDto = new AdmPermissionDto();
        BeanUtils.copyProperties(admPermission, admPermissionDto);

        return JsonResult.success(admPermissionDto);
    }

    /**
     * 新增
     *
     * @param admPermissionCreateModel
     * @return
     */
    @PostMapping("/admPermission")
    @PreAuthorize("hasAuthority('adm:admin:create')")
    @ApiOperation("后台用户权限表新增")
    public JsonResult<AdmPermissionDto> create(@Validated @RequestBody AdmPermissionCreateModel admPermissionCreateModel) {

        AdmPermission admPermission = new AdmPermission();
        BeanUtils.copyProperties(admPermissionCreateModel, admPermission);
        admPermissionService.save(admPermission);

        AdmPermissionDto admPermissionDto = new AdmPermissionDto();
        BeanUtils.copyProperties(admPermission, admPermissionDto);

        return JsonResult.success(admPermissionDto);

    }

    /**
     * 修改
     *
     * @param admPermissionUpdateModel
     * @return
     */
    @PutMapping("/admPermission")
    @PreAuthorize("hasAuthority('adm:admin:update')")
    @ApiOperation("后台用户权限表修改")
    public JsonResult<AdmPermission> update(@Validated @RequestBody AdmPermissionUpdateModel admPermissionUpdateModel) {

        AdmPermission admPermission = admPermissionService.get(admPermissionUpdateModel.getId());
        if (admPermission.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(admPermissionUpdateModel, admPermission, NullPropertyUtils.getNullPropertyNames(admPermissionUpdateModel));
        admPermission.setUpdated(LocalDateTime.now());
        AdmPermission entity = admPermissionService.save(admPermission);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/admPermission/{id}")
    @PreAuthorize("hasAuthority('adm:admin:delete')")
    @ApiOperation("后台用户权限表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        admPermissionService.delete(id);

        return JsonResult.success("删除成功");
    }

}
