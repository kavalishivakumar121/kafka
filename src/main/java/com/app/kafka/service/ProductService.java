package com.app.kafka.service;

import com.app.core.ProductCreatedEvent;
import com.app.kafka.model.Product;

public interface ProductService {
	
	public ProductCreatedEvent saveProduct(Product product);

}
