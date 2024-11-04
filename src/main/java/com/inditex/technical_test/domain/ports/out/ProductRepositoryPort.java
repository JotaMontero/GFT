package com.inditex.technical_test.domain.ports.out;

import java.util.Optional;

import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;

public interface ProductRepositoryPort {

	Optional<Product> findById(ProductId productId);

}
