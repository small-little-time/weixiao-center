package com.zjw.graduation.service.feign.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.student.StudentReportDto;
import com.zjw.graduation.mvc.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "weixiao-student", fallback = StudentReportFeignFallback.class, contextId = "student-report")
public interface StudentReportFeign {

    @GetMapping("/student/studentReports")
    @ApiOperation("举报表列表")
    public JsonResult<PagingResult<StudentReportDto>> list(@RequestHeader("Authorization")String token,
                                                           @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                           @RequestParam(value = "pagesize",defaultValue = "10")int pageSize,
                                                           @RequestParam(value = "state", defaultValue = "0")int state);

    @DeleteMapping("/student/studentReport/{id}")
    @ApiOperation("举报表删除")
    public JsonResult delete(@RequestHeader("Authorization")String token,
                             @PathVariable("id") Long id);

    @PutMapping("/student/studentReport/reply")
    @ApiOperation("举报反馈")
    public JsonResult reply(@RequestHeader("Authorization")String token,
                            @RequestParam("id") Long id,
                            @RequestParam("content") String content);

    @PutMapping("/student/studentReport/batchreply")
    @ApiOperation("批量举报反馈")
    public JsonResult batchReply(@RequestHeader("Authorization")String token,
                                 @RequestParam("ids") String ids,
                                 @RequestParam("content") String content);
}
