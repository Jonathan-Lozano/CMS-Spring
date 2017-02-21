package com.cms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cms.component.RequestTimeInterseptor;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterseptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);  
	}
	
}
