package com.app.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.kafka.entity.ProductEntity;
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
