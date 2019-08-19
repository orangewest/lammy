package com.peng.lammy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.peng.lammy.base.constant.SysConstant;
import com.peng.lammy.domain.po.User;

public final class UserUtils {

	private static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	/**
	 * 从session中获取用户
	 * 
	 * @param session
	 * @return user
	 */
	public static User getUser() {
		return (User) getSession().getAttribute(SysConstant.USER);
	}

	public static void setUser(User user) {
		getSession().setAttribute(SysConstant.USER, user);
	}

	public static void removeUser() {
		HttpSession session = getSession();
		session.removeAttribute(SysConstant.USER);
		session.invalidate();
	}
}
