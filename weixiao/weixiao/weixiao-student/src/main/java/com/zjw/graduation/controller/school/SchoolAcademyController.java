package com.zjw.graduation.controller.school;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.school.SchoolAcademyDto;
import com.zjw.graduation.entity.school.SchoolAcademy;
import com.zjw.graduation.model.school.SchoolAcademyCreateModel;
import com.zjw.graduation.model.school.SchoolAcademyUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.school.SchoolAcademyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 院部专业信息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-12 15:30:59
 */
@RestController("SchoolAcademyController")
@RequestMapping("/school")
@Api(value = "school.SchoolAcademyController", tags = {"院部专业信息表"})
public class SchoolAcademyController {

    @Autowired
    private SchoolAcademyService schoolAcademyService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/schoolAcademys")
    @ApiOperation("院部专业信息表列表")
    public JsonResult<PagingResult<SchoolAcademyDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<SchoolAcademy> page = schoolAcademyService.page(pageIndex, pageSize);
        PagingResult<SchoolAcademyDto> convert = page.convert(item -> {
            SchoolAcademyDto schoolAcademyDto = new SchoolAcademyDto();
            BeanUtils.copyProperties(item, schoolAcademyDto);
            return schoolAcademyDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/schoolAcademy/{id}")
    @ApiOperation("院部专业信息表详情")
    public JsonResult<SchoolAcademyDto> detail(@PathVariable("id") Long id) {

        SchoolAcademy schoolAcademy = schoolAcademyService.get(id);

        SchoolAcademyDto schoolAcademyDto = new SchoolAcademyDto();
        BeanUtils.copyProperties(schoolAcademy, schoolAcademyDto);

        return JsonResult.success(schoolAcademyDto);
    }

    /**
     * 新增
     *
     * @param schoolAcademyCreateModel
     * @return
     */
    @PostMapping("/schoolAcademy")
    @ApiOperation("院部专业信息表新增")
    public JsonResult<SchoolAcademyDto> create(@Validated @RequestBody SchoolAcademyCreateModel schoolAcademyCreateModel) {

        SchoolAcademy schoolAcademy = new SchoolAcademy();
        BeanUtils.copyProperties(schoolAcademyCreateModel, schoolAcademy);
        schoolAcademyService.save(schoolAcademy);

        SchoolAcademyDto schoolAcademyDto = new SchoolAcademyDto();
        BeanUtils.copyProperties(schoolAcademy, schoolAcademyDto);

        return JsonResult.success(schoolAcademyDto);

    }

    /**
     * 修改
     *
     * @param schoolAcademyUpdateModel
     * @return
     */
    @PutMapping("/schoolAcademy")
    @ApiOperation("院部专业信息表修改")
    public JsonResult<SchoolAcademy> update(@Validated @RequestBody SchoolAcademyUpdateModel schoolAcademyUpdateModel) {

        SchoolAcademy schoolAcademy = schoolAcademyService.get(schoolAcademyUpdateModel.getId());
        if (schoolAcademy.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(schoolAcademyUpdateModel, schoolAcademy, NullPropertyUtils.getNullPropertyNames(schoolAcademyUpdateModel));
        SchoolAcademy entity = schoolAcademyService.update(schoolAcademy);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/schoolAcademy/{id}")
    @ApiOperation("院部专业信息表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        schoolAcademyService.delete(id);

        return JsonResult.success("删除成功");
    }

}
