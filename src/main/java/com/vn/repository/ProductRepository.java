package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
