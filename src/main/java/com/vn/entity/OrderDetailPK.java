package com.vn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The primary key class for the orderdetail database table.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderDetailPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="product_id", insertable=false, updatable=false)
	private Integer productId;

	@Column(name="order_id", insertable=false, updatable=false)
	private Integer orderId;

	
	

}