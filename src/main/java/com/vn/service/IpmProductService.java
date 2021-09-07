package com.vn.service;

import java.util.List;

import com.vn.vo.ProductVO;


public interface IpmProductService {

	public List<ProductVO> readAll();
	
	public ProductVO create(ProductVO VO);
	
	public ProductVO update(ProductVO VO);
	public ProductVO delete( Integer id);
	public ProductVO readById( Integer id);

}
