package com.inditex.technical_test.infrastructure.database.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.ports.out.BrandRepositoryPort;
import com.inditex.technical_test.infrastructure.database.repository.BrandRepository;
import com.inditex.technical_test.infrastructure.mappers.JpaBrandToBrand;

@Repository
public class BrandRepositoryImpl implements BrandRepositoryPort {

    private final BrandRepository brandRepository;
    private final JpaBrandToBrand brandMapper;

    public BrandRepositoryImpl(BrandRepository brandRepository, JpaBrandToBrand brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public Optional<Brand> findById(BrandId brandId) {
        return brandMapper.mapJPABrand(brandRepository.findById(brandId.getId()));
    }
}
