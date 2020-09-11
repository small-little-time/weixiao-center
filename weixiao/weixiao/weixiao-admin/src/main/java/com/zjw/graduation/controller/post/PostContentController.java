package com.zjw.graduation.controller.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostContentViewDto;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.feign.post.PostContentFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "post.PostContentController", tags = "动态内容管理")
public class PostContentController {

    @Autowired
    private PostContentFeign postContentFeign;

    @GetMapping("/post/postContents")
    @ApiOperation("发布内容表列表")
    public JsonResult<PagingResult<PostContentViewDto>> list(@RequestHeader("Authorization")String token,
                                                             @RequestParam(value = "truename",defaultValue = "")String truename,
                                                             @RequestParam(value = "academyid",defaultValue = "0")Long academyId,
                                                             @RequestParam(value = "categoryid",defaultValue = "0")Long categoryId,
                                                             @RequestParam(value = "reviewstate",defaultValue = "0")int reviewState,
                                                             @RequestParam(value = "state",defaultValue = "0")int state,
                                                             @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                             @RequestParam(value = "pagesize",defaultValue = "10")int pageSize){
        return postContentFeign.list(token, truename, academyId, categoryId, reviewState, state, pageIndex, pageSize);
    }

    @PutMapping("/post/postContent/review")
    @ApiOperation("发布内容表审核")
    public JsonResult review(@RequestHeader("Authorization")String token,
                             @RequestParam("id") Long id,
                             @RequestParam("reviewstate") int reviewState){
        return postContentFeign.review(token, id, reviewState);
    }

    @PutMapping("/post/postContent/batchreview")
    @ApiOperation("发布内容表批量通过")
    public JsonResult batchReview(@RequestHeader("Authorization")String token,
                                  @RequestParam("ids") String ids,
                                  @RequestParam("reviewstate") int reviewState){
        return postContentFeign.batchReview(token, ids, reviewState);
    }

    @PutMapping("/postContent/enableordisable")
    @ApiOperation("发布内容表禁用启用")
    public JsonResult enableOrDisable(@RequestHeader("Authorization")String token,
                                      @RequestParam("id") Long id){
        return postContentFeign.enableOrDisable(token, id);
    }
}
