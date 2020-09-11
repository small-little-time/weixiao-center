package com.zjw.graduation.controller.adm;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.adm.AdmRoleDto;
import com.zjw.graduation.entity.adm.AdmRole;
import com.zjw.graduation.model.adm.AdmRoleCreateModel;
import com.zjw.graduation.model.adm.AdmRoleUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.adm.AdmRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 后台用户角色表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:16
 */
@RestController("AdmRoleController")
@RequestMapping("/adm")
@Api(value = "adm.AdmRoleController", tags = {"后台用户角色表"})
public class AdmRoleController {

    @Autowired
    private AdmRoleService admRoleService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/admRoles")
    @ApiOperation("后台用户角色表列表")
    public JsonResult<PagingResult<AdmRoleDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<AdmRole> page = admRoleService.page(pageIndex, pageSize);
        PagingResult<AdmRoleDto> convert = page.convert(item -> {
            AdmRoleDto admRoleDto = new AdmRoleDto();
            BeanUtils.copyProperties(item, admRoleDto);
            return admRoleDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/admRole/{id}")
    @PreAuthorize("hasAuthority('adm:admin:read')")
    @ApiOperation("后台用户角色表详情")
    public JsonResult<AdmRoleDto> detail(@PathVariable("id") Long id) {

        AdmRole admRole = admRoleService.get(id);

        AdmRoleDto admRoleDto = new AdmRoleDto();
        BeanUtils.copyProperties(admRole, admRoleDto);

        return JsonResult.success(admRoleDto);
    }

    /**
     * 新增
     *
     * @param admRoleCreateModel
     * @return
     */
    @PostMapping("/admRole")
    @PreAuthorize("hasAuthority('adm:admin:create')")
    @ApiOperation("后台用户角色表新增")
    public JsonResult<AdmRoleDto> create(@Validated @RequestBody AdmRoleCreateModel admRoleCreateModel) {

        AdmRole admRole = new AdmRole();
        BeanUtils.copyProperties(admRoleCreateModel, admRole);
        admRoleService.save(admRole);

        AdmRoleDto admRoleDto = new AdmRoleDto();
        BeanUtils.copyProperties(admRole, admRoleDto);

        return JsonResult.success(admRoleDto);

    }

    /**
     * 修改
     *
     * @param admRoleUpdateModel
     * @return
     */
    @PutMapping("/admRole")
    @PreAuthorize("hasAuthority('adm:admin:update')")
    @ApiOperation("后台用户角色表修改")
    public JsonResult<AdmRole> update(@Validated @RequestBody AdmRoleUpdateModel admRoleUpdateModel) {

        AdmRole admRole = admRoleService.get(admRoleUpdateModel.getId());
        if (admRole.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(admRoleUpdateModel, admRole, NullPropertyUtils.getNullPropertyNames(admRoleUpdateModel));
        admRole.setUpdated(LocalDateTime.now());
        AdmRole entity = admRoleService.save(admRole);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/admRole/{id}")
    @PreAuthorize("hasAuthority('adm:admin:delete')")
    @ApiOperation("后台用户角色表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        admRoleService.delete(id);

        return JsonResult.success("删除成功");
    }

}
