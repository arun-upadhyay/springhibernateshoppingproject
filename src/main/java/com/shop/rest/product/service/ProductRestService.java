package com.shop.rest.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.domain.Product;
import com.shop.service.ProductServiceImpl;

@Controller
@RequestMapping("/restservices")
public class ProductRestService {
	@Autowired
	ProductServiceImpl productServiceImpl;

	@RequestMapping("/view-all-product-serives")
	public @ResponseBody List<Product> viewProductServices() {
		List<Product> list = new ArrayList<>();
		List<Product> listProducts = productServiceImpl.findAllProduct();
		for(Product product: listProducts){
			Product p = new Product();
			p.setProductId(product.getProductId());
			p.setProductName(product.getProductName());
			return listProducts;
		}
		
		return list;
	}
	@RequestMapping("/product-rest")
	public String displayProductServices(){
		return "restservices/product-rest";
	}

}
