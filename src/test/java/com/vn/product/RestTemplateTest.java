package com.vn.product;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	public static void main(String[] args) {
		RestTemplate  restTemplate =new RestTemplate();
		String data= restTemplate.getForObject("http://localhost:8888/product", String.class);
		System.out.println(data);
	}
}
