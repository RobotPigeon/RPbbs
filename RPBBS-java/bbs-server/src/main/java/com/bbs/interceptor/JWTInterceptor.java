package com.bbs.interceptor;

import com.bbs.utils.JJWTUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * JWT验证拦截器
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置响应编码为UTF-8
        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        String token = request.getHeader("sign");
        // 跨域请求options 返回为空
        String str = "OPTIONS";
        if (str.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return false;
        }// 除了options跨域请求，都进入到jwt校验
        else {
            if (token == null) {
                response.getWriter().write("no token !");
                return false;
            }
            // 校验接口传进来的token信息
            Claims userData = JJWTUtils.parseJWT(token);
            if (userData == null) {
                response.getWriter().write("token verify failure !");
                return false;
            }
            return true;
        }
    }
}
