package com.inditex.technical_test.domain.dateperiod;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class DatePeriod {

	private final LocalDateTime start;
	private final LocalDateTime end;

	public DatePeriod(LocalDateTime start, LocalDateTime end) {
		this.start = start;
		this.end = end;
		validateDatePeriod();
	}

	private void validateDatePeriod() {
		if (start.isAfter(end)) {
			throw new DatePeriodException("Error - Start date is after the end date. ");
		}
	}

}
