package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/// The configuration file is required beancuse it having @Bean methods

@Configuration
public class passwordEncoder {

	
	
	/// @Bean is for telling the spring framework that the method will return the object that you have to manage
	/// you can write the @bean method in main class but for more readability and maintainability of code you create @configyration class
	/// main class focus on app entry but @configuartion will focus on the defining bean
	@Bean
	public PasswordEncoder passWordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
