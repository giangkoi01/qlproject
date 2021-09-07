package com.vn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vn.controller.auth.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}  
	
	@Autowired
	UserService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String passwordEncrypt = encoder.encode("123");
//		
//		auth.inMemoryAuthentication()
//		.withUser("user1").password(passwordEncrypt).roles("USER", "GUEST")
//		.and()
//		.withUser("user2").password(passwordEncrypt).roles("USER", "ADMIN")
//		.and()
//		.withUser("user3").password(passwordEncrypt).roles("GUEST");
//		
		
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable().csrf().disable();
		
		http.authorizeRequests()
		.regexMatchers("/login","/web/*").permitAll()
		.anyRequest().authenticated();
		
//		http.httpBasic();
		http.formLogin()
		   .loginPage("/login")
		   .defaultSuccessUrl("/admin/product")
		   .failureUrl("/web")
		   .permitAll();
		
		
	}
	
}
