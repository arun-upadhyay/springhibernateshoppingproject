package com.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.domain.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	Product findByProductId(int productId);

	Page<Product> findAll(Pageable pageable);

}
