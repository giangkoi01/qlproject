package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	    User findByUsername(String username);

}
