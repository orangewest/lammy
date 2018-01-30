package com.peng.lammy.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.peng.lammy.base.constant.SysConstant;
import com.peng.lammy.base.exception.BaseRuntimeException;
import com.peng.lammy.base.response.ExceptionType;
import com.peng.lammy.domain.po.User;

@Component
public class UserInterceptor implements HandlerInterceptor {

	@Autowired
	private FilterUrlsPropertiesConifg filterUrlsPropertiesConifg;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		for (String url : filterUrlsPropertiesConifg.getUrls()) {
			if (url.contains(request.getRequestURI())) {
				return true;
			}
		}
		User user = (User) request.getSession().getAttribute(SysConstant.USER);
		if (user == null) {
			throw new BaseRuntimeException(ExceptionType.FORBIDDEN);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
