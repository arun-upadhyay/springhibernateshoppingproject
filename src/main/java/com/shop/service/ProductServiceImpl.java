package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.shop.dao.ProductDao;
import com.shop.domain.IndividualItem;
import com.shop.domain.Payment;
import com.shop.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> findAllProduct() {
		List<Product> productList = new ArrayList<>();
		for (Product p : productDao.findAll())
			if (p.getQuantity() > 0)
				productList.add(p);
		return productList;
	}

	@Override
	public List<Product> findAllProductfromDb() {

		return productDao.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		List<IndividualItem> listIndividualItem = new ArrayList<>();
		for (int i = 1; i < product.getQuantity(); i++) {
			IndividualItem individualItem = new IndividualItem();
			individualItem.setIsAvailable("true");
			listIndividualItem.add(individualItem);

		}
		product.setItemsList(listIndividualItem);
		productDao.save(product);
	}

	// delete product based on productid
	@Override
	public void deleteProduct(String productId) {
		Product product = productDao.findByProductId(Integer.parseInt(productId));
		productDao.delete(product);
	}

	public Product getProductByProductId(String productId) {
		return productDao.findByProductId(Integer.parseInt(productId));
	}

	@Override
	public List<Product> searchProductByProductName(String productName) {
		List<Product> productLists = new ArrayList<>();
		System.out.println("shova=" + productName);
		if (productName.trim().equals(""))
			productLists = productDao.findAll();
		else
			for (Product p : productDao.findAll()) {
				if (p.getProductName().toLowerCase().startsWith(productName.toLowerCase()))
					productLists.add(p);
			}

		return productLists;

	}

	@Override
	public double totalCheckout(List<Product> list) {
		double total = 0;
		for (Product p : list)
			total = total + p.getPrice();
		return total;
	}

	@Override
	public List<Product> addToCart(List<Product> productsList, String productId) {
		Product p = this.getProductByProductId(productId);
		if (productsList.size() == 0) {
			// first product added to arrraylist
			if (p.getQuantity() >= 1) {
				p.setQuantity(1);
				productsList.add(p);
			}
		} else {
			boolean absent = true;
			for (Product prod : productsList) {
				// same product is added multiple times.
				if (prod.getProductId() == p.getProductId()) {

					absent = false;
					// session product quantity should not exceed actual product
					// quantity
					if (prod.getQuantity() < p.getQuantity()) {
						prod.setQuantity(prod.getQuantity() + 1);
						prod.setPrice(prod.getPrice() + p.getPrice());
					}
					break;
				}

			}
			// first time product is added to arraylist
			if (absent && p.getQuantity() >= 1) {
				p.setQuantity(1);
				productsList.add(p);
			}

		}
		return productsList;
	}

	@Override
	public void lockIndividualItem(Payment payment) {

	}

	/*
	 * filter and remove the product information from session whose information
	 * is deleted from product table
	 */
	@Override
	public List<Product> filterSessionData(List<Product> productsList, String productId) {
		List<Product> filterProductList = new ArrayList<>();
		for (Product product : productsList) {
			if (product.getProductId() != Integer.parseInt(productId))
				filterProductList.add(product);
		}
		System.out.println("shova" + filterProductList);
		return filterProductList;
	}

	@Override
	public double findQuantity(List<Product> productsList) {
		double count = 0;
		for (Product p : productsList)
			count = count + p.getQuantity();

		return count;
	}

	// find product by page
	@Override
	public List<Product> getAllProductsByPage(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<>();
		for (Product p : productDao.findAll(pageRequest))
			list.add(p);
		return list;
	}

}
