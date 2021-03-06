package com.vn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/user/info")
	public Authentication readAll() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
