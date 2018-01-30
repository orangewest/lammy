package com.peng.lammy.base.interceptor.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.peng.lammy.base.interceptor.UserInterceptor;

@Configuration
public class SysWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor()).addPathPatterns("/**");
	}

	@Bean
	public UserInterceptor userInterceptor() {
		return new UserInterceptor();
	}
}
