package com.shop.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.shop.domain.Payment;
import com.shop.domain.Product;

public interface ProductService {
	public List<Product> findAllProduct();

	public void saveProduct(Product product);

	public List<Product> searchProductByProductName(String productName);

	public void deleteProduct(String productId);

	public double totalCheckout(List<Product> list);

	public List<Product> addToCart(List<Product> productsList, String productId);

	public List<Product> filterSessionData(List<Product> productsList, String productId);

	public double findQuantity(List<Product> productsList);

	public void lockIndividualItem(Payment payment);
	
	public List<Product> getAllProductsByPage(PageRequest pageRequest);
	//List<Post> postobj = postDao.getAllPostsByRank(new PageRequest(pageno,10));

	List<Product> findAllProductfromDb();
}
