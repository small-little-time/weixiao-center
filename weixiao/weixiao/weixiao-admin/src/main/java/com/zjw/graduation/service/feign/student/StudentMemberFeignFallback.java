package com.zjw.graduation.service.feign.student;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.student.StudentMemberDto;
import com.zjw.graduation.dto.student.StudentMemberViewDto;
import com.zjw.graduation.model.student.StudentMemberCreateModel;
import com.zjw.graduation.mvc.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentMemberFeignFallback implements StudentMemberFeign {

    private final static Logger logger = LoggerFactory.getLogger(StudentMemberFeignFallback.class);


    @Override
    public JsonResult<StudentMemberDto> detail(String token, Long id) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult delete(String token, Long id) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult disableOrEnable(String token, Long id) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult<StudentMemberDto> create(String token, StudentMemberCreateModel studentMemberCreateModel) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public boolean check(String token, String username) {
        logger.info("服务没有启动成功...");
        return false;
    }

    @Override
    public JsonResult<PagingResult<StudentMemberViewDto>> list(String token, int pageIndex, int pageSize, String username, int sex, Long academyId, Long areaId, Long state) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }

    @Override
    public JsonResult batchDelete(String token, String ids) {
        logger.info("服务没有启动成功...");
        return JsonResult.error("服务没有启动成功...");
    }
}
