package dev.harshit.productcatalog;

import dev.harshit.productcatalog.inheritancedemo.tableperclass.Mentor;
import dev.harshit.productcatalog.inheritancedemo.tableperclass.MentorRepository;
import dev.harshit.productcatalog.inheritancedemo.tableperclass.User;
import dev.harshit.productcatalog.inheritancedemo.tableperclass.UserRepository;
import dev.harshit.productcatalog.models.Category;
import dev.harshit.productcatalog.models.Order;
import dev.harshit.productcatalog.models.Price;
import dev.harshit.productcatalog.models.Product;
import dev.harshit.productcatalog.repositories.CategoryRepository;
import dev.harshit.productcatalog.repositories.OrderRepository;
import dev.harshit.productcatalog.repositories.PriceRepository;
import dev.harshit.productcatalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ProductcatalogApplication { //implements CommandLineRunner {

//	private MentorRepository mentorRepository;
//	private UserRepository userRepository;
//
//	private CategoryRepository categoryRepository;
//	private ProductRepository productRepository;
//	private OrderRepository orderRepository;
//	private PriceRepository priceRepository;
//
//	public ProductcatalogApplication(@Qualifier("tpc_mentor") MentorRepository mentorRepository,
//									 @Qualifier("tpc_user") UserRepository userRepository,
//									 ProductRepository productRepository, CategoryRepository categoryRepository,
//									 OrderRepository orderRepository, PriceRepository priceRepository) {
//		this.mentorRepository = mentorRepository;
//		this.userRepository = userRepository;
//		this.productRepository = productRepository;
//		this.categoryRepository = categoryRepository;
//		this.orderRepository = orderRepository;
//		this.priceRepository = priceRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Harshit");
//		mentor.setEmail("harshit@gmail.com");
//		mentor.setAverageRating(4.9);
//		mentorRepository.save(mentor);
//
//		User user = new User();
//		user.setName("Karan");
//		user.setEmail("karan@gmail.com");
//		userRepository.save(user);
//
//		List<User> users = userRepository.findAll();
//		for(User u : users) {
//			System.out.println(u);
//		}

//		Category category = new Category();
//		category.setName("IPhone Devices");
////		Category category1 = categoryRepository.save(category);
//
//
//		Price price = new Price();
//		price.setCurrency("Rs");
//		price.setAmount(22.1);
////		Price price1 = priceRepository.save(price);
//
//		Product product = new Product();
//		product.setTitle("IPhone 16");
//		product.setDescription("Best Iphone ever");
//		product.setPrice(price);
//		product.setCategory(category);
//		productRepository.save(product);

//		List<Product> products = new ArrayList<>();
//		products.add(product);
//		Order order = new Order();
//		order.setProducts(products);
//		orderRepository.save(order);

//		productRepository.deleteById(UUID.fromString("0xD76AD7C94BAC42BF9BB4A91378AA7E4E"));

//		List<Category> categories = categoryRepository.findAll();

//	}
}
