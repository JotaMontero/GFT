package com.inditex.technical_test.domain.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Product {
    private final ProductId id;
    private final String name;
}
