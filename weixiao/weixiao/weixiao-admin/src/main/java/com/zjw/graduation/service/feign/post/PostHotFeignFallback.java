package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostHotDto;
import com.zjw.graduation.model.post.PostHotCreateModel;
import com.zjw.graduation.model.post.PostHotUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostHotFeignFallback implements PostHotFeign {

    private final static Logger logger = LoggerFactory.getLogger(PostHotFeignFallback.class);


    @Override
    public JsonResult<PagingResult<PostHotDto>> list(String token, int pageIndex, int pageSize, String title, int mostLook, int mostLike) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult<PostHotDto> create(String token, PostHotCreateModel postHotCreateModel) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult<PostHotDto> update(String token, PostHotUpdateModel postHotUpdateModel) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult delete(String token, Long id) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult batchDelete(String token, String ids) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }
}
