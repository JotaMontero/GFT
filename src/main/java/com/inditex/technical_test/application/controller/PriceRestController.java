package com.inditex.technical_test.application.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.brand.BrandNotFoundException;
import com.inditex.technical_test.domain.ports.in.SearchPriceUseCase;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.ProductId;
import com.inditex.technical_test.domain.product.ProductNotFoundException;
import com.inditex.technical_test.infrastructure.mappers.PriceToResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v0")
@RequiredArgsConstructor
public class PriceRestController {

	private final SearchPriceUseCase priceSearchService;

	private final PriceToResponseDto responseMapper;

	@GetMapping("/brands/{brandId}/products/{productId}/prices")
	public ResponseEntity<PriceResponseDTO> getPrice(
			@PathVariable("brandId") Integer brandId,
			@PathVariable("productId") Integer productId, 
			@RequestParam("searchDate") String dateString) {

		Optional<List<Price>> priceList;
		LocalDateTime searchDate;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");
		try {
			searchDate = LocalDateTime.parse(dateString, formatter);
		} catch (DateTimeParseException exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		try {
			priceList = priceSearchService.search(new BrandId(brandId), new ProductId(productId), searchDate);
		} catch (ProductNotFoundException | BrandNotFoundException exc) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
        List<PriceResponseDTO> responseDtoList = responseMapper.mapToDto(priceList);

        if (!responseDtoList.isEmpty()) {
        	PriceResponseDTO priorityPrice = responseDtoList.stream()
                    .sorted(Comparator.comparingInt(PriceResponseDTO::getPriority).reversed())
                    .findFirst()
                    .orElse(null);
            return new ResponseEntity<>(priorityPrice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	}

}
