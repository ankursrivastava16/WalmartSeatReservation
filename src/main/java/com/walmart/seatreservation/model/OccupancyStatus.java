package com.walmart.seatreservation.model;

public enum OccupancyStatus {

	Available("0"), Held("1"), Reserved("2");

	OccupancyStatus(String status) {
		this.status = status;
	}

	private String status;

	public String status() {
		return status;
	}
}
