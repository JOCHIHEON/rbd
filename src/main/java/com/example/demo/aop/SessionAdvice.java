package com.example.demo.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.config.PassEncryption;
import com.example.demo.service.SignService;
import com.example.demo.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SessionAdvice extends HandlerInterceptorAdapter{
	@Autowired 
	private SignService signService;
	@Value("${ex.is.dev}")
	private boolean isDev;
	
	private void loginForDev(HttpSession session) {
		UserInfoVO userVo= new UserInfoVO();
		userVo.setUi_id("test1");
		userVo.setUi_pwd(PassEncryption.encPwd("test1"));
		userVo = signService.selectSign(userVo);
		if(userVo.getUi_no() != 0) {
			session.setAttribute("id", userVo.getUi_id());
			session.setAttribute("no", userVo.getUi_no());
			log.debug("userVo =>{}",userVo.toString());
			log.debug("session no => {}",session.getAttribute("no"));
			log.debug("session =>{}", session.getAttribute("id"));
		}
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("session check before");
		HttpSession session = request.getSession();
		log.debug("id =>", session.getAttribute("id") );
		log.debug("no =>", session.getAttribute("no") );
		if(isDev && session.getAttribute("no")==null) {
			loginForDev(session);
		}
		Integer uNo = session.getAttribute("no")==null?0:(int)session.getAttribute("no");
		
		if(session == null || uNo == 0) {
			throw new Exception("None Member");
		}
		return super.preHandle(request, response, handler);
	}
}
