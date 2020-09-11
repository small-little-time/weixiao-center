package com.zjw.graduation.controller.student;


import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.student.StudentSettingDto;
import com.zjw.graduation.entity.student.StudentMember;
import com.zjw.graduation.entity.student.StudentSetting;
import com.zjw.graduation.model.student.StudentSettingCreateModel;
import com.zjw.graduation.model.student.StudentSettingUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.student.StudentMemberService;
import com.zjw.graduation.service.student.StudentSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 学生设置表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-27 19:11:16
 */
@RestController("StudentSettingController")
@RequestMapping("/student")
@Api(value = "student.StudentSettingController", tags = {"学生设置表"})
public class StudentSettingController {

    @Autowired
    private StudentSettingService studentSettingService;

    @Autowired
    private StudentMemberService studentMemberService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/studentSettings")
    @ApiOperation("学生设置表列表")
    public JsonResult<PagingResult<StudentSettingDto>> list(@RequestParam(value = "pageindex", defaultValue = "0") int pageIndex,
                                                            @RequestParam(value = "pagesize", defaultValue = "10") int pageSize) {

        PagingResult<StudentSetting> page = studentSettingService.page(pageIndex, pageSize);
        PagingResult<StudentSettingDto> convert = page.convert(item -> {
            StudentSettingDto studentSettingDto = new StudentSettingDto();
            BeanUtils.copyProperties(item, studentSettingDto);
            return studentSettingDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/studentSetting")
    @ApiOperation("学生设置表详情")
    public JsonResult<StudentSettingDto> getDetail(@RequestParam("id") Long id) {

        StudentSetting studentSetting = studentSettingService.findByStudentId(id);

        if (studentSetting != null) {
            StudentSettingDto studentSettingDto = new StudentSettingDto();
            BeanUtils.copyProperties(studentSetting, studentSettingDto);
            return JsonResult.success(studentSettingDto);
        }
        return JsonResult.error("获取错误！");
    }

    @GetMapping("/studentSetting2")
    @ApiOperation("学生设置表详情")
    public JsonResult<StudentSettingDto> detail(@PathVariable("id") Long id) {

        StudentSetting studentSetting = studentSettingService.get(id);

        StudentSettingDto studentSettingDto = new StudentSettingDto();
        BeanUtils.copyProperties(studentSetting, studentSettingDto);

        return JsonResult.success(studentSettingDto);
    }

    /**
     * 新增
     *
     * @param studentSettingCreateModel
     * @return
     */
    @PostMapping("/studentSetting")
    @ApiOperation("学生设置表新增")
    public JsonResult<StudentSettingDto> create(@Validated @RequestBody StudentSettingCreateModel studentSettingCreateModel) {

        StudentSetting studentSetting = new StudentSetting();
        BeanUtils.copyProperties(studentSettingCreateModel, studentSetting);
        studentSettingService.save(studentSetting);

        StudentSettingDto studentSettingDto = new StudentSettingDto();
        BeanUtils.copyProperties(studentSetting, studentSettingDto);

        return JsonResult.success(studentSettingDto);

    }

    /**
     * 修改
     *
     * @param
     * @return
     */
    @PutMapping("/studentSetting")
    @ApiOperation("学生设置表修改")
    public JsonResult update(@Validated @RequestBody StudentSettingUpdateModel model) {
        studentSettingService.setByStudentId(model.getStudentId(), model.getChatSet(), model.getSexSet(), model.getAcademySet());
        StudentMember studentMember = studentMemberService.get(model.getStudentId());
        studentMember.setHide(model.getHide());
        studentMemberService.save(studentMember);
        return JsonResult.success("");
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/studentSetting/{id}")
    @ApiOperation("学生设置表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        studentSettingService.delete(id);

        return JsonResult.success("删除成功");
    }

}
