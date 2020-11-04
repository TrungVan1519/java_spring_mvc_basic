package com.example.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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

	// Reading multiple properties files for overriding Annotation message
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasenames("classpath:validation", "classpath:other-validation");
		bundleMessageSource.setDefaultEncoding("utf-8");

		return bundleMessageSource;
	}
}
