package com.inditex.technical_test.domain.ports.in;

import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;

public interface FindProductUseCase {
	Product findById(ProductId productId);
}
