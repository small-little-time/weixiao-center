package com.zjw.graduation.service.feign.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.student.StudentMemberDto;
import com.zjw.graduation.dto.student.StudentMemberViewDto;
import com.zjw.graduation.entity.student.StudentMember;
import com.zjw.graduation.model.student.StudentMemberCreateModel;
import com.zjw.graduation.mvc.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "weixiao-student", contextId = "student-member")
public interface StudentMemberFeign {

    @GetMapping("/student/studentMember/{id}")
    public JsonResult<StudentMemberDto> detail(@RequestHeader("Authorization")String token,
                                               @PathVariable("id") Long id);

    @DeleteMapping("/student/studentMember/{id}")
    public JsonResult delete(@RequestHeader("Authorization")String token,
                             @PathVariable("id") Long id);

    @PutMapping("/student/studentMember/disableorenable/{id}")
    public JsonResult disableOrEnable(@RequestHeader("Authorization")String token,
                              @PathVariable("id") Long id);

    @PostMapping("/student/adm/register")
    public JsonResult<StudentMemberDto> create(@RequestHeader("Authorization")String token,
                                               @Validated @RequestBody StudentMemberCreateModel studentMemberCreateModel);

    @GetMapping("/student/studentMember/check")
    public boolean check(@RequestHeader("Authorization")String token,
                           @RequestParam("username") String username);

    @GetMapping("/student/studentMembers")
    public JsonResult<PagingResult<StudentMemberViewDto>> list(@RequestHeader("Authorization")String token,
                                                               @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                               @RequestParam(value = "pagesize",defaultValue = "10")int pageSize,
                                                               @RequestParam(value = "username",defaultValue = "")String username,
                                                               @RequestParam(value = "sex",defaultValue = "0")int sex,
                                                               @RequestParam(value = "academyid",defaultValue = "0") Long academyId,
                                                               @RequestParam(value = "areaid",defaultValue = "0") Long areaId,
                                                               @RequestParam(value = "state",defaultValue = "2") Long state);

    @PutMapping("/student/studentMember/batchdelete")
    @ApiOperation("学生表批量删除")
    public JsonResult batchDelete(@RequestHeader("Authorization")String token,
                                  @RequestParam("ids") String ids);
}
