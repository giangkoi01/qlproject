package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
