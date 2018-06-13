package com.jzt56.jlp.contractservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.jzt56.jlp.contractservice.interceptor.LoggerInterceptor;

/**
 * 注册拦截器，拦截请求，打印日志
 * @author Shycier
 *
 */

@Configuration
public class LoggerConfiguration implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/ContractService/**");
	}
		
}
