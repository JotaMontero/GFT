package com.inditex.technical_test.application.price;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.dateperiod.DatePeriod;
import com.inditex.technical_test.domain.ports.in.SearchPriceUseCase;
import com.inditex.technical_test.domain.ports.out.PriceRepositoryPort;
import com.inditex.technical_test.domain.price.Price;
import com.inditex.technical_test.domain.product.ProductId;


@ExtendWith(MockitoExtension.class)
public class SearchTest {
    @Mock
    private PriceRepositoryPort priceRepository;

    @InjectMocks
    private SearchPriceUseCase search;

    @Test
    void OK_expectedPriceList_whenPriceExist() {
    	Price price = new Price(new BrandId(1), new ProductId(1), new DatePeriod(LocalDateTime.now(), LocalDateTime.now().plusYears(1)), 1, 0, 0, "EUR");
    	List<Price> priceList = new ArrayList<>();
    	priceList.add(price);
    	when(priceRepository.search(any(BrandId.class), any(ProductId.class), any(LocalDateTime.class))).thenReturn(Optional.of(priceList));
    	
    	Optional<List<Price>> actualPriceList =  search.search(new BrandId(1), new ProductId(1), LocalDateTime.now());
    	
    	assertEquals(Optional.of(priceList), actualPriceList);
    }
    
    @Test
    void OK_expectedEmptyList_whenPriceNotExists() {
        when(priceRepository.search(any(BrandId.class), any(ProductId.class), any(LocalDateTime.class))).thenReturn(Optional.empty());

        Optional<List<Price>> listPrice = search.search(new BrandId(1), new ProductId(1), LocalDateTime.now());

        assertEquals(Optional.empty(), listPrice);
    }
    
    @Test
    void OK_expectedPriceList_whenMultiplePricesExist() {
        Price price1 = new Price(new BrandId(1), new ProductId(1), new DatePeriod(LocalDateTime.now(), LocalDateTime.now().plusYears(1)), 1, 0, 0, "EUR");
        Price price2 = new Price(new BrandId(1), new ProductId(1), new DatePeriod(LocalDateTime.now(), LocalDateTime.now().plusYears(1)), 2, 0, 0, "EUR");
        
        List<Price> priceList = Arrays.asList(price1, price2);
        when(priceRepository.search(any(BrandId.class), any(ProductId.class), any(LocalDateTime.class))).thenReturn(Optional.of(priceList));
        
        Optional<List<Price>> actualPriceList = search.search(new BrandId(1), new ProductId(1), LocalDateTime.now());

        assertEquals(Optional.of(priceList), actualPriceList);
    }
       

}
