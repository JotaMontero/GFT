package com.inditex.technical_test.infrastructure.database.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inditex.technical_test.domain.ports.out.ProductRepositoryPort;
import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;
import com.inditex.technical_test.infrastructure.mappers.JpaProductToProduct;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductInMemoryRepository implements ProductRepositoryPort {

	private com.inditex.technical_test.infrastructure.database.repository.ProductRepository jpaRepository;

	private JpaProductToProduct productMappper;

	@Override
	public Optional<Product> findById(ProductId productId) {
		Optional<com.inditex.technical_test.infrastructure.database.model.Product> jpaProduct = jpaRepository
				.findById(productId.getId());

		return productMappper.mapJpaProduct(jpaProduct);
	}

}
