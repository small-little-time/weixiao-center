package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostContentViewDto;
import com.zjw.graduation.mvc.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostContentFeignFallback implements PostContentFeign {

    private final static Logger logger = LoggerFactory.getLogger(PostContentFeignFallback.class);

    @Override
    public JsonResult<PagingResult<PostContentViewDto>> list(String token, String truename, Long academyId, Long categoryId, int reviewState, int state, int pageIndex, int pageSize) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult review(String token, Long id, int reviewState) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult batchReview(String token, String ids, int reviewState) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult enableOrDisable(String token, Long id) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }
}
