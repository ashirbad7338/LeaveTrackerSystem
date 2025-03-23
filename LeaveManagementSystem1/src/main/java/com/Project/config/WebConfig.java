//package com.Project.config;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class WebConfig implements WebMvcConfigurer{
//	 @Override
//	 public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**")  // Allow all endpoints
//	                .allowedOrigins("http://localhost:5173")  // Allow requests from your frontend origin
//	                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these HTTP methods
//	                .allowedHeaders("*")  // Allow all headers
//	                .allowCredentials(true);
//	    }
//
//}
