package com.walmart.seatreservation.model;

import java.util.Collection;

public class Arena {
	
	private final Integer totalSeats;
	private final Collection<Seat> seats;
	
	public Arena(Integer totalSeats, Collection<Seat> seats) {
		super();
		this.totalSeats = totalSeats;
		this.seats = seats;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public Collection<Seat> getSeats() {
		return seats;
	}
	
}
