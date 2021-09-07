package com.vn.service;

import java.util.List;

import com.vn.vo.OrderVO;


public interface IpmOrderService {

	public List<OrderVO> readAll();
	
	public OrderVO create(OrderVO order);
	
	public OrderVO update(OrderVO order);
	public OrderVO delete( Integer id);
	public OrderVO readById( Integer id);

}
