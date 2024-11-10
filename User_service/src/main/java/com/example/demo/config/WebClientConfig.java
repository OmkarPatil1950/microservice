package com.example.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

//	@Bean
//	public WebClient webclientbuilder() {   if we do like this it will give error of load balancing because WebClient type is not not creating load balancing when it is associated with webclient.builder()
//		return WebClient.builder().build();
//	}


	@Bean
	@LoadBalanced
	public WebClient.Builder webclientbuilder() {  /// if you want loadbalcing while calling web client with service name then you need to annotate but you cant use localhost here then you need to remove annotation
		return WebClient.builder();
	}
}
