package com.inditex.technical_test.infrastructure.database.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.inditex.technical_test.domain.ports.out.ProductRepositoryPort;
import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;
import com.inditex.technical_test.infrastructure.database.repository.ProductRepository;
import com.inditex.technical_test.infrastructure.mappers.JpaProductToProduct;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort {

    private final ProductRepository productRepository;
    private final JpaProductToProduct productMapper;

    public ProductRepositoryImpl(ProductRepository productRepository, JpaProductToProduct productMapper) {    	
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return productMapper.mapJpaProduct(productRepository.findById(productId.getId()));
    }
}
