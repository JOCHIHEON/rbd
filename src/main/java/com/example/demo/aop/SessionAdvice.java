package com.example.demo.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SessionAdvice extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("session check before");
		HttpSession session = request.getSession();
		log.debug("id =>", session.getAttribute("id") );
		log.debug("no =>", session.getAttribute("no") );
		Integer uNo = session.getAttribute("no")==null?0:(int)session.getAttribute("no");
		if(session == null || uNo == 0) {
			throw new Exception("None Member");
		}
		return super.preHandle(request, response, handler);
	}
}
