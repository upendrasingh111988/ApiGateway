package com.lcwd.ApiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityWebFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.oauth2Client()
				.and()
				.oauth2ResourceServer()
				.jwt();
		
		return httpSecurity.build();
	}

}
