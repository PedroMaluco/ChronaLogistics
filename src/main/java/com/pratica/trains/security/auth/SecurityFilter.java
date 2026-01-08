package com.pratica.trains.security.auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pratica.trains.security.config.JWTService;
import com.pratica.trains.token.TokenRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	private final JWTService jwtService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenRepository tokenRepository;

    SecurityFilter(JWTService jwtService) {
        this.jwtService = jwtService;
    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
				

			String path = request.getServletPath();
			if(path.contains("/authentication/login") || path.contains("/authentication/register")) {
				filterChain.doFilter(request, response);
				return;
			}
		
			String authHeader = request.getHeader("Authorization");
			String jwt;
			String userEmail;
			
			if(authHeader == null || !authHeader.startsWith("Bearer")) {
				filterChain.doFilter(request, response);
				return;
			}
			
			jwt = authHeader.substring(7);
			userEmail = jwtService.extractUsername(jwt);
			
			if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
				var isTokenValid = tokenRepository.findByToken(jwt)
				          .map(t -> !t.isExpired() && !t.isRevoked())
				          .orElse(false);
				if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
			        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
			            userDetails,
			            null,
			            userDetails.getAuthorities()
			        );
			        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			        SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
			filterChain.doFilter(request, response);
	}
}
