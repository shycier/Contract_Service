package com.jzt56.jlp.contractservice.interceptor;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jzt56.jlp.contractservice.util.JsonUtils;

/**
 * 定义日志拦截器，打印 请求URL，请求方式，请求参数，请求耗时
 * @author Shycier
 *
 */
public class LoggerInterceptor implements HandlerInterceptor {
	
	private static final String START_TIME = "StartTime";
	
	private static final String LOGGER = "Logger";
	
	private static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LinkedHashMap<String, Object> logger = new LinkedHashMap<>();
		logger.put("URI", request.getRequestURI());
		logger.put("Method",request.getMethod());
		logger.put("Params",request.getParameterMap());
		request.setAttribute(START_TIME, System.currentTimeMillis());
		request.setAttribute(LOGGER, logger);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LinkedHashMap<String, Object> logger = (LinkedHashMap<String, Object>)request.getAttribute(LOGGER);
		long startTime = Long.valueOf(request.getAttribute(START_TIME).toString());
		long endTime = System.currentTimeMillis();
		logger.put("Time", endTime-startTime);
		log.info(JsonUtils.objectToJson(logger));
	}
	
	
	
}
