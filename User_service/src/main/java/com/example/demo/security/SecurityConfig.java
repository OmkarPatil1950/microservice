//package com.example.demo.security;
//
//import org.apache.http.protocol.HTTP;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Opaquetoken;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.security.oauth2.server.resource.introspection.NimbusOpaqueTokenIntrospector;
//import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
////@EnableMethodSecurity
//public class SecurityConfig {
//
////	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/users/save/**").permitAll()
//				.requestMatchers("/api/users/login").permitAll().anyRequest().permitAll())
//				.oauth2ResourceServer(OAuth2AccessToken -> OAuth2AccessToken
//						.opaqueToken(Opaquetoken -> Opaquetoken.introspector(introspector())));
//		/// as opaque token is not self-contained so all the roles and all details																					
//		/// are inside the token to read that all we need to externally introspect the
//		/// token and read
//		return http.build();
//
//	}
//
////	@Bean
//	public OpaqueTokenIntrospector introspector() {
//		// TODO Auto-generated method stub
//		return new NimbusOpaqueTokenIntrospector(
//				"http://localhost:8181/realms/Microservice/protocol/openid-connect/token/introspect", 
//				"microservice",
//				"VawghMCkZ0x0PtU4OfokZcTWv72yjL6R");/// nimbus is provided by the spring security and it introspect
//													/// token by making
//		/// request to the IntrospectionURI, for authorixed client and client secrete
//	}
//}
