package com.example.config; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.*")
public class WebAppConfig implements WebMvcConfigurer{
	
	//---------------------------------------------------------------------
	// View folder for containing view file (jsp file)
	@Bean()
	public ViewResolver pageViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/custom-view/");
		viewResolver.setSuffix(".jsp");
		// setOrder to use other ViewResolvers at the same time
		// In this situation, we combine InternalResourceViewResolver and TilesViewResolver
		viewResolver.setOrder(2);
		
		return viewResolver;
	}

	//---------------------------------------------------------------------
	// Spring Tile 3
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:tiles.xml");
		tilesConfigurer.setCheckRefresh(true);
		
		return tilesConfigurer;
	}
	
	@Bean("tilesViewResolver")
	public ViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		// setOrder to use other ViewResolvers at the same time
		// In this situation, we combine InternalResourceViewResolver and TilesViewResolver
		viewResolver.setOrder(1);
		
		return viewResolver;
	}
}
