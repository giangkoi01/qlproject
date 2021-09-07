package com.vn.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer avaiable;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	private String image;
	
	private String name;

	private Double price;

	private List<OrderdetailVO> orderDetails;

	private CategoryVO category;
	
	private Integer category_id;
	
}