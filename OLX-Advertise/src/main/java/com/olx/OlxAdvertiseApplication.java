package com.olx;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OlxAdvertiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxAdvertiseApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.olx"))
//				.paths(PathSelectors.ant("/stockapp/*"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Stock REST API Documentation",
				"This page gives REST API documentation for OLX APP",
				"2.5",
				"My Terms of Service",
				new Contact("Pavan Kumar","https://photofreak007.site123.me/","pavankumar.dasari@zensar.com"),
				"GPL",
				"http://gpl.org",
				new ArrayList<VendorExtension>());
		
		return apiInfo;
	}

}
