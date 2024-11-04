package com.inditex.technical_test.domain.brand;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Brand {
    private final BrandId id;
    private final String name;
}
