package com.shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.PaymentDao;
import com.shop.dao.ProductDao;
import com.shop.domain.OrderInvoice;
import com.shop.domain.Payment;
import com.shop.domain.Product;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired
	ProductDao productDao;

	// Adding invoice, payment and customer information( product/products is
	// offically sold)
	@Override
	public synchronized String savePayment(Payment payment, List<Product> listProduct) {
		List<OrderInvoice> listInvoice = new ArrayList<>();
		// There any exits any product which is out of stock
		for (Product p : listProduct) {
			Product actualProduct = productDao.findByProductId(p.getProductId());
			double quantity = actualProduct.getQuantity() - p.getQuantity();
			if (quantity < 0)
				return "fail";
		}
		// order can be processed (all products in stock)
		for (Product p : listProduct) {
			// Creating new invoice
			OrderInvoice orderInvoice = new OrderInvoice();
			// get Product
			Product actualProduct = productDao.findByProductId(p.getProductId());
			double quantity = actualProduct.getQuantity() - p.getQuantity();

			// save actual product

			actualProduct.setQuantity(quantity);
			productDao.save(actualProduct);
			// Adding session date to invoice object.
			orderInvoice.setProductName(p.getProductName());
			orderInvoice.setCategory(p.getCategory());
			orderInvoice.setPrice(p.getPrice());
			orderInvoice.setQuantity(p.getQuantity());
			// adding list of invoice to payment
			listInvoice.add(orderInvoice);
		}
		payment.setListInvoice(listInvoice);
		payment.setPaymentDate(new Date() + "");
		paymentDao.save(payment);
		return "success";
	}

}
