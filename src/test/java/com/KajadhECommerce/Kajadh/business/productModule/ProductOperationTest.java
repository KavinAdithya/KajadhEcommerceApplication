package com.KajadhECommerce.Kajadh.business.productModule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;

import com.KajadhECommerce.Kajadh.Entities.Product;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductOperationTest {

	private ApplicationContext context = Contex.getContext();
	private ProductOperation productOperation = context.getBean(ProductOperation.class);
	private List<Product> products = new ArrayList<>();
	
	@BeforeAll
	public void loadProducts() {
		Product p1 = new Product();
		p1.setId(2);
		p1.setBrandName("MegaBook");
		p1.setName("123");
		p1.setPrice(23322);
		p1.setQuantity(2);
		
		Map<String, String> spec1 = new HashMap<>();
		spec1.put("Display", "Full HD");
		spec1.put("pizels", "4k");
		p1.setSpecification(spec1);
		
		
		Product p2 = new Product();
		p2.setId(5);
		p2.setBrandName("MegaBk");
		p2.setName("1");
		p2.setPrice(23322);
		p2.setQuantity(2);
		
		Map<String, String> spec2 = new HashMap<>();
		spec2.put("Display", "Full HD");
		spec2.put("pizels", "8k");
		spec2.put("kavin", "19");
		p2.setSpecification(spec2);
		
		Product p3 = new Product();
		p3.setId(6);
		p3.setBrandName("dell");
		p3.setName("KeyBoard");
		p3.setPrice(549.00);
		p3.setQuantity(1);
		
		Map<String, String> spec3 = new HashMap<>();
		spec3.put("Buttons", "1001");
		spec3.put("Speed", "4WB");
		spec3.put("New Spec Addeed", "1");
		p3.setSpecification(spec3);
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
	}

	@Test
	@Order(4)
	void testProduct() {
		assertEquals(products, productOperation.getProducts());
		System.out.println("Products Test");
	}
	
	
	@Test
	@Order(1)
	void addProductTest() {
		Product p1 = new Product();
//		p1.setId(2);
		p1.setBrandName("dell");
		p1.setName("KeyBoard");
		p1.setPrice(549.00);
		p1.setQuantity(0);
		
		Map<String, String> spec1 = new HashMap<>();
//		spec1.put("Buttons", "1000");
//		spec1.put("Speed", "4W");
		p1.setSpecification(spec1);
		
		assertFalse(productOperation.addProduct(p1));
		
		System.out.println("Add Products Test");
	}
	
	@Test
	@Order(2)
	void deleteProductTest() {
		Product p2 = new Product();
		p2.setId(5);
		p2.setBrandName("MegaBk");
		p2.setName("1");
		p2.setPrice(23322);
		p2.setQuantity(2);
		
		Map<String, String> spec2 = new HashMap<>();
		spec2.put("Display", "Full HD");
		spec2.put("pizels", "8k");
		spec2.put("kavin", "19");
		p2.setSpecification(spec2);
		
		assertFalse(productOperation.deleteProduct("MegaB1", "1"));
		
		products.remove(p2);
		
		System.out.println("Delete Products Test");
//		assertEquals(products, productOperation.getProducts());
	}
	
	@Order(3)
	@Test
	void updateProductTest() {
		Map<String, String> spec3 = new HashMap<>();
		spec3.put("Buttons", "1001");
		spec3.put("Speed", "4WB");
		spec3.put("New Spec Addeed", "1");
		
		assertTrue(productOperation.updateProduct("dell", "keyboard", spec3));
	}
}
