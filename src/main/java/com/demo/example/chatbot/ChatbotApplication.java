
package com.demo.example.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableSwagger2
public class ChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.example.chatbot.controller")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Chatbot API").description("Chatbot API reference for developers")
				.termsOfServiceUrl("https://www.caprusit.com/").contact(new Contact("support@chatbot.com", "URL", "support@chatbot.com"))
				.license("Chatbot license").licenseUrl("support@chatbot.com").version("1.0").build();
	}
	}

