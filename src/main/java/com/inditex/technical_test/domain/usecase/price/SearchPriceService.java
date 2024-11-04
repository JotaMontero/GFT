package com.inditex.technical_test.domain.usecase.price;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.ProductId;

public interface SearchPriceService {
    Optional<List<Price>> search(BrandId brandId, ProductId productId, LocalDateTime searchDate);
}
