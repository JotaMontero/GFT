package com.inditex.technical_test.infrastructure.mappers;

import java.util.Optional;

import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;

public class JpaProductToProduct {
	public Optional<Product> mapJpaProduct(
			Optional<com.inditex.technical_test.infrastructure.database.model.Product> jpaProduct) {
		return jpaProduct.map(product -> new Product(new ProductId(product.getId()), product.getName()));
	}

	public com.inditex.technical_test.infrastructure.database.model.Product mapProduct(Product product) {
		ProductId productId = product.getId();

		return new com.inditex.technical_test.infrastructure.database.model.Product(productId.getId(), product.getName());
	}
}
