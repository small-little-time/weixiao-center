package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostCategoryDto;
import com.zjw.graduation.mvc.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weixiao-student",fallback = PostCategoryFeignFallback.class ,contextId = "post-category")
public interface PostCategoryFeign {

    @GetMapping("/post/postCategories")
    @ApiOperation("内容类别表列表")
    public JsonResult<PagingResult<PostCategoryDto>> list(@RequestHeader("Authorization")String token,
                                                          @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize);
}
