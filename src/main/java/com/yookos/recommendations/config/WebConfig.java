package com.yookos.recommendations.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {

	
	@Bean
	MultipartConfigElement multipartConfigElement() {
		return new MultipartConfigElement("");
	}
	
}
