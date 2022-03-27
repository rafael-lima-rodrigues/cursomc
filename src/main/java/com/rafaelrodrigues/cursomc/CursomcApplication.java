package com.rafaelrodrigues.cursomc;

import com.rafaelrodrigues.cursomc.domain.*;
import com.rafaelrodrigues.cursomc.domain.enums.CustomerType;
import com.rafaelrodrigues.cursomc.domain.enums.PaymentStatus;
import com.rafaelrodrigues.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var cat1 = new Category(null, "Informatic");
		var cat2 = new Category(null, "Office");
		var product1 = new Product(null, "Computer", 2000.00);
		var product2 = new Product(null, "Printer", 800.00);
		var product3 = new Product(null, "Mouse", 80.00);
		cat1.addProducts(Arrays.asList(product1, product2, product3));
		cat2.addProduct(product2);

		product1.addCategory(cat1);
		product2.addCategories(Arrays.asList(cat1, cat2));
		product3.addCategory(cat1);

		var state1 = new State(null, "Minas Gerais");
		var state2 = new State(null, "São Paulo");

		var city1 = new City(null, "Uberlandia", state1);
		var city2 = new City(null, "São Paulo", state2);
		var city3 = new City(null, "Campinas", state2);

		state1.addCity(city1);
		state2.addCities(Arrays.asList(city2, city3));

		var customer1 = new Customer(null, "Maria Silva", "maria@gmail.com", "36378912377", CustomerType.PESSOA_FISICA);
		customer1.addAllPhones(Arrays.asList("27363323", "93838393"));
		var address1 = new Address(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", customer1, city1);
		var address2 = new Address(null, "Avenida Matos", "105", "Apto 45", "Centro", "38220820", customer1, city2);
		customer1.addAllAddresses(Arrays.asList(address1, address2));


		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		customerRepository.save(customer1);
		addressRepository.saveAll(Arrays.asList(address1, address2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		var order1 = new Demand(null, sdf.parse("30/09/2017 10:32"), customer1, address1);
		var order2 = new Demand(null, sdf.parse("10/10/2017 10:32"), customer1, address2);

		var payment1 = new CardPayment(null, PaymentStatus.PAID, order1, 6);
		order1.setPayment(payment1);
		var payment2 = new PaymentSlip(null, PaymentStatus.PENDING, order2, sdf.parse("20/10/2017 00:00"), null);
		order2.setPayment(payment2);

		customer1.addOrders(Arrays.asList(order1, order2));
		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
	}
}
