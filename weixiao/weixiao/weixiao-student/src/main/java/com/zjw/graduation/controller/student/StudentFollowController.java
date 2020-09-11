package com.zjw.graduation.controller.student;


import com.zjw.graduation.service.student.StudentFollowService;
import com.zjw.graduation.model.student.StudentFollowCreateModel;
import com.zjw.graduation.model.student.StudentFollowUpdateModel;
import com.zjw.graduation.entity.student.StudentFollow;
import com.zjw.graduation.dto.student.StudentFollowDto;
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
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-24 11:47:21
 */
@RestController("StudentFollowController")
@RequestMapping("/student")
@Api(value = "student.StudentFollowController", tags = {""})
public class StudentFollowController {

    @Autowired
    private StudentFollowService studentFollowService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/studentFollows")
    @ApiOperation("列表")
    public JsonResult<PagingResult<StudentFollowDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<StudentFollow> page = studentFollowService.page(pageIndex, pageSize);
        PagingResult<StudentFollowDto> convert = page.convert(item -> {
            StudentFollowDto studentFollowDto = new StudentFollowDto();
            BeanUtils.copyProperties(item, studentFollowDto);
            return studentFollowDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/studentFollow/{id}")
    @ApiOperation("详情")
    public JsonResult<StudentFollowDto> detail(@PathVariable("id") Long id) {

        StudentFollow studentFollow = studentFollowService.get(id);

        StudentFollowDto studentFollowDto = new StudentFollowDto();
        BeanUtils.copyProperties(studentFollow, studentFollowDto);

        return JsonResult.success(studentFollowDto);
    }

    /**
     * 新增
     *
     * @param studentFollowCreateModel
     * @return
     */
    @PostMapping("/studentFollow")
    @ApiOperation("新增")
    public JsonResult<StudentFollowDto> create(@Validated @RequestBody StudentFollowCreateModel studentFollowCreateModel) {

        StudentFollow studentFollow = new StudentFollow();
        BeanUtils.copyProperties(studentFollowCreateModel, studentFollow);
        studentFollowService.save(studentFollow);

        StudentFollowDto studentFollowDto = new StudentFollowDto();
        BeanUtils.copyProperties(studentFollow, studentFollowDto);

        return JsonResult.success(studentFollowDto);

    }

    /**
     * 修改
     *
     * @param studentFollowUpdateModel
     * @return
     */
    @PutMapping("/studentFollow")
    @ApiOperation("修改")
    public JsonResult<StudentFollowDto> update(@Validated @RequestBody StudentFollowUpdateModel studentFollowUpdateModel) {

        StudentFollow studentFollow = studentFollowService.get(studentFollowUpdateModel.getId());
        if (studentFollow.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(studentFollowUpdateModel, studentFollow, NullPropertyUtils.getNullPropertyNames(studentFollowUpdateModel));
        studentFollow.setUpdated(LocalDateTime.now());
        StudentFollow entity = studentFollowService.update(studentFollow);

        StudentFollowDto studentFollowDto = new StudentFollowDto();
        BeanUtils.copyProperties(entity, studentFollowDto);

        return JsonResult.success(studentFollowDto);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/studentFollow/{id}")
    @ApiOperation("删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        studentFollowService.delete(id);

        return JsonResult.success("删除成功");
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @GetMapping("/studentFollow/check")
    @ApiOperation("检查是否关注")
    public JsonResult check(@RequestParam("studentid") Long studentId,
                             @RequestParam("followstudentid") Long followStudentId) {

        boolean flag = studentFollowService.check(studentId, followStudentId);

        return JsonResult.success(flag);
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @DeleteMapping("/studentFollow/cancel")
    @ApiOperation("取消关注")
    public JsonResult cancel(@RequestParam("studentid") Long studentId,
                            @RequestParam("followstudentid") Long followStudentId) {

        studentFollowService.cancel(studentId, followStudentId);

        return JsonResult.success("");
    }
}
