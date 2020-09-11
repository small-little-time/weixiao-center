package com.zjw.graduation.controller.student;


import com.zjw.graduation.service.student.StudentMemberPermissionRelationService;
import com.zjw.graduation.model.student.StudentMemberPermissionRelationCreateModel;
import com.zjw.graduation.model.student.StudentMemberPermissionRelationUpdateModel;
import com.zjw.graduation.entity.student.StudentMemberPermissionRelation;
import com.zjw.graduation.dto.student.StudentMemberPermissionRelationDto;
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
 * 学生权限关系表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@RestController("StudentMemberPermissionRelationController")
@RequestMapping("/student")
@Api(value = "student.StudentMemberPermissionRelationController", tags = {"学生权限关系表"})
public class StudentMemberPermissionRelationController {

    @Autowired
    private StudentMemberPermissionRelationService studentMemberPermissionRelationService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/studentMemberPermissionRelations")
    @ApiOperation("学生权限关系表列表")
    public JsonResult<PagingResult<StudentMemberPermissionRelationDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<StudentMemberPermissionRelation> page = studentMemberPermissionRelationService.page(pageIndex, pageSize);
        PagingResult<StudentMemberPermissionRelationDto> convert = page.convert(item -> {
            StudentMemberPermissionRelationDto studentMemberPermissionRelationDto = new StudentMemberPermissionRelationDto();
            BeanUtils.copyProperties(item, studentMemberPermissionRelationDto);
            return studentMemberPermissionRelationDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/studentMemberPermissionRelation/{id}")
    @ApiOperation("学生权限关系表详情")
    public JsonResult<StudentMemberPermissionRelationDto> detail(@PathVariable("id") Long id) {

        StudentMemberPermissionRelation studentMemberPermissionRelation = studentMemberPermissionRelationService.get(id);

        StudentMemberPermissionRelationDto studentMemberPermissionRelationDto = new StudentMemberPermissionRelationDto();
        BeanUtils.copyProperties(studentMemberPermissionRelation, studentMemberPermissionRelationDto);

        return JsonResult.success(studentMemberPermissionRelationDto);
    }

    /**
     * 新增
     *
     * @param studentMemberPermissionRelationCreateModel
     * @return
     */
    @PostMapping("/studentMemberPermissionRelation")
    @ApiOperation("学生权限关系表新增")
    public JsonResult<StudentMemberPermissionRelationDto> create(@Validated @RequestBody StudentMemberPermissionRelationCreateModel studentMemberPermissionRelationCreateModel) {

        StudentMemberPermissionRelation studentMemberPermissionRelation = new StudentMemberPermissionRelation();
        BeanUtils.copyProperties(studentMemberPermissionRelationCreateModel, studentMemberPermissionRelation);
        studentMemberPermissionRelationService.save(studentMemberPermissionRelation);

        StudentMemberPermissionRelationDto studentMemberPermissionRelationDto = new StudentMemberPermissionRelationDto();
        BeanUtils.copyProperties(studentMemberPermissionRelation, studentMemberPermissionRelationDto);

        return JsonResult.success(studentMemberPermissionRelationDto);

    }

    /**
     * 修改
     *
     * @param studentMemberPermissionRelationUpdateModel
     * @return
     */
    @PutMapping("/studentMemberPermissionRelation")
    @ApiOperation("学生权限关系表修改")
    public JsonResult<StudentMemberPermissionRelation> update(@Validated @RequestBody StudentMemberPermissionRelationUpdateModel studentMemberPermissionRelationUpdateModel) {

        StudentMemberPermissionRelation studentMemberPermissionRelation = studentMemberPermissionRelationService.get(studentMemberPermissionRelationUpdateModel.getId());
        if (studentMemberPermissionRelation.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(studentMemberPermissionRelationUpdateModel, studentMemberPermissionRelation, NullPropertyUtils.getNullPropertyNames(studentMemberPermissionRelationUpdateModel));
        studentMemberPermissionRelation.setUpdated(LocalDateTime.now());
        StudentMemberPermissionRelation entity = studentMemberPermissionRelationService.update(studentMemberPermissionRelation);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/studentMemberPermissionRelation/{id}")
    @ApiOperation("学生权限关系表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        studentMemberPermissionRelationService.delete(id);

        return JsonResult.success("删除成功");
    }

}
