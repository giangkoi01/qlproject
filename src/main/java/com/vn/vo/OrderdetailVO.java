package com.vn.vo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderdetailVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailPKVO id;

	private Double price;

	private Integer quantity;

	private ProductVO product;

	private OrderVO order;

	
	

}