package com.furit.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.furit.shop.service.UserInfoService;
import com.furit.shop.vo.UserInfoVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Component
public class AuthInterceptor implements HandlerInterceptor{
	@Autowired
	private UserInfoService userService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			UserInfoVO user = new UserInfoVO();
			user.setUiId("test100");
			user.setUiPwd("1234");
			userService.login(user, session);
//			response.sendRedirect("/views/user/login");
//			return false;
		}
		return true;
	}
}
