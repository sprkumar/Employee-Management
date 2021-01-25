package com.ravitech.empmgmt.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Ravindra
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration implements WebMvcConfigurer {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.apis(RequestHandlerSelectors.basePackage("com.ravitech.empmgmt.controller")).build()
				.apiInfo(csgApiInfo());
	}

	private ApiInfo csgApiInfo() {
		return new ApiInfo("Ravindra Kumar", "Employee Management System", "1.0", "Terms&Conditions by @ravindrakumar.",
				new springfox.documentation.service.Contact("Ravindra Kumar.", "ravindrakumarjrd@gmail.com",
						"ravindrakumarjrd@gmail.com"),
				"copy rights @ 2020", "Ravindra", Collections.emptyList());

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
