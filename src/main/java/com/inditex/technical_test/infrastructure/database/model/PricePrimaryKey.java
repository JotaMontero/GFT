package com.inditex.technical_test.infrastructure.database.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class PricePrimaryKey implements Serializable {

	private static final long serialVersionUID = 7312588992257658983L;

	private Integer brandId;

    private Integer productId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private Integer priority;

}
