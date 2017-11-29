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
@ComponentScan({ "com.walmart.seatreservation.service.impl" })
public class SeatReservationMain {

	@Autowired
	private TicketServiceImpl ticketService;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				SeatReservationMain.class);

		SeatReservationMain p = context.getBean(SeatReservationMain.class);
		p.start();
		// TODO Auto-generated method stub

	}

	private void start() {
		boolean quit = false;

		Scanner inputMessage = new Scanner(System.in);

		System.out.println("Seats availaible at present = "
				+ ticketService.numSeatsAvailable());

		SeatHold seatHold = null;

		while (true) {
			SeatHold seatHold1 = ticketService.findAndHoldSeats(5, "ankur@ankur.com");

			System.out.println(ticketService.reserveSeats(
					seatHold1.getSeatHoldId(), "ankur@ankur.com"));

			System.out.println("Seats availaible at present = "
					+ ticketService.numSeatsAvailable());

			System.out.println("***************");

			SeatHold seatHold2 = ticketService.findAndHoldSeats(8,
					"ankur2@ankur2.com");

			System.out.println(ticketService.reserveSeats(
					seatHold2.getSeatHoldId(), "ankur2@ankur2.com"));

			System.out.println("Seats availaible at present = "
					+ ticketService.numSeatsAvailable());

			System.out.println("***************");

			SeatHold seatHold3 = ticketService.findAndHoldSeats(9,
					"ankur3@ankur3.com");

			System.out.println(ticketService.reserveSeats(
					seatHold3.getSeatHoldId(), "ankur3@ankur3.com"));

			System.out.println("Seats availaible at present = "
					+ ticketService.numSeatsAvailable());

			System.out.println("***************");

			SeatHold seatHold4 = ticketService.findAndHoldSeats(9,
					"ankur4@ankur4.com");

			System.out.println(ticketService.reserveSeats(
					seatHold4.getSeatHoldId(), "ankur4@ankur4.com"));

			System.out.println("Seats availaible at present = "
					+ ticketService.numSeatsAvailable());

			System.out.println("***************");

			SeatHold seatHold5 = ticketService.findAndHoldSeats(8,
					"ankur5@ankur5.com");

			System.out.println(ticketService.reserveSeats(
					seatHold5.getSeatHoldId(), "ankur5@ankur5.com"));

			System.out.println("Seats availaible at present = "
					+ ticketService.numSeatsAvailable());

			System.out.println("***************");

			System.out.println("Enter the number of seats to be booked ");
			String numOfSeats = inputMessage.nextLine();

			System.out.println("Enter the emailId of User ");
			String emailId = inputMessage.nextLine();

			seatHold = ticketService.findAndHoldSeats(
					Integer.parseInt(numOfSeats), emailId);

			System.out.println(ticketService.reserveSeats(
					seatHold.getSeatHoldId(), emailId));

			System.out.println("Seats availaible at present = "
					+ ticketService.numSeatsAvailable());

			System.out.println("***************");

			System.out
					.println("Type quit to exit the application or NO to continue !!!!");
			String message = inputMessage.nextLine();
			if (message.equals("quit")) {
				System.out.println("quitting the reservation booking");
				System.exit(0);
			}
		}
	}

}
