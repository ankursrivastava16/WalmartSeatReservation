package com.walmart.seatreservation.model;

public class Seat {
	
	private final Integer row;
	private final Integer column;

	public Seat(Integer row, Integer column) {
		super();
		this.row = row;
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}	
}
