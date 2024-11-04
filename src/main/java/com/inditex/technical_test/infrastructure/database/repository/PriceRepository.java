package com.inditex.technical_test.infrastructure.database.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.technical_test.infrastructure.database.model.Brand;
import com.inditex.technical_test.infrastructure.database.model.DbPrice;
import com.inditex.technical_test.infrastructure.database.model.PricePrimaryKey;
import com.inditex.technical_test.infrastructure.database.model.Product;

public interface PriceRepository extends JpaRepository<DbPrice, PricePrimaryKey> {
	Optional<List<DbPrice>> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Brand brand,
			Product productId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
