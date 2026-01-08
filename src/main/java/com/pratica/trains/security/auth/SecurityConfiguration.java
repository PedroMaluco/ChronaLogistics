package com.pratica.trains.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@Autowired
	private LogoutHandler logoutHandler;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.disable())
		.logout(
				(logout) -> logout.addLogoutHandler(logoutHandler)
				.logoutSuccessHandler(
						(request, response, authentication) -> SecurityContextHolder.clearContext()
						)
				.logoutUrl("/authentication/logout")
				)
		
		
		
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/authentication/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/chronaLog").hasRole("ENGENHEIRO_CHEFE")
				.requestMatchers(HttpMethod.PUT, "/chronaLog").hasRole("ENGENHEIRO_CHEFE")
				.anyRequest().authenticated())
		.sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
		

		
		;
		
		
		return http.build();
	}
	
	

}
