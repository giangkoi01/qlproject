package com.vn.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entity.Role;
import com.vn.entity.User;
import com.vn.entity.UserRole;
import com.vn.repository.RoleRepository;
import com.vn.repository.UserRepository;
import com.vn.repository.UserRoleRepository;
import com.vn.vo.RoleVO;
import com.vn.vo.UserVO;

@Service
public class UserServiceSystem implements IpmUserServiceSystem{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<UserVO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO create(UserVO VO) {
		User entities = new User();
		BeanUtils.copyProperties(VO, entities);
		userRepository.save(entities);
		VO.setId(entities.getId());
		// save userRole
		List<RoleVO> inputRole= VO.getRoles();
		
		 List<UserRole> userRoles =inputRole.stream().map(e -> {
			 UserRole userRole=new UserRole();
			 
			Optional<Role> optional= roleRepository.findById(e.getId());
			if(optional.isPresent()) {
				userRole.setRole(optional.get());
			}
			 
			 userRole.setUser(entities);
			 
			return userRole;
			
		}).collect(Collectors.toList());
		 userRoleRepository.saveAll(userRoles);
		
		return VO;
//		User entity = new User();
//		BeanUtils.copyProperties(VO, entity);
//		userRepository.save(entity);
//		VO.setId(entity.getId());
//		
//		// create role to userRole table
//		List<UserRole> userRoles = VO.getRoleVO().stream().map(e-> {
//			UserRole userRole = new UserRole();
//			
//			Integer roleId = e.getId();
//			Role role = roleRepository.findById(roleId).get();
//			
//			userRole.setRole(role);
//			userRole.setUser(entity);
//			return userRole;
//		}).collect(Collectors.toList());
//		userRoleRepository.saveAll(userRoles);
//		
//		return VO;
	}

	@Override
	public UserVO update(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO readById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
