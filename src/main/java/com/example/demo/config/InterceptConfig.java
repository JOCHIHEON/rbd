package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.aop.AdminInterceptor;
import com.example.demo.aop.SessionAdvice;

@Configuration
public class InterceptConfig implements WebMvcConfigurer, WebMvcRegistrations {

	@Autowired
	private AdminInterceptor adminInterceptor;
	@Autowired
	private SessionAdvice sessionAdvice;
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
    }
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin").addPathPatterns("/admin/**")
				.excludePathPatterns("/**"); // pattern 매핑, pattern 제외
		registry.addInterceptor(sessionAdvice).addPathPatterns("/**").excludePathPatterns("/all/**")
				.excludePathPatterns("/login").excludePathPatterns("/sign/**").excludePathPatterns("/sign")
				.excludePathPatterns("/admini").excludePathPatterns("/admin").excludePathPatterns("/admin/**");
	}

}
