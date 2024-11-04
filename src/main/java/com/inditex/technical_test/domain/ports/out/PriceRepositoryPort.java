package com.inditex.technical_test.domain.ports.out;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.ProductId;

@Service
public interface PriceRepositoryPort {

	Optional<List<Price>> search(BrandId brandId, ProductId productId, LocalDateTime searchDate);

}