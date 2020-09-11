package com.zjw.graduation.interceptor;

import cn.hutool.json.JSONUtil;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader(tokenHeader);
        if ( handler != null ){
            String authToken = header.substring(this.tokenHead.length());// The part after "Bearer "
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            String token = (String) redisTemplate.opsForValue().get(username);
            if (token != null && token.equals(authToken)){
                return true;
            }else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().println(JSONUtil.parse(JsonResult.error("token 失效，请重新登录！！！")));
                response.getWriter().flush();
                return false;
            }
        }
        return false;
    }
}
