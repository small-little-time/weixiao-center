package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostCategoryDto;
import com.zjw.graduation.mvc.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostCategoryFeignFallback implements PostCategoryFeign {

    private final static Logger logger = LoggerFactory.getLogger(PostCategoryFeignFallback.class);

    @Override
    public JsonResult<PagingResult<PostCategoryDto>> list(String token, int pageIndex, int pageSize) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }
}
