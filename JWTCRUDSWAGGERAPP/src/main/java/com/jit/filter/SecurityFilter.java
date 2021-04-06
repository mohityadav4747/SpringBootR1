package com.jit.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jit.jwt.JwtUtil;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
       //read token from autherization header postman
		String token=request.getHeader("Authorization");
		if(token != null) 
		  { 
			//do validate
			String userName =util.getUserName(token);
			//un should not be empty,context auth must be empty
			if(userName != null && SecurityContextHolder.getContext()
					.getAuthentication() == null)
			{
				
				UserDetails usr=userDetailsService.loadUserByUsername(userName);
				//validate token
				boolean isValid=util.validateToken(token, usr.getUsername());
			  
				if(isValid) {
				UsernamePasswordAuthenticationToken authToken=new
						UsernamePasswordAuthenticationToken(
								userName, usr.getPassword(),usr.getAuthorities()
								);
				authToken.setDetails(new WebAuthenticationDetailsSource()
						.buildDetails(request));
				//final obj store un pwd
				SecurityContextHolder.getContext().setAuthentication(authToken);
			   }
			}
		  }
			filterChain.doFilter(request, response);
		}
	}
