package com.walmart.seatreservation.web;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.walmart.seatreservation.model.SeatHold;
import com.walmart.seatreservation.service.TicketService;
import com.walmart.seatreservation.service.impl.TicketServiceImpl;

@Configuration
@ComponentScan({"com.walmart.seatreservation.service.impl"})
public class SeatReservationMain {

	   @Autowired
	    private TicketServiceImpl ticketService;
	   
	    @Autowired
	    private Environment environment;
	   
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SeatReservationMain.class);

		SeatReservationMain p = context.getBean(SeatReservationMain.class);
		p.start();
		// TODO Auto-generated method stub

	}
	
	private void start(){
		boolean quit = false;
		
		Scanner inputMessage = new Scanner(System.in);
		
		System.out.println("Seats availaible at present = "+ ticketService.numSeatsAvailable());
		

		
		while(true){
		
		SeatHold seatHold = ticketService.findAndHoldSeats(5, "ankur@ankur.com");

		
		System.out.println(ticketService.reserveSeats(seatHold.getSeatHoldId(), "ankur@ankur.com"));
		
		SeatHold seatHold2 = ticketService.findAndHoldSeats(8, "ankur2@ankur2.com");
		
		System.out.println(ticketService.reserveSeats(seatHold2.getSeatHoldId(), "ankur2@ankur2.com"));
		
		SeatHold seatHold3 = ticketService.findAndHoldSeats(9, "ankur3@ankur3.com");

		
		System.out.println(ticketService.reserveSeats(seatHold3.getSeatHoldId(), "ankur@ankur.com"));
			
		
		
		System.out.println("Do you want to quit.Type quit else No to go ahead with further bookings");
		String message = inputMessage.nextLine();
		if(message.equals("quit")){
			System.out.println("quitting the reservation booking");
			System.exit(0);
		}
		}
	}

}
