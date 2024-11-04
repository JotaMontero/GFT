package com.inditex.technical_test.infrastructure.mappers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.technical_test.application.controller.PriceResponseDTO;
import com.inditex.technical_test.domain.price.Price;


public class PriceToResponseDto {

    public List<PriceResponseDTO> mapToDto(Optional<List<Price>> priceList) {
        return priceList.map(list ->
                list.stream().map(price ->
                PriceResponseDTO.builder()
                                .brandId(price.getBrandId().getId())
                                .productId(price.getProductId().getId())
                                .priceList(price.getPriceListId())
                                .startDate(price.getDatePeriod().getStart())
                                .endDate(price.getDatePeriod().getEnd())
                                .priority(price.getPriority())
                                .price(price.getPrice())
                                .currency(price.getCurrency())
                                .build()).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
