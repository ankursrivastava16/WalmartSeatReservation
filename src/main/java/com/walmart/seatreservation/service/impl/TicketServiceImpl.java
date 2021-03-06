package com.walmart.seatreservation.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import com.walmart.seatreservation.model.SeatHold;
import com.walmart.seatreservation.service.TicketService;

@Component
@PropertySource(value = { "classpath:application.properties" })
public class TicketServiceImpl implements TicketService {

	@Autowired
	private Environment environment;

	int seatHoldId = 0;

	ConcurrentHashMap<String, SeatHold> seatHoldMap = new ConcurrentHashMap<String, SeatHold>();

	int seatsAvailaible = 0;

	int reservedSeatsFinal = 0;

	static Multimap<String, String> myMultimapSeat = null;

	@PostConstruct
	public void init() {
		myMultimapSeat = ArrayListMultimap.create();

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				myMultimapSeat.put(Integer.toString(i), Integer.toString(j));
			}
		}
	}

	/**
	 * The number of seats in the venue that are neither held nor reserved
	 *
	 * @return the number of tickets available in the venue
	 */
	public int numSeatsAvailable() {
		// TODO Auto-generated method stub
		int rows = Integer.parseInt(environment.getProperty("rows"));
		int cols = Integer.parseInt(environment.getProperty("columns"));
		int totalseats = rows * cols;
		int seatsAvailaible = 0;
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		Date d1 = null;
		Date d2 = null;
		/**
		 * Iterate thru map Booking will be expired if less than 30 seconds
		 * 
		 */
		for (Map.Entry<String, SeatHold> entry : seatHoldMap.entrySet()) {
			String timeOfBooking = entry.getKey();
			String currentTime = getCurrentTimeStamp();

			try {
				d1 = format.parse(currentTime);

				d2 = format.parse(timeOfBooking);

				// in milliseconds
				long diff = d1.getTime() - d2.getTime();

				long diffSeconds = diff / 1000 % 60;

				if (diffSeconds < 180) {
					System.out
							.println("Less than 180 sec between hold and reserved so valid .");
					seatsAvailaible = seatsAvailaible
							+ Integer.valueOf(entry.getValue().getNumOfSeats());
				} else {
					System.out
							.println("More than 180 sec between hold and reserved so invalid .Removing the key");
					seatHoldMap.remove(entry.getKey());

				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return totalseats - reservedSeatsFinal;
	}

	/**
	 * Find and hold the best available seats for a customer
	 *
	 * @param numSeats
	 *            the number of seats to find and hold
	 * @param customerEmail
	 *            unique identifier for the customer
	 * @return a SeatHold object identifying the specific seats and related
	 *         information
	 */

	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

		// TODO Auto-generated method stub
		seatHoldId++;
		SeatHold seatHold = new SeatHold(seatHoldId,
				System.currentTimeMillis(), customerEmail, numSeats);
		String timeStampKey = getCurrentTimeStamp();
		seatHoldMap.put(timeStampKey, seatHold);
		// seatHoldIdMap.put(timeStampKey, seatHold);

		return seatHold;
	}

	/**
	 * Commit seats held for a specific customer
	 *
	 * @param seatHoldId
	 *            the seat hold identifier
	 * @param customerEmail
	 *            the email address of the customer to which the seat hold is
	 *            assigned
	 * @return a reservation confirmation code
	 * */
	public String reserveSeats(int seatHoldId, String customerEmail) {

		boolean seatHoldExists = false;
		String bookingMessage = null;
		int numSeatsBooking = 0;
		int counterColumns = 0;
		int reservedSeats = 0;
		for (Map.Entry<String, SeatHold> entry : seatHoldMap.entrySet()) {
			if (entry.getValue().getSeatHoldId() == seatHoldId) {
				seatHoldExists = true;
				numSeatsBooking = entry.getValue().getNumOfSeats();
				break;
			}

		}
		reservedSeats = reservedSeats + numSeatsBooking;
		if (seatHoldExists) {
			getSeatAvailaibiltyInfo(reservedSeats, customerEmail);
			bookingMessage = "Booking Completed for  seatHoldId = " + seatHoldId;

		} else {
			System.out.println(" Seat Hold Id Expired");
			bookingMessage = "Booking Not Done . Seat Hold Id Expired ";
		}
		return bookingMessage;
	}

	private String getCurrentTimeStamp() {
		return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
	}

	private void getSeatAvailaibiltyInfo(int reservedSeats, String customerEmail) {

		/**
		 * Under the assumption reservedSeats will always be less than 10
		 * 
		 */
		int reservedRow = 0;
		int reservedRow2 = 0;
		int rowNum1 = 0;

		int seatavlrow1 = 0;

		Collection<String> rowNumAvlSeats = null;

		for (String value : myMultimapSeat.keys()) {
			// take the rowkey
			rowNum1 = Integer.parseInt(value);
			break;
		}

		rowNumAvlSeats = myMultimapSeat.get(Integer.toString(rowNum1));

		if (rowNumAvlSeats.size() >= reservedSeats) {

			reservedRow = rowNum1;
			System.out.println("reservedRow " + reservedRow);

			Collection<String> colNumToStart = myMultimapSeat.get(Integer
					.toString(reservedRow));
			Object[] colArray = colNumToStart.toArray();

			int colnum = Integer.parseInt(colArray[0].toString());
			System.out.println("reservedRow " + reservedRow);
			System.out.println("colnum " + colnum);
			System.out.println("reservedSeats " + reservedSeats);
			for (int columstart = colnum; columstart <= reservedSeats; columstart++) {
				System.out.println(" Seats booked for " + customerEmail + " "
						+ reservedRow + "," + columstart);

				myMultimapSeat.remove(Integer.toString(reservedRow),
						Integer.toString(columstart));
				// myMultimapSeat.put(Integer.toString(reservedRow),customerEmail);
			}

		} else {
			reservedRow = rowNum1;
			reservedRow2 = rowNum1 + 1;
			seatavlrow1 = 10 - rowNumAvlSeats.size();

			int remainingseats = reservedSeats - seatavlrow1;

			Collection<String> colNumToStart = myMultimapSeat.get(Integer
					.toString(reservedRow));
			Object[] colArray = colNumToStart.toArray();

			int colnum = Integer.parseInt(colArray[0].toString());
			System.out.println("reservedRow " + reservedRow);
			System.out.println("colnum " + colnum);
			System.out.println("reservedSeats " + reservedSeats);

			for (int columstart = colnum; columstart <= 10; columstart++) {
				System.out.println(" Seats booked for " + customerEmail + " "
						+ reservedRow + "," + columstart);

				myMultimapSeat.remove(Integer.toString(reservedRow),
						Integer.toString(columstart));
				// myMultimapSeat.put(Integer.toString(reservedRow),customerEmail);
			}

			for (int columstart = 1; columstart <= remainingseats; columstart++) {
				System.out.println(" Seats booked for " + customerEmail + " "
						+ reservedRow2 + "," + columstart);

				myMultimapSeat.remove(Integer.toString(reservedRow2),
						Integer.toString(columstart));
				// myMultimapSeat.put(Integer.toString(reservedRow),customerEmail);
			}
		}

		reservedSeatsFinal = reservedSeatsFinal + reservedSeats;

		System.out.print("\n");
	}

}
