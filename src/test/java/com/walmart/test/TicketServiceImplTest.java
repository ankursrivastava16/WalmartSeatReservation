package com.walmart.test;


import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.walmart.seatreservation.model.SeatHold;


public class TicketServiceImplTest {
	
	@Test
	public void findAndHoldSeats() {
		// TODO Auto-generated method stub
		int seatHoldId =1;
		int numSeats =5;
		String customerEmail = "xyz@xyz.com";
		SeatHold seatHold = new SeatHold(seatHoldId,
				System.currentTimeMillis(), customerEmail, numSeats);
	   Assert.assertEquals(Integer.toString(seatHold.getSeatHoldId()), Integer.toString(1));
		
	}

}
