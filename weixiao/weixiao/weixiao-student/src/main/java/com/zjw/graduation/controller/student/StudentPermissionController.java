package com.zjw.graduation.controller.student;


import com.zjw.graduation.service.student.StudentPermissionService;
import com.zjw.graduation.model.student.StudentPermissionCreateModel;
import com.zjw.graduation.model.student.StudentPermissionUpdateModel;
import com.zjw.graduation.entity.student.StudentPermission;
import com.zjw.graduation.dto.student.StudentPermissionDto;
import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.data.PagingResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;


/**
 * 学生权限表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@RestController("StudentPermissionController")
@RequestMapping("/student")
@Api(value = "student.StudentPermissionController", tags = {"学生权限表"})
public class StudentPermissionController {

    @Autowired
    private StudentPermissionService studentPermissionService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/studentPermissions")
    @ApiOperation("学生权限表列表")
    public JsonResult<PagingResult<StudentPermissionDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<StudentPermission> page = studentPermissionService.page(pageIndex, pageSize);
        PagingResult<StudentPermissionDto> convert = page.convert(item -> {
            StudentPermissionDto studentPermissionDto = new StudentPermissionDto();
            BeanUtils.copyProperties(item, studentPermissionDto);
            return studentPermissionDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/studentPermission/{id}")
    @ApiOperation("学生权限表详情")
    public JsonResult<StudentPermissionDto> detail(@PathVariable("id") Long id) {

        StudentPermission studentPermission = studentPermissionService.get(id);

        StudentPermissionDto studentPermissionDto = new StudentPermissionDto();
        BeanUtils.copyProperties(studentPermission, studentPermissionDto);

        return JsonResult.success(studentPermissionDto);
    }

    /**
     * 新增
     *
     * @param studentPermissionCreateModel
     * @return
     */
    @PostMapping("/studentPermission")
    @ApiOperation("学生权限表新增")
    public JsonResult<StudentPermissionDto> create(@Validated @RequestBody StudentPermissionCreateModel studentPermissionCreateModel) {

        StudentPermission studentPermission = new StudentPermission();
        BeanUtils.copyProperties(studentPermissionCreateModel, studentPermission);
        studentPermissionService.save(studentPermission);

        StudentPermissionDto studentPermissionDto = new StudentPermissionDto();
        BeanUtils.copyProperties(studentPermission, studentPermissionDto);

        return JsonResult.success(studentPermissionDto);

    }

    /**
     * 修改
     *
     * @param studentPermissionUpdateModel
     * @return
     */
    @PutMapping("/studentPermission")
    @ApiOperation("学生权限表修改")
    public JsonResult<StudentPermission> update(@Validated @RequestBody StudentPermissionUpdateModel studentPermissionUpdateModel) {

        StudentPermission studentPermission = studentPermissionService.get(studentPermissionUpdateModel.getId());
        if (studentPermission.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(studentPermissionUpdateModel, studentPermission, NullPropertyUtils.getNullPropertyNames(studentPermissionUpdateModel));
        studentPermission.setUpdated(LocalDateTime.now());
        StudentPermission entity = studentPermissionService.update(studentPermission);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/studentPermission/{id}")
    @ApiOperation("学生权限表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        studentPermissionService.delete(id);

        return JsonResult.success("删除成功");
    }

}
