package com.app.kafka.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.app.core.ProductCreatedEvent;
import com.app.core.ProductDto;
import com.app.kafka.constants.ProductConstants;
import com.app.kafka.entity.ProductEntity;
import com.app.kafka.model.Product;
import com.app.kafka.repo.ProductRepo;
import com.app.kafka.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private KafkaTemplate<String, ProductCreatedEvent> kafkatemplate;
	@Autowired
	private ProductRepo repo;

	public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkatemplate, ProductRepo repo) {
		this.kafkatemplate = kafkatemplate;
		this.repo = repo;
	}

	public ProductCreatedEvent saveProduct(Product product) {
		ProductEntity entity=new ProductEntity();
		ProductCreatedEvent event=new ProductCreatedEvent();
		try {
			ProductDto productDto=getProductValues(product);
			entity.setProd_name(productDto.getProduct_name());
			entity.setProd_price(productDto.getProduct_price());
			entity.setProd_quantity(productDto.getProduct_quantity());
			
			repo.save(entity);
			log.info("product data stored in db with :"+entity.getId());
			productDto.setProduct_Id(entity.getId());
			event.setProduct(productDto);
			event.setStatus("ORDER-CREATED");
			kafkatemplate.send(ProductConstants.TOPIC_NAME,event);
			log.info("*******Product data sent to Kafka Topic "+ProductConstants.TOPIC_NAME);
		}
		catch (Exception e) {

			log.error("****product data not sent to topic *******");
			e.printStackTrace();
		}
		
		return event;
	}
	
	private ProductDto getProductValues(Product product) {
		ProductDto dto=new ProductDto();
		dto.setProduct_name(product.getProduct_name());
		dto.setProduct_price(product.getProduct_price());
		dto.setProduct_quantity(product.getProduct_quantity());
		dto.setPhoneNo(product.getPhoneNo());
		dto.setEmail(product.getEmail());
		return dto;
	}




}
