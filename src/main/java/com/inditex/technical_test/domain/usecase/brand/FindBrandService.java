package com.inditex.technical_test.domain.usecase.brand;

import org.springframework.stereotype.Service;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.brand.BrandNotFoundException;
import com.inditex.technical_test.domain.ports.in.FindBrandUseCase;
import com.inditex.technical_test.domain.ports.out.BrandRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindBrandService implements FindBrandUseCase {
	
	private final BrandRepositoryPort brandRepository;

	public Brand findById(BrandId brandId) {
		return brandRepository.findById(brandId)
				.orElseThrow(() -> new BrandNotFoundException("Error - Brand with ID: " + brandId.getId() + " not found."));
	}

}
