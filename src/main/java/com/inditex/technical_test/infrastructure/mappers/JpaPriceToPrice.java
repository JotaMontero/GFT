package com.inditex.technical_test.infrastructure.mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.dateperiod.DatePeriod;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.ProductId;

public class JpaPriceToPrice {
	
	public Optional<List<Price>> mapJpaPrice(Optional<List<com.inditex.technical_test.infrastructure.database.model.DbPrice>> jpaPrice) {
		return jpaPrice.map(list -> list.stream().map(price -> new Price(
				new BrandId(price.getBrandId().getId()),
				new ProductId(price.getProductId().getId()),
				new DatePeriod(price.getStartDate(), price.getEndDate()),
				price.getPriority(), 
				price.getPriceList(), 
				price.getPrice(),
				price.getCurrency()
		)).collect(Collectors.toList()));
	}
}
