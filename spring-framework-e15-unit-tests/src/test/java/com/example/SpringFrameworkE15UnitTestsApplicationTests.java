package com.example;

import com.example.repositories.ProductRepository;
import com.example.services.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class SpringFrameworkE15UnitTestsApplicationTests {

	@MockBean
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@BeforeEach  // before each test
	void setUp(){
		System.out.println(":)");
	}

	@BeforeAll    //before all test, once.  @BeforeAll and @AfterAll should be static
	void beforeAll(){
		System.out.println(": |");
	}

	@Test
	void noProductReturnedTest() {
		//given
		given(productRepository.getProductNames())
				.willReturn(Collections.emptyList());

		//when
		List<String> res = productService.getProductEvenNames();

		//then
		assertTrue(res.isEmpty());
	}

	@Test
	void productFoundTest(){
		//given
		List<String> input = List.of("aa", "bbbb", "ccc");
		given(productRepository.getProductNames())
				.willReturn(input);

		//when
		List<String> res = productService.getProductEvenNames();

		//then
		assertEquals(2, res.size());
	}

}
