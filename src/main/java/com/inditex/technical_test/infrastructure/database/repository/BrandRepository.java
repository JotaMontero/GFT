package com.inditex.technical_test.infrastructure.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.technical_test.infrastructure.database.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	Optional<Brand> findById(Integer brandId);

}
