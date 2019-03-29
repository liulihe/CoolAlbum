package com.kkkitsch.coolalbum.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.kkkitsch.coolalbum.common.MyConstant.*;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyRequestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		// 如果没有经过登录，直接执行/member_home.html请求，会判断是否有session，进而判断是否要进行登录
		if (request.getSession().getAttribute(CUR_MEMBER) == null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
