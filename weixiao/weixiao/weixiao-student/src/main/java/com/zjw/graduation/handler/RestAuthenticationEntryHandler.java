package com.zjw.graduation.handler;

import cn.hutool.json.JSONUtil;
import com.zjw.graduation.enums.EnumStatusType;
import com.zjw.graduation.mvc.JsonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当未登录或者token失效访问接口时，自定义的返回结果
 * Created by zjw on 2019/11/21.
 */
@Component
public class RestAuthenticationEntryHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(JsonResult.error(EnumStatusType.LOSE.getValue(),"token 无效，请重新登录！！！")));
        response.getWriter().flush();
    }
}
