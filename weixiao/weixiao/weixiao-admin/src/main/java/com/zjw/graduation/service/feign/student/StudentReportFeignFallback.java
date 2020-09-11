package com.zjw.graduation.service.feign.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.student.StudentReportDto;
import com.zjw.graduation.mvc.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentReportFeignFallback implements StudentReportFeign {

    private final static Logger logger = LoggerFactory.getLogger(StudentReportFeignFallback.class);

    @Override
    public JsonResult<PagingResult<StudentReportDto>> list(String token, int pageIndex, int pageSize, int state) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult delete(String token, Long id) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult reply(String token, Long id, String content) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult batchReply(String token, String ids, String content) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }
}
