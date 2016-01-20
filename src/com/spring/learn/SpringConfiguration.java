package com.spring.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value="com.*")
public class SpringConfiguration extends WebMvcConfigurerAdapter{
	@Bean
	public BubbleSort getSort(){
		return new BubbleSort();
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	@Override
	/**
	 * configure the default servlet to handle static sources accessing.
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	/*@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tile = new TilesConfigurer();
		tile.setDefinitions(new String[]{
				"/WEB-INF/layout/tiles.xml"
		});
		tile.setCheckRefresh(true);
		return tile;
	}
	
	@Bean
	public ViewResolver tilesViewReslover(){
		return new TilesViewResolver();
	}
	*/
	
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
}
