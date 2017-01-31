package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.domain.Payment;
import com.shop.domain.Product;
import com.shop.service.PaymentServiceImpl;

@Controller
public class PaymentController {
	@Autowired
	PaymentServiceImpl paymentServiceImpl;

	@RequestMapping("/payment")
	public String order(Payment payment, HttpSession session) {

		return "add-payment";
	}

	@RequestMapping("/process-order")
	public String processOrder(@Valid Payment payment, BindingResult bindingResult, Model model, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "add-payment";
		}
		List<Product> productList = (List<Product>) session.getAttribute("addToCart");
		String result = paymentServiceImpl.savePayment(payment, productList);
		if (result.equals("success"))
			model.addAttribute("message", "CONGRATULATION! YOUR ORDER IS CONFIRMED! ");
		else
			model.addAttribute("message", "SORRY! YOUR ORDER CANNOT BE PROCESSED! ");
		session.setAttribute("addToCart", null);
		return "order-message";
	}

}
