package com.inditex.technical_test.application.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inditex.technical_test.domain.ports.in.FindProductUseCase;
import com.inditex.technical_test.domain.ports.out.ProductRepositoryPort;
import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;
import com.inditex.technical_test.domain.product.ProductNotFoundException;

@ExtendWith(MockitoExtension.class)
public class FindTest {
	
	@Mock
	private ProductRepositoryPort productRepository;
	
	@InjectMocks
	private FindProductUseCase find;
	
	@Test
	void OK_returnCorrectProduct_whenProductExists() {
		Product product = new Product(new ProductId(1), "Product1");
		when(productRepository.findById(any(ProductId.class))).thenReturn(Optional.of(product));
		
		Product existingProduct = find.findById(new ProductId(1));
		assertEquals(product, existingProduct);
	}
	
	@Test
	void OK_returnCorrectProduct_whenMultipleProductsExist() {
	    Product product1 = new Product(new ProductId(1), "Product1");
	    Product product2 = new Product(new ProductId(2), "Product2");
	    when(productRepository.findById(any(ProductId.class))).thenReturn(Optional.of(product1));

	    Product foundProduct = find.findById(new ProductId(1));
	    	 
	    assertEquals(product1.getId(), foundProduct.getId());
	    assertNotEquals(product2.getId(), foundProduct.getId());
	}
	
	@Test
	void KO_throwProductNotFoundException_whenProductDoesNotExist() {
	    when(productRepository.findById(any(ProductId.class))).thenReturn(Optional.empty());

	    ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
	        find.findById(new ProductId(999));
	    });

	    assertEquals("Error - Product with ID: 999 not found.", exception.getMessage());
	}
}
