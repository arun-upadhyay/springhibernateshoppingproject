import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.SpringBootWebApplication;
import com.shop.domain.Product;
import com.shop.service.ProductServiceImpl;

@SuppressWarnings("deprecation")@RunWith(SpringJUnit4ClassRunner.class)

@Transactional
public class ProductServiceImplTestCases {
	@Autowired
	ProductServiceImpl productServiceImpl;

	@Test
	public void productTestQuantity() {

		assertNotEquals(-1, productServiceImpl.findAllProduct());
	}

	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<>();
		Product p = new Product();
		p.setProductName("pendrive");
		p.setCategory("Electronic");
		p.setDescription("Good quality");
		p.setPrice(20);
		p.setQuantity(10);
		productList.add(p);
		Product p2 = new Product();
		p2.setProductName("Pencil");
		p2.setCategory("Stationary");
		p2.setDescription("Good quality");
		p2.setPrice(10);
		p2.setQuantity(5);
		productList.add(p2);
		return productList;
	}
}
