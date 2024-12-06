package com.codihngshuttle.jpaLesson.jpaLessons;

import com.codihngshuttle.jpaLesson.jpaLessons.entities.ProductEntity;
import com.codihngshuttle.jpaLesson.jpaLessons.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaLessonsApplicationTests {
	@Test
	void contextLoads() {
	}

	@Autowired
	ProductRepository productRepository;
	@Test
	void TestRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		ProductEntity savedProductEntity =  productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2024, 1, 1, 0, 0, 0)
//		);

//		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(3, BigDecimal.valueOf(16.4));
//		System.out.println(entities);

//		List<ProductEntity> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(1, BigDecimal.valueOf(130.4));
//		System.out.println(entities);

		List<ProductEntity> entities = productRepository.findByTitleContainingIgnoreCase("CHOco");
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> productEntity = productRepository
				.findByTitleAndPrice("Pepsi", BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}
}
