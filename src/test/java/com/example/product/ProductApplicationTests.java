package com.example.product;

import com.example.product.exceptions.InvalidProductIdException;
import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;
import com.example.product.repositories.ProductWithIdNamePrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest // This is to intialise the application context
class ProductApplicationTests {
   @Autowired
   ProductRepository productRepository;


	@Test// This marks the method as a test method and it also makes it executable
	void contextLoads() {
	}

	@Test
	public void getSomething()  {
		Product p = productRepository.something(1L);
		System.out.println(p.getName() + " " + p.getDescription());
	}

	@Test
	public void getSomethingSpecific(){
		ProductWithIdNamePrice p = productRepository.somethingSpecific(2L);
		System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
	}

	@Test
	public void getSomethingSpecificMySql(){
		Product p = productRepository.somethingMySqlQuery(1L);
		System.out.println(p.getName() + " " + p.getPrice());
	}

	@Test
	public void getSomethingSpecificMySqltwo(){
		ProductWithIdNamePrice p = productRepository.somethingMySqlQuerySpec(2L);
		System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
	}

}
