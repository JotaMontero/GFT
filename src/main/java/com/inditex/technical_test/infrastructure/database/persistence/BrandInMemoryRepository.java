package com.inditex.technical_test.infrastructure.database.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.ports.out.BrandRepositoryPort;
import com.inditex.technical_test.infrastructure.mappers.JpaBrandToBrand;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BrandInMemoryRepository implements BrandRepositoryPort {
	
    private com.inditex.technical_test.infrastructure.database.repository.BrandRepository jpaRepository;

    private JpaBrandToBrand brandMapper;
    
    @Override
    public Optional<Brand> findById(BrandId brandId) {
        Optional<com.inditex.technical_test.infrastructure.database.model.Brand> jpaBrand = jpaRepository.findById(brandId.getId());

        return brandMapper.mapJPABrand(jpaBrand);
    }


}
