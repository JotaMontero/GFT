package com.inditex.technical_test.infrastructure.mappers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;

public class JpaBrandToBrand {

	public Optional<Brand> mapJPABrand(Optional<com.inditex.technical_test.infrastructure.database.model.Brand> jpaBrand) {
		return jpaBrand.map(brand -> new Brand(new BrandId(brand.getId()), brand.getName()));
	}

	public com.inditex.technical_test.infrastructure.database.model.Brand mapBrand(Brand brand) {
		BrandId brandId = brand.getId();

		return new com.inditex.technical_test.infrastructure.database.model.Brand(brandId.getId(), brand.getName());
	}

}
