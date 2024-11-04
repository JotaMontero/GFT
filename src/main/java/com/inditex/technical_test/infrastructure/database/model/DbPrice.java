package com.inditex.technical_test.infrastructure.database.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICES")
@IdClass(PricePrimaryKey.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DbPrice {
	
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private Brand brandId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product productId;

    @Id
    @Column(name="START_DATE")
    private LocalDateTime startDate;

    @Id
    @Column(name="END_DATE")
    private LocalDateTime endDate;

    @Column(name="PRICE_LIST")
    private Integer priceList;

    @Id
    @Column(name="PRIORITY")
    private Integer priority;

    @Column(name="PRICE")
    private Double price;

    @Column(name="CURRENCY")
    private String currency;

}
