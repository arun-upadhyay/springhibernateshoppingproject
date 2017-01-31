package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.domain.Product;
import com.shop.service.ProductServiceImpl;

@Controller
public class ProductController {
	@Autowired
	ProductServiceImpl productServiceImpl;

	// Home page of the shopping site
	@RequestMapping("/")
	public String welcomeProduct() {
		return "redirect:view-all-products";
		// return "welcome";
	}

	@RequestMapping("/add-product")
	public String addProduct(Product product) {
		return "addProduct";
	}

	// saving new product
	@RequestMapping("/save-product")
	public String saveProduct(@Valid Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addProduct";
		}
		productServiceImpl.saveProduct(product);

		return "redirect:view-all-products";
	}

	// update existing product
	@RequestMapping("/update-product-info")
	public String updateProduct(@Valid Product product, HttpSession session, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "update-product";
		}
		Product p = (Product) session.getAttribute("productObject");
		p.setProductName(product.getProductName());
		p.setCategory(product.getCategory());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setQuantity(product.getQuantity());
		/*
		 * remove from shopping cart of product of that productid is deleted
		 * from database
		 */
		List<Product> listProduct = (List<Product>) session.getAttribute("addToCart");
		if (listProduct != null) {
			session.setAttribute("addToCart", productServiceImpl.filterSessionData(listProduct, p.getProductId() + ""));
		}
		productServiceImpl.saveProduct(p);
		return "redirect:view-all-products";
	}

	// Delete product based on product id
	@RequestMapping(value = "/delete-product/{productid}")
	public String deleteProduct(@PathVariable("productid") String productid, HttpSession session, Model model) {
		// delete product
		productServiceImpl.deleteProduct(productid);
		List<Product> listProduct = (List<Product>) session.getAttribute("addToCart");
		/*
		 * remove from shopping cart of product of that productid is deleted
		 * from database
		 */
		if (listProduct != null) {
			session.setAttribute("addToCart", productServiceImpl.filterSessionData(listProduct, productid));
		}
		model.addAttribute("pList", productServiceImpl.findAllProduct());
		return "search-content";

	}

	// update product based on product id
	@RequestMapping(value = "/update-product/{productid}")
	public String editProduct(@PathVariable("productid") String productId, HttpSession session, Product product) {
		session.setAttribute("productObject", productServiceImpl.getProductByProductId(productId));
		return "update-product";

	}
	// add to cart

	@RequestMapping(value = "/add-to-cart/{productid}")
	public String addToCart(@PathVariable("productid") String productId, HttpSession session, Model model) {

		List<Product> productsList = (List<Product>) session.getAttribute("addToCart");
		if (productsList == null) {
			productsList = new ArrayList<>();
			session.setAttribute("addToCart", productServiceImpl.addToCart(productsList, productId));
		} else {
			List<Product> pList = productServiceImpl.addToCart(productsList, productId);
			session.setAttribute("cartitems", productServiceImpl.findQuantity(pList));
			session.setAttribute("addToCart", pList);
		}

		model.addAttribute("pList", productServiceImpl.findAllProduct());
		return "search-content";

	}

	// View all products information
	@RequestMapping("/view-all-products")

	public ModelAndView viewProducts(Product product) {
		List<Product> productList = productServiceImpl.findAllProduct();
		return new ModelAndView("view-all-products", "pList", productList);

	}

	@RequestMapping(value = "view-all-products/{pageno}", method = RequestMethod.GET)

	public String viewProductsbyPage(@PathVariable("pageno") int pageno, Model model, HttpSession session) {
		List<Product> listProduct = productServiceImpl.getAllProductsByPage(new PageRequest(pageno - 1, 3));
		int count = ((List<Product>) productServiceImpl.findAllProductfromDb()).size();
		model.addAttribute("pList", listProduct);
		if (session.getAttribute("pageIndexSize") == null) {
			int pageIndexSize;
			if (count % 3 == 0)
				pageIndexSize = count / 3;
			else
				pageIndexSize = count / 3 + 1;
			session.setAttribute("pageIndexSize", pageIndexSize);
		}

		model.addAttribute("pageno", pageno);
		return "view-all-products";
	}

	// search products(Ajax & Jquery used)
	@RequestMapping(value = "search-products/{pname}", method = RequestMethod.GET)
	public String searchProducts1(@PathVariable("pname") String pname, Model model) {
		model.addAttribute("pList", productServiceImpl.searchProductByProductName(pname));
		return "search-content";
	}

	// checkout information
	@RequestMapping("/checkout-products")
	public String checkOut(HttpSession session, Model model) {
		List<Product> productList = (List<Product>) session.getAttribute("addToCart");
		if (productList == null)
			return "error-page";
		if (productList.size() == 0)
			return "error-page";
		model.addAttribute("pcheckoutList", productList);
		session.setAttribute("total", productServiceImpl.totalCheckout(productList));
		return "checkout-products";
	}

	// checkout information
	@RequestMapping("/cancel-checkout")
	public String cancelCheckout(HttpSession session) {
		session.invalidate();
		return "redirect:/view-all-products";
	}

	@RequestMapping("/remove-from-cart/{productid}")
	public ModelAndView removeFromCart(@PathVariable("productid") String productId, HttpSession session) {
		List<Product> productList = (List<Product>) session.getAttribute("addToCart");
		for (Product prod : productList) {
			if (prod.getProductId() == Integer.parseInt(productId)) {
				productList.remove(prod);
				break;
			}
		}
		session.setAttribute("addToCart", productList);
		session.setAttribute("total", productServiceImpl.totalCheckout(productList));
		return new ModelAndView("checkout-products", "pList", productList);
	}

}
