package com.inditex.technical_test.infrastructure.database.repository.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.ports.out.PriceRepositoryPort;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.ProductId;
import com.inditex.technical_test.infrastructure.database.model.Brand;
import com.inditex.technical_test.infrastructure.database.model.DbPrice;
import com.inditex.technical_test.infrastructure.database.model.Product;
import com.inditex.technical_test.infrastructure.database.repository.PriceRepository;
import com.inditex.technical_test.infrastructure.mappers.JpaPriceToPrice;

@Repository
public class PriceRepositoryImpl implements PriceRepositoryPort {

	   	private final PriceRepository priceRepository;
	    private final JpaPriceToPrice priceMapper;

	    public PriceRepositoryImpl(PriceRepository priceRepository, JpaPriceToPrice priceMapper) {
	        this.priceRepository = priceRepository;
	        this.priceMapper = priceMapper;
	    }

	    @Override
	    public Optional<List<Price>> search(BrandId brandId, ProductId productId, LocalDateTime searchDate) {
	        Optional<List<DbPrice>> dbPrices = priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(new Brand(brandId), new Product(productId), searchDate, searchDate);
	        		
	        return priceMapper.mapJpaPrice(dbPrices);
	    }
	    
	    
	    
	}
