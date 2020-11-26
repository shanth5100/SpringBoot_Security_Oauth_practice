package com.me.security.authServer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.me.service.UserDetailsService;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.exceptionHandling()
		.authenticationEntryPoint(
				(request, response, authException)->response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
		.and().authorizeRequests()
		.antMatchers("/**")
		.authenticated()
		.and().httpBasic();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authMngrBuilder) throws Exception {
		authMngrBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
