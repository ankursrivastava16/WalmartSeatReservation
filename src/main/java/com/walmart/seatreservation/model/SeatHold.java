package com.walmart.seatreservation.model;

import org.springframework.stereotype.Component;

@Component
public class SeatHold {

	private final Integer seatHoldId;

	private final Integer numOfSeats;

	private final long timeStarted;

	private final String customerEmail;

	public SeatHold(Integer seatHoldId, long timeStarted, String customerEmail,
			Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
		this.seatHoldId = seatHoldId;
		this.timeStarted = timeStarted;
		this.customerEmail = customerEmail;
	}

	public Integer getSeatHoldId() {
		return seatHoldId;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public long getTimeStarted() {
		return timeStarted;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
}
