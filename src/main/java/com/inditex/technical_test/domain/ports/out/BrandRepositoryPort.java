package com.inditex.technical_test.domain.ports.out;

import java.util.Optional;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;

public interface BrandRepositoryPort {
	
	Optional<Brand> findById(BrandId brandId);	

}
