package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostActivityViewDto;
import com.zjw.graduation.dto.post.PostSignViewDto;
import com.zjw.graduation.mvc.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weixiao-student",fallback = PostActivityFeignFallback.class,contextId = "post-activity")
public interface PostActivityFeign {

    @GetMapping("/post/postActivities")
    @ApiOperation("活动发布表列表")
    public JsonResult<PagingResult<PostActivityViewDto>> list(@RequestHeader("Authorization")String token,
                                                              @RequestParam(value = "truename",defaultValue = "")String truename,
                                                              @RequestParam(value = "title",defaultValue = "")String title,
                                                              @RequestParam(value = "categoryid",defaultValue = "0")Long categoryId,
                                                              @RequestParam(value = "academyid",defaultValue = "0")Long academyId,
                                                              @RequestParam(value = "type",defaultValue = "0")int type,
                                                              @RequestParam(value = "state",defaultValue = "0")int state,
                                                              @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                              @RequestParam(value = "pagesize",defaultValue = "10")int pageSize);

    @PutMapping("/post/postActivity/review")
    @ApiOperation("活动发布表审核")
    public JsonResult review(@RequestHeader("Authorization")String token,
                             @RequestParam("id") Long id,
                             @RequestParam("state") int state);

    @PutMapping("/post/postActivity/batchpass")
    @ApiOperation("活动发布表批量审核")
    public JsonResult batchPass(@RequestHeader("Authorization")String token,
                                @RequestParam("ids") String ids,
                                @RequestParam("state") int state);

    @GetMapping("/post/postSigns")
    @ApiOperation("活动报名表列表")
    public JsonResult<PagingResult<PostSignViewDto>> singList(@RequestHeader("Authorization")String token,
                                                          @RequestParam(value = "activityid",defaultValue = "0")Long activityId,
                                                          @RequestParam(value = "truename",defaultValue = "")String truename,
                                                          @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize);
}
