package com.zjw.graduation.controller.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.student.StudentMemberDto;
import com.zjw.graduation.dto.student.StudentMemberViewDto;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.feign.student.StudentMemberFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "student.StudentMemberController", tags = "学生管理")
public class StudentMemberController {

    @Autowired
    private StudentMemberFeign studentMemberFeign;

    @GetMapping("/student/studentMembers")
    @ApiOperation("学生列表")
    public JsonResult<PagingResult<StudentMemberViewDto>> list(@RequestHeader("Authorization")String token,
                                                               @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                               @RequestParam(value = "pagesize",defaultValue = "10")int pageSize,
                                                               @RequestParam(value = "username",defaultValue = "")String username,
                                                               @RequestParam(value = "sex",defaultValue = "0")int sex,
                                                               @RequestParam(value = "academyid",defaultValue = "0") Long academyId,
                                                               @RequestParam(value = "areaid",defaultValue = "0") Long areaId,
                                                               @RequestParam(value = "state",defaultValue = "2") Long state){
        return studentMemberFeign.list(token, pageIndex, pageSize, username, sex, academyId, areaId, state);
    }

    @GetMapping("/student/studentMember/{id}")
    @ApiOperation("学生详情")
    public JsonResult<StudentMemberDto> detail(@RequestHeader("Authorization")String token,
                                               @PathVariable("id") Long id) {
        return studentMemberFeign.detail(token, id);
    }

    @DeleteMapping("/student/studentMember/{id}")
    @ApiOperation("学生删除")
    public JsonResult delete(@RequestHeader("Authorization")String token,
                             @PathVariable("id") Long id){
        return studentMemberFeign.delete(token, id);
    }

    @PutMapping("/student/studentMember/disableorenable/{id}")
    @ApiOperation("学生禁用/启用")
    public JsonResult disableOrEnable(@RequestHeader("Authorization")String token,
                              @PathVariable("id") Long id){
        return studentMemberFeign.disableOrEnable(token, id);
    }

    @PutMapping("/student/studentMember/batchdelete")
    @ApiOperation("学生表批量删除")
    public JsonResult disable(@RequestHeader("Authorization")String token,
                              @RequestParam("ids") String ids){
        return studentMemberFeign.batchDelete(token, ids);
    }
}
