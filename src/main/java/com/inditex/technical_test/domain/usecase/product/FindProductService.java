package com.inditex.technical_test.domain.usecase.product;

import org.springframework.stereotype.Service;

import com.inditex.technical_test.domain.ports.in.FindProductUseCase;
import com.inditex.technical_test.domain.ports.out.ProductRepositoryPort;
import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;
import com.inditex.technical_test.domain.product.ProductNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindProductService implements FindProductUseCase {
	
	private final ProductRepositoryPort productRepository;

    public Product findById(ProductId productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Error - Product with ID: " + productId.getId() + " not found."));
    }

}
