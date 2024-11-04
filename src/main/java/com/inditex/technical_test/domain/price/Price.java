package com.inditex.technical_test.domain.price;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.dateperiod.DatePeriod;
import com.inditex.technical_test.domain.product.ProductId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private BrandId brandId;        
    private ProductId productId;    
    private DatePeriod datePeriod;
    private int priceListId;
    private int priority;
    private double price;
    private String currency;

}
