package com.vn.service;

import java.util.List;

import com.vn.vo.CategoryVO;

public interface IpmCategoryService {

	public List<CategoryVO> readAll();

	public CategoryVO create(CategoryVO category);

	public CategoryVO update(CategoryVO category);

	public CategoryVO delete(Integer id);

	public CategoryVO readById(Integer id);

}
