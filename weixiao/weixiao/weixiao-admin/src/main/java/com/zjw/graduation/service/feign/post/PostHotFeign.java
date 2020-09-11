package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostHotDto;
import com.zjw.graduation.dto.student.StudentReportDto;
import com.zjw.graduation.entity.post.PostHot;
import com.zjw.graduation.model.post.PostHotCreateModel;
import com.zjw.graduation.model.post.PostHotUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.feign.student.StudentReportFeignFallback;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "weixiao-student",fallback = PostHotFeignFallback.class, contextId = "post-hot")
public interface PostHotFeign {

    @GetMapping("/post/postHots")
    @ApiOperation("热点内容表列表")
    public JsonResult<PagingResult<PostHotDto>> list(@RequestHeader("Authorization")String token,
                                                     @RequestParam(value = "pageindex", defaultValue = "0") int pageIndex,
                                                     @RequestParam(value = "pagesize", defaultValue = "10") int pageSize,
                                                     @RequestParam(value = "title", defaultValue = "") String title,
                                                     @RequestParam(value = "mostlook", defaultValue = "0") int mostLook,
                                                     @RequestParam(value = "mostlike", defaultValue = "0") int mostLike);

    @PostMapping("/post/postHot")
    @ApiOperation("热点内容表新增")
    public JsonResult<PostHotDto> create(@RequestHeader("Authorization")String token,
                                         @Validated @RequestBody PostHotCreateModel postHotCreateModel);

    @PutMapping("/post/postHot")
    @ApiOperation("热点内容表修改")
    public JsonResult<PostHotDto> update(@RequestHeader("Authorization")String token,
                                      @Validated @RequestBody PostHotUpdateModel postHotUpdateModel);

    @DeleteMapping("/post/postHot/{id}")
    @ApiOperation("热点内容表删除")
    public JsonResult delete(@RequestHeader("Authorization")String token,
                             @PathVariable("id") Long id);

    @DeleteMapping("/post/postHot/batchdelete")
    @ApiOperation("热点内容表批量删除")
    public JsonResult batchDelete(@RequestHeader("Authorization")String token,
                                  @RequestParam("ids") String ids);
}
