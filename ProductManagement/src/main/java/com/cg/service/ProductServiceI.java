package com.cg.service;

import java.util.List;

import com.cg.dto.ProductDto;
import com.cg.entity.Product;

public interface ProductServiceI {

	public Product addProduct(ProductDto dto);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Integer id);
	
	public Product updateProduct(ProductDto dto);
	
}
