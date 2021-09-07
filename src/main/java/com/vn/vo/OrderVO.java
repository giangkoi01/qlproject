package com.vn.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String address;

	private Integer status;

	private UserVO user;

	private List<OrderdetailVO> orderdetails;
}