package com.inditex.technical_test.infrastructure.database.persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.ports.in.FindBrandUseCase;
import com.inditex.technical_test.domain.ports.out.PriceRepositoryPort;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.Product;
import com.inditex.technical_test.domain.product.ProductId;
import com.inditex.technical_test.infrastructure.mappers.JpaBrandToBrand;
import com.inditex.technical_test.infrastructure.mappers.JpaPriceToPrice;
import com.inditex.technical_test.infrastructure.mappers.JpaProductToProduct;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@Primary
public class PriceInMemoryRepository implements PriceRepositoryPort {

	private com.inditex.technical_test.infrastructure.database.repository.PriceRepository priceRepository;

	private FindBrandUseCase brandFinder;
	private JpaBrandToBrand brandMappper;

	private com.inditex.technical_test.domain.ports.in.FindProductUseCase productFinder;
	private JpaProductToProduct productMapper;

	private JpaPriceToPrice priceMapper;

	@Override
	public Optional<List<Price>> search(BrandId brandId, ProductId productId, LocalDateTime searchDate) {

		Brand brand = brandFinder.findById(brandId);
		Product product = productFinder.findById(productId);

		com.inditex.technical_test.infrastructure.database.model.Brand jpaBrand = brandMappper.mapBrand(brand);
		com.inditex.technical_test.infrastructure.database.model.Product jpaProduct = productMapper.mapProduct(product);

		return priceMapper.mapJpaPrice(
				priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(jpaBrand,
						jpaProduct, searchDate, searchDate));

	}

}
