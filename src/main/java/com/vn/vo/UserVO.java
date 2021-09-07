package com.vn.vo;

import java.io.Serializable;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Boolean active;

	private Boolean admin;

	private String email;

	private String name;

	private String password;

	private String photo;

	private String username;


	private List<OrderVO> orders;
	
	private List<RoleVO> roles;
	
}