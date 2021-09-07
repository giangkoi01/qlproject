package com.vn.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the user database table.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;
	
}