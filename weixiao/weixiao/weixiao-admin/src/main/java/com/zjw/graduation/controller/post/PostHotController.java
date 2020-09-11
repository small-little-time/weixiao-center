package com.zjw.graduation.controller.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostHotDto;
import com.zjw.graduation.entity.post.PostHot;
import com.zjw.graduation.model.post.PostHotCreateModel;
import com.zjw.graduation.model.post.PostHotUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.feign.post.PostHotFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "post.PostHotController", tags = "热点管理")
public class PostHotController {

    @Autowired
    private PostHotFeign postHotFeign;

    @GetMapping("/post/postHots")
    @ApiOperation("热点内容表列表")
    public JsonResult<PagingResult<PostHotDto>> list(@RequestHeader("Authorization")String token,
                                                     @RequestParam(value = "pageindex", defaultValue = "0") int pageIndex,
                                                     @RequestParam(value = "pagesize", defaultValue = "10") int pageSize,
                                                     @RequestParam(value = "title", defaultValue = "") String title,
                                                     @RequestParam(value = "mostlook", defaultValue = "0") int mostLook,
                                                     @RequestParam(value = "mostlike", defaultValue = "0") int mostLike){
        return postHotFeign.list(token, pageIndex, pageSize, title, mostLook, mostLike);
    }

    @PostMapping("/post/postHot")
    @ApiOperation("热点内容表新增")
    public JsonResult<PostHotDto> create(@RequestHeader("Authorization")String token,
                                         @Validated @RequestBody PostHotCreateModel postHotCreateModel){
        return postHotFeign.create(token, postHotCreateModel);
    }

    @PutMapping("/post/postHot")
    @ApiOperation("热点内容表修改")
    public JsonResult<PostHotDto> update(@RequestHeader("Authorization")String token,
                                      @Validated @RequestBody PostHotUpdateModel postHotUpdateModel){
        return postHotFeign.update(token, postHotUpdateModel);
    }

    @DeleteMapping("/post/postHot/{id}")
    @ApiOperation("热点内容表删除")
    public JsonResult delete(@RequestHeader("Authorization")String token,
                             @PathVariable("id") Long id){
        return postHotFeign.delete(token, id);
    }

    @DeleteMapping("/post/postHot/batchdelete")
    @ApiOperation("热点内容表批量删除")
    public JsonResult batchDelete(@RequestHeader("Authorization")String token,
                                  @RequestParam("ids") String ids){
        return postHotFeign.batchDelete(token, ids);
    }
}
