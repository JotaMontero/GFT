package com.inditex.technical_test.application.brand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inditex.technical_test.domain.brand.Brand;
import com.inditex.technical_test.domain.brand.BrandId;
import com.inditex.technical_test.domain.brand.BrandNotFoundException;
import com.inditex.technical_test.domain.ports.in.FindBrandUseCase;
import com.inditex.technical_test.domain.ports.out.BrandRepositoryPort;

@ExtendWith(MockitoExtension.class)
public class FindTest {
	
	@Mock
	private BrandRepositoryPort brandRepository;
	
	@InjectMocks
	private FindBrandUseCase find;
	
	@Test
	void OK_returnCorrectBrand_whenBrandExists() {
		Brand brand = new Brand(new BrandId(1), "Brand1");
		when(brandRepository.findById(any(BrandId.class))).thenReturn(Optional.of(brand));
		
		Brand existingBrand = find.findById(new BrandId(1));
		assertEquals(brand, existingBrand);
	}
	
	@Test
	void OK_returnCorrectBrand_whenMultipleBrandsExist() {
	    Brand brand1 = new Brand(new BrandId(1), "Brand1");
	    Brand brand2 = new Brand(new BrandId(2), "Brand2");
	    when(brandRepository.findById(any(BrandId.class))).thenReturn(Optional.of(brand1));

	    Brand foundBrand = find.findById(new BrandId(1));
	    	 
	    assertEquals(brand1.getId(), foundBrand.getId());
	    assertNotEquals(brand2.getId(), foundBrand.getId());
	}
	
	@Test
	void KO_throwBrandNotFoundException_whenBrandDoesNotExist() {
	    when(brandRepository.findById(any(BrandId.class))).thenReturn(Optional.empty());

	    BrandNotFoundException exception = assertThrows(BrandNotFoundException.class, () -> {
	        find.findById(new BrandId(999));
	    });

	    assertEquals("Error - Brand with ID: 999 not found.", exception.getMessage());
	}

}
