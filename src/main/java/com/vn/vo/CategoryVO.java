package com.vn.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private String name;

	private List<ProductVO> products;

}