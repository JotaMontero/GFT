package com.inditex.technical_test.domain.brand;

import java.util.NoSuchElementException;

public class BrandNotFoundException extends NoSuchElementException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}
