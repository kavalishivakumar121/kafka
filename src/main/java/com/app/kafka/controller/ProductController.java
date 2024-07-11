package com.app.kafka.controller;

import org.aspectj.weaver.bcel.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.core.ProductCreatedEvent;
import com.app.kafka.model.Product;
import com.app.kafka.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity<ProductCreatedEvent> createProduct(@RequestBody Product product) {
		ProductCreatedEvent saveProduct = productService.saveProduct(product);
		return new ResponseEntity<ProductCreatedEvent>(saveProduct,HttpStatus.CREATED);
	}
	

}
