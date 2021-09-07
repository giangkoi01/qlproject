package com.vn.service;

import java.util.List;

import com.vn.vo.OrderdetailVO;


public interface IpmOrderDetailService {

	public List<OrderdetailVO> readAll();
	
	public OrderdetailVO create(OrderdetailVO orderdetail);
	
	public OrderdetailVO update(OrderdetailVO orderdetail);
	public OrderdetailVO delete( Integer id);
	public OrderdetailVO readById( Integer id);

}
