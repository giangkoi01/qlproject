package com.vn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entity.Product;
import com.vn.repository.CategoryRepository;
import com.vn.repository.ProductRepository;
import com.vn.vo.ProductVO;

@Service
public class ProductService implements IpmProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<ProductVO> readAll() {
//		List<ProductVO> listVO = new ArrayList<ProductVO>();
//		List<Product> product = productRepository.findAll();
//
//		for (Product entities : product) {
//			ProductVO VO = new ProductVO();
//			BeanUtils.copyProperties(entities, VO);
//			listVO.add(VO);
//		}
//		return listVO;
		List<ProductVO> voList = new ArrayList<ProductVO>();
		List<Product> entities = productRepository.findAll();
		for (Product entity : entities) {
			ProductVO vo = new ProductVO();
			BeanUtils.copyProperties(entity, vo);
			vo.setCategory_id(entity.getCategory().getId());
			voList.add(vo);
		}
		return voList;

	}

	@Override
	public ProductVO create(ProductVO VO) {
		Product entities = new Product();
		BeanUtils.copyProperties(VO, entities);
		entities.setCategory(categoryRepository.getById(VO.getCategory_id()));
		productRepository.save(entities);
		VO.setId(entities.getId());
		return VO;
	}

	@Override
	public ProductVO update(ProductVO VO) {
		Optional<Product> optional = productRepository.findById(VO.getId());
		if (optional.isPresent()) {

			Product entities = optional.get();
			entities.setCategory(categoryRepository.getById(VO.getCategory_id()));
			BeanUtils.copyProperties(VO, entities);
			productRepository.save(entities);
		}
		return VO;
	}

	@Override
	public ProductVO delete(Integer id) {

		ProductVO VO = new ProductVO();
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {

			Product entities = optional.get();

			BeanUtils.copyProperties(entities, VO);
			productRepository.delete(entities);
		}
		return VO;
	}

	@Override
	public ProductVO readById(Integer id) {

		ProductVO VO = new ProductVO();
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {

			Product entities = optional.get();
			BeanUtils.copyProperties(entities, VO);
		}
		return VO;
	}

}
