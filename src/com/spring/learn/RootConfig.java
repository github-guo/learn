package com.spring.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.repository.SpittlRepository;
import com.repository.SpittleRepositoryImpl;

import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ImportResource("classpath*:webflow.xml")
@ComponentScan(excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {
	@Bean
	public SpittlRepository getSpittleRepository(){
		return new SpittleRepositoryImpl();
	}
}
