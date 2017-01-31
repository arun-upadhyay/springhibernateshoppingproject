package com.shop.service;

import java.util.List;

import com.shop.domain.Payment;
import com.shop.domain.Product;

public interface PaymentService {
	public String savePayment(Payment payment, List<Product> listProduct);
	

}
