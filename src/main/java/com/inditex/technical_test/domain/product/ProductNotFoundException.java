package com.inditex.technical_test.domain.product;

import java.util.NoSuchElementException;

public class ProductNotFoundException extends NoSuchElementException {

	public ProductNotFoundException(String message) {
		super(message);

	}
}
