package com.rafaelrodrigues.cursomc;

import com.rafaelrodrigues.cursomc.domain.Category;
import com.rafaelrodrigues.cursomc.domain.Product;
import com.rafaelrodrigues.cursomc.repositories.CategoryRespository;
import com.rafaelrodrigues.cursomc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRespository categoryRespository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informatic");
		Category cat2 = new Category(null, "Office");
		Product product1 = new Product(null, "Computer", 2000.00);
		Product product2 = new Product(null, "Printer", 800.00);
		Product product3 = new Product(null, "Mouse", 80.00);
		//cat1.setProducts(Arrays.asList(product1, product2, product3));
		//cat2.setProducts(Arrays.asList(product2));
		cat1.addProducts(Arrays.asList(product1, product2, product3));
		cat2.addProduct(product2);

		product1.addCategory(cat1);
		product2.addCategories(Arrays.asList(cat1, cat2));
		product3.addCategory(cat1);

		categoryRespository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
	}
}
