package com.inditex.technical_test.domain.dateperiod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DatePeriodTest {
	
	@Test
	void KO_expectedException_whenStartDateIsAfterEndDate() {
		LocalDateTime startDate = LocalDateTime.now();
		LocalDateTime endDate = LocalDateTime.now().minusYears(1);
		
		DatePeriodException exception = assertThrowsExactly(DatePeriodException.class, () -> new DatePeriod(startDate, endDate));
		
		assertEquals("Error - Start date is after the end date. ", exception.getMessage());
		
	}
	
	@Test
	void OK_shouldCreateDatePeriod_whenStartDateIsBeforeEndDate() {
	    LocalDateTime startDate = LocalDateTime.now().minusMonths(1);
	    LocalDateTime endDate = LocalDateTime.now();

	    DatePeriod datePeriod = new DatePeriod(startDate, endDate);

	    assertEquals(startDate, datePeriod.getStart());
	    assertEquals(endDate, datePeriod.getEnd());
	}
	

}
