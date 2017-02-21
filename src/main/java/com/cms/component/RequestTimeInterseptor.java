package com.cms.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterseptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterseptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '" + request.getRequestURI().toString() + "' -- TOTAL TIME: '" +(System.currentTimeMillis() - startTime) + "'ms");
	}
	
}
