package com.inditex.technical_test.infrastructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.technical_test.application.controller.PriceRestController;


@SpringBootTest
@AutoConfigureTestDatabase
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PriceRestControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private PriceRestController priceRestController;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(priceRestController).build();
	}
	
    @Test
    void expectedNotFound_whenBrandNotExists() throws Exception {
        mockMvc.perform(get("/api/v0/brands/99999/products/35455/prices?searchDate=2020-06-1410:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    
    @Test
    void expectedNotFound_whenProductNotExists() throws Exception {
        mockMvc.perform(get("/api/v0/brands/1/products/99999/prices?searchDate=2020-06-1410:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    
    @Test
    void expectedBadRequest_whenDateIsInvalid() throws Exception {
        mockMvc.perform(get("/api/v0/brands/1/products/35455/prices?searchDate=2020/06/14 10:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void expectedOk_whenValidRequest() throws Exception {
        mockMvc.perform(get("/api/v0/brands/1/products/35455/prices?searchDate=2020-06-1418:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
