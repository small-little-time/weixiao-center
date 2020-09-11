package com.zjw.graduation.controller.adm;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.adm.AdmAdminDto;
import com.zjw.graduation.dto.adm.AdmAdminRolesViewDto;
import com.zjw.graduation.dto.adm.AdmInfoDto;
import com.zjw.graduation.entity.adm.AdmAdmin;
import com.zjw.graduation.entity.adm.AdmPermission;
import com.zjw.graduation.entity.adm.AdmRole;
import com.zjw.graduation.model.adm.AdmAdminCreateModel;
import com.zjw.graduation.model.adm.AdmAdminLoginModel;
import com.zjw.graduation.model.adm.AdmAdminUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.adm.AdmAdminService;
import com.zjw.graduation.util.JwtTokenUtil;
import com.zjw.graduation.view.adm.AdmAdminRolesView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 后台用户表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-20 17:23:15
 */
@RestController("AdmAdminController")
@RequestMapping("/adm")
@Api(value = "adm.AdmAdminController", tags = {"后台用户表"})
public class AdmAdminController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AdmAdminController.class);

    @Autowired
    private AdmAdminService admAdminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "添加管理员")
    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('adm:admin:create')")
    public JsonResult<AdmAdminDto> adminAdd(@RequestBody AdmAdminCreateModel model, BindingResult result) {
        AdmAdmin admAdmin = admAdminService.adminAdd(model);
        if (admAdmin == null) {
            return JsonResult.error("register fail");
        }
        AdmAdminDto admAdminDto = new AdmAdminDto();
        BeanUtils.copyProperties(admAdmin, admAdminDto);
        return JsonResult.success(admAdminDto);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public JsonResult login(@RequestBody AdmAdminLoginModel model, BindingResult result) {
        LOGGER.info("model.getUsername() = {}, " , model.getUsername());
        String token = admAdminService.login(model.getUsername(), model.getPassword());
        if (token == null) {
            return JsonResult.error("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return JsonResult.success(tokenMap);
    }

    @ApiModelProperty("退出登录")
    @PostMapping("/logout")
    public JsonResult logout(){
        return JsonResult.success("");
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @PreAuthorize("hasAuthority('adm:admin:read')")
    @GetMapping("/permission/{adminId}")
    public JsonResult<List<AdmPermission>> getPermissionList(@PathVariable Long adminId) {
        List<AdmPermission> permissionList = admAdminService.getPermissionList(adminId);
        return JsonResult.success(permissionList);
    }

    @ApiOperation("根据token获取管理员信息")
    @GetMapping("/info")
    public AdmInfoDto getPermissionList(@RequestParam(value = "token") String token) {
        String username = jwtTokenUtil.getUserNameFromToken(token);
        AdmInfoDto admInfoDto = new AdmInfoDto();
        AdmAdmin admAdmin = admAdminService.getAdminByUsername(username);
        List<AdmRole> admRoles = admAdminService.getRolesByAdmId(admAdmin.getId());
        List<String> roles = admRoles.stream().map(AdmRole::getDescription).collect(Collectors.toList());
        admInfoDto.setName(admAdmin.getUsername());
        admInfoDto.setAvatar(admAdmin.getIcon());
        admInfoDto.setRoles(roles);
        admInfoDto.setToken(tokenHead + token);
        return admInfoDto;
    }

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/admAdmins")
    @ApiOperation("后台用户表列表")
    public JsonResult<PagingResult<AdmAdminDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<AdmAdmin> page = admAdminService.page(pageIndex, pageSize);
        PagingResult<AdmAdminDto> convert = page.convert(item -> {
            AdmAdminDto admAdminDto = new AdmAdminDto();
            BeanUtils.copyProperties(item, admAdminDto, "password");
            return admAdminDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/admAdmin/{id}")
    @PreAuthorize("hasAuthority('adm:admin:read')")
    @ApiOperation("后台用户表详情")
    public JsonResult<AdmAdminDto> detail(@PathVariable("id") Long id) {

        AdmAdmin admAdmin = admAdminService.get(id);

        AdmAdminDto admAdminDto = new AdmAdminDto();
        BeanUtils.copyProperties(admAdmin, admAdminDto);

        return JsonResult.success(admAdminDto);
    }

    /**
     * 修改
     *
     * @param admAdminUpdateModel
     * @return
     */
    @PutMapping("/admAdmin")
    @ApiOperation("后台用户表修改")
    public JsonResult<AdmAdmin> update(@Validated @RequestBody AdmAdminUpdateModel admAdminUpdateModel) {

        AdmAdmin admAdmin = admAdminService.get(admAdminUpdateModel.getId());
        if (admAdmin.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(admAdminUpdateModel, admAdmin, NullPropertyUtils.getNullPropertyNames(admAdminUpdateModel));
        admAdmin.setUpdated(LocalDateTime.now());
        admAdmin.setPassword(passwordEncoder.encode(admAdmin.getPassword()));
        AdmAdmin entity = admAdminService.save(admAdmin);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/admAdmin/{id}")
    @ApiOperation("后台用户表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        admAdminService.delete(id);

        return JsonResult.success("删除成功");
    }

    @PutMapping("/admAdmin/enableorbatch")
    @ApiOperation("后台用户表启用/禁用")
    public JsonResult enableOrDisable(@RequestParam("id") Long id) {
        admAdminService.enableOrDisable(id);
        return JsonResult.success("操作成功");
    }

    @PutMapping("/admAdmin/batchdelete")
    @ApiOperation("后台用户表删除")
    public JsonResult batchDelete(@RequestParam("ids") String ids) {
        admAdminService.batchDelete(ids);
        return JsonResult.success("操作成功");
    }

    @GetMapping("/admAdmin/roles")
    @ApiOperation("获取管理员角色列表")
    public JsonResult<PagingResult<AdmAdminRolesViewDto>> adminRoles(@RequestParam(value = "username",defaultValue = "") String username,
                                 @RequestParam(value = "roleid",defaultValue = "0") Long roleId,
                                 @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pagesize",defaultValue = "10")int pageSize){
        PagingResult<AdmAdminRolesView> pagingResult =
                admAdminService.getAdminRolesList(username, roleId, pageIndex, pageSize);
        PagingResult<AdmAdminRolesViewDto> convert = pagingResult.convert(item -> {
            AdmAdminRolesViewDto admAdminRolesViewDto = new AdmAdminRolesViewDto();
            BeanUtils.copyProperties(item, admAdminRolesViewDto);
            return admAdminRolesViewDto;
        });
        return JsonResult.success(convert);
    }
}
