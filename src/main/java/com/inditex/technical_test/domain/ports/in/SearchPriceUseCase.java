package com.inditex.technical_test.domain.ports.in;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.ports.out.PriceRepositoryPort;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.ProductId;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchPriceUseCase {

	private final PriceRepositoryPort priceRepository;

	public Optional<List<Price>> search(BrandId brandId, ProductId productId, LocalDateTime searchDate) {
		return priceRepository.search(brandId, productId, searchDate);
	}

}
