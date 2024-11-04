package com.inditex.technical_test.domain.ports.in;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;

public interface FindBrandUseCase {
    Brand findById(BrandId brandId);
}