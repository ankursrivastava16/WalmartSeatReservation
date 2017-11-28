package com.walmart.seatreservation.model;

public class ReservedSeat extends Seat {
	
	private final String customerEmail;

	public ReservedSeat(Integer row, Integer column, String customerEmail) {
		super(row, column);
		this.customerEmail = customerEmail;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	
}
