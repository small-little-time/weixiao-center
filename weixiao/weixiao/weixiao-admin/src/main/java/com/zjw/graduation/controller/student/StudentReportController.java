package com.zjw.graduation.controller.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.student.StudentReportDto;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.feign.student.StudentReportFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "student.StudentReportController", tags = "举报管理")
public class StudentReportController {

    @Autowired
    private StudentReportFeign studentReportFeign;

    @GetMapping("/student/studentReports")
    @ApiOperation("举报表列表")
    public JsonResult<PagingResult<StudentReportDto>> list(@RequestHeader("Authorization")String token,
                                                           @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                           @RequestParam(value = "pagesize",defaultValue = "10")int pageSize,
                                                           @RequestParam(value = "state", defaultValue = "0")int state){
        return studentReportFeign.list(token, pageIndex, pageSize, state);
    }

    @DeleteMapping("/student/studentReport/{id}")
    @ApiOperation("举报表删除")
    public JsonResult delete(@RequestHeader("Authorization")String token,
                             @PathVariable("id") Long id){
        return studentReportFeign.delete(token, id);
    }

    @PutMapping("/student/studentReport/reply")
    @ApiOperation("举报反馈")
    public JsonResult reply(@RequestHeader("Authorization")String token,
                            @RequestParam("id") Long id,
                            @RequestParam("content") String content){
        return studentReportFeign.reply(token, id, content);
    }

    @PutMapping("/student/studentReport/batchreply")
    @ApiOperation("批量举报反馈")
    public JsonResult batchReply(@RequestHeader("Authorization")String token,
                                 @RequestParam("ids") String ids,
                                 @RequestParam("content") String content){
        return studentReportFeign.batchReply(token, ids, content);
    }
}
