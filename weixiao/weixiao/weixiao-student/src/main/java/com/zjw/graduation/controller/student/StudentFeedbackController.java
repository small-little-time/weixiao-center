package com.zjw.graduation.controller.student;


import com.zjw.graduation.service.student.StudentFeedbackService;
import com.zjw.graduation.model.student.StudentFeedbackCreateModel;
import com.zjw.graduation.model.student.StudentFeedbackUpdateModel;
import com.zjw.graduation.entity.student.StudentFeedback;
import com.zjw.graduation.dto.student.StudentFeedbackDto;
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
 * @date 2020-04-23 15:19:03
 */
@RestController("StudentFeedbackController")
@RequestMapping("/student")
@Api(value = "student.StudentFeedbackController", tags = {""})
public class StudentFeedbackController {

    @Autowired
    private StudentFeedbackService studentFeedbackService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/studentFeedbacks")
    @ApiOperation("列表")
    public JsonResult<PagingResult<StudentFeedbackDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<StudentFeedback> page = studentFeedbackService.page(pageIndex, pageSize);
        PagingResult<StudentFeedbackDto> convert = page.convert(item -> {
            StudentFeedbackDto studentFeedbackDto = new StudentFeedbackDto();
            BeanUtils.copyProperties(item, studentFeedbackDto);
            return studentFeedbackDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/studentFeedback/{id}")
    @ApiOperation("详情")
    public JsonResult<StudentFeedbackDto> detail(@PathVariable("id") Long id) {

        StudentFeedback studentFeedback = studentFeedbackService.get(id);

        StudentFeedbackDto studentFeedbackDto = new StudentFeedbackDto();
        BeanUtils.copyProperties(studentFeedback, studentFeedbackDto);

        return JsonResult.success(studentFeedbackDto);
    }

    /**
     * 新增
     *
     * @param studentFeedbackCreateModel
     * @return
     */
        @PostMapping("/studentFeedback")
    @ApiOperation("新增")
    public JsonResult<StudentFeedbackDto> create(@Validated @RequestBody StudentFeedbackCreateModel studentFeedbackCreateModel) {

        StudentFeedback studentFeedback = new StudentFeedback();
        BeanUtils.copyProperties(studentFeedbackCreateModel, studentFeedback);
        studentFeedbackService.save(studentFeedback);

        StudentFeedbackDto studentFeedbackDto = new StudentFeedbackDto();
        BeanUtils.copyProperties(studentFeedback, studentFeedbackDto);

        return JsonResult.success(studentFeedbackDto);

    }

    /**
     * 修改
     *
     * @param studentFeedbackUpdateModel
     * @return
     */
    @PutMapping("/studentFeedback")
    @ApiOperation("修改")
    public JsonResult<StudentFeedbackDto> update(@Validated @RequestBody StudentFeedbackUpdateModel studentFeedbackUpdateModel) {

        StudentFeedback studentFeedback = studentFeedbackService.get(studentFeedbackUpdateModel.getId());
        if (studentFeedback.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(studentFeedbackUpdateModel, studentFeedback, NullPropertyUtils.getNullPropertyNames(studentFeedbackUpdateModel));
        studentFeedback.setUpdated(LocalDateTime.now());
        StudentFeedback entity = studentFeedbackService.update(studentFeedback);

        StudentFeedbackDto studentFeedbackDto = new StudentFeedbackDto();
        BeanUtils.copyProperties(entity, studentFeedbackDto);

        return JsonResult.success(studentFeedbackDto);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/studentFeedback/{id}")
    @ApiOperation("删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        studentFeedbackService.delete(id);

        return JsonResult.success("删除成功");
    }

}
