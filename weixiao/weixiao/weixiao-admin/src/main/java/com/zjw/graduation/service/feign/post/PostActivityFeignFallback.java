package com.zjw.graduation.service.feign.post;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostActivityViewDto;
import com.zjw.graduation.dto.post.PostSignViewDto;
import com.zjw.graduation.mvc.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostActivityFeignFallback implements PostActivityFeign {

    private final static Logger logger = LoggerFactory.getLogger(PostActivityFeignFallback.class);


    @Override
    public JsonResult<PagingResult<PostActivityViewDto>> list(String token, String truename, String title, Long categoryId, Long academyId, int type, int state, int pageIndex, int pageSize) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult review(String token, Long id, int state) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult batchPass(String token, String ids, int state) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult<PagingResult<PostSignViewDto>> singList(String token, Long activityId, String truename, int pageIndex, int pageSize) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }
}
