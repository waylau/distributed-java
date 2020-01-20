package com.waylau.spring.mvc.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC Configuration.
 * 
 * @since 1.0.0 2018年3月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
	}
}
