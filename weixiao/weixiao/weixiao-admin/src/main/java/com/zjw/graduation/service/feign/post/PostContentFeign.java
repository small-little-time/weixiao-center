package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostContentViewDto;
import com.zjw.graduation.mvc.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weixiao-student", contextId = "post-content")
public interface PostContentFeign {

    @GetMapping("/post/postContents")
    @ApiOperation("发布内容表列表")
    public JsonResult<PagingResult<PostContentViewDto>> list(@RequestHeader("Authorization")String token,
                                                             @RequestParam(value = "truename",defaultValue = "")String truename,
                                                             @RequestParam(value = "academyid",defaultValue = "0")Long academyId,
                                                             @RequestParam(value = "categoryid",defaultValue = "0")Long categoryId,
                                                             @RequestParam(value = "reviewstate",defaultValue = "0")int reviewState,
                                                             @RequestParam(value = "state",defaultValue = "0")int state,
                                                             @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                             @RequestParam(value = "pagesize",defaultValue = "10")int pageSize);

    @PutMapping("/post/postContent/review")
    @ApiOperation("发布内容表审核")
    public JsonResult review(@RequestHeader("Authorization")String token,
                             @RequestParam("id") Long id,
                             @RequestParam("reviewstate") int reviewState);

    @PutMapping("/post/postContent/batchreview")
    @ApiOperation("发布内容表批量通过")
    public JsonResult batchReview(@RequestHeader("Authorization")String token,
                                  @RequestParam("ids") String ids,
                                  @RequestParam("reviewstate") int reviewState);

    @PutMapping("/post/postContent/enableordisable")
    @ApiOperation("发布内容表禁用启用")
    public JsonResult enableOrDisable(@RequestHeader("Authorization")String token,
                                      @RequestParam("id") Long id);
}
