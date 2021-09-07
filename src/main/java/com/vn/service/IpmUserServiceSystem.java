package com.vn.service;

import java.util.List;

import com.vn.vo.UserVO;



public interface IpmUserServiceSystem {

	public List<UserVO> readAll();
	
	public UserVO create(UserVO VO);
	
	public UserVO update(UserVO user);
	public UserVO delete( Integer id);
	public UserVO readById( Integer id);

}
