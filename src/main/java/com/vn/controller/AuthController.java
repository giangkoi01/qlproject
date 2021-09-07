package com.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vn.service.IpmUserServiceSystem;
import com.vn.vo.UserVO;

@RestController
public class AuthController {
	@Autowired
	private IpmUserServiceSystem userServiceSystem;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@PostMapping("/register")
	public UserVO readAll(@RequestBody UserVO VO) {
		VO.setPassword(encoder.encode(VO.getPassword()));
		userServiceSystem.create(VO);
		return VO;
	}
}
