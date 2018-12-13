package com.example.demo.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.example.demo.jwt.JWTFactory;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTFilter extends  GenericFilterBean  {

	@Autowired
	private JWTFactory jwtf;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
        	HttpServletRequest req = (HttpServletRequest) request;
        	log.info("req=>{}",req);
        	if(req.getRequestURI().indexOf("boardsave")!=-1) {
	        	String id = req.getHeader("X-Auth-Id");
	        	String token = req.getHeader("X-Auth-Token");
	        	Map<String,String> map = new HashMap<String,String>();
	        	map.put("id", id);
	        	map.put("token", token);
	        	try {
					jwtf.verifyJwt(map);
				} catch (Exception e) {
					throw new ServletException("Can't access service, please make sure your account!");
				}
        	}
        }
        chain.doFilter(request, response);
    }   
 
}
