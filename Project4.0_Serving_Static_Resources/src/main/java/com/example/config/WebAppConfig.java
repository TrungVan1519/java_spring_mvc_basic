package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.*")
public class WebAppConfig implements WebMvcConfigurer {

	// View folder for containing view file (jsp file)
	@Bean()
	public ViewResolver pageViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		// setOrder to use other ViewResolvers at the same time
		// In this situation, we combine InternalResourceViewResolver and
		// TilesViewResolver
		viewResolver.setOrder(2);

		return viewResolver;
	}

	// Static Resources
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// system file in project
		registry.addResourceHandler("/static-source/**").addResourceLocations("/source/");

		// system file not in project, it's in another folder in computer
		// Cach 1:
		// registry.addResourceHandler("/source-image/**")
		// 		   .addResourceLocations("file:///C:/Users/Admin/Desktop/test upload file/");

		// Cach 2:
		registry.addResourceHandler("/server-source/**")
				.addResourceLocations("file:C:/Users/Admin/Desktop/TDoc/TDoc_UploadedFile/");
	}
}
