package com.zjw.graduation.controller.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostCategoryDto;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.feign.post.PostCategoryFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "post.PostCategoryController", tags = "类型管理")
public class PostCategoryController {

    @Autowired
    private PostCategoryFeign postCategoryFeign;

    @GetMapping("/post/postCategories")
    @ApiOperation("内容类别表列表")
    public JsonResult<PagingResult<PostCategoryDto>> list(@RequestHeader("Authorization")String token,
                                                          @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize){
        return postCategoryFeign.list(token, pageIndex, pageSize);
    }
}
