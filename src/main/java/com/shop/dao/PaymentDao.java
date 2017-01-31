package com.shop.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.domain.Payment;
import com.shop.domain.Product;

public interface PaymentDao extends JpaRepository<Payment, Long> {
	
	Product findByPaymentId(int paymenttId);
	
	Page<Payment> findAll(Pageable pageable);
	
}
