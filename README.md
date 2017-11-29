# WalmartSeatReservation

## Assumptions

* Since i have not used an in memory DB or SQL/No SQL DB to save the availaible or occupied seats ,  i implemented Mutlimap for Seat allocation /De allocation.Also seats will be filled in sequential manner like 1st row ,2nd row and till the 10th row.Users are not allowed to select seats of their choice , since in the method signatures , i didnt find any info like that.I have implemented the use case as per the method signatures specified in the problem statement.
* I have specified  property in the properties file for row and columns .They are 10 X 10.
* In  the program , i am running the first 5 requests as static for seat hold id 1 to 5 and then there is a prompt to accept user level input.Based on that seats will be reserved and allocated .

## How to run

* Please import the above project as a Maven project in Eclipse.
* Go to to the project root folder in Terminal or Command Line and execute mvn clean install.
* As its an exceutable jar , then run the command java -jar target\seatreservation.jar

## Result 


log4j:WARN No appenders could be found for logger (org.springframework.core.env.StandardEnvironment).
log4j:WARN Please initialize the log4j system properly.
Seats availaible at present = 100
reservedRow 1
reservedRow 1
colnum 1
reservedSeats 5
 Seats booked for ankur@ankur.com 1,1
 Seats booked for ankur@ankur.com 1,2
 Seats booked for ankur@ankur.com 1,3
 Seats booked for ankur@ankur.com 1,4
 Seats booked for ankur@ankur.com 1,5

Booking Completed for  seatHoldId = 1
Less than 180 sec between hold and reserved so valid .
Seats availaible at present = 95
***************
reservedRow 1
colnum 6
reservedSeats 8
 Seats booked for ankur2@ankur2.com 1,6
 Seats booked for ankur2@ankur2.com 1,7
 Seats booked for ankur2@ankur2.com 1,8
 Seats booked for ankur2@ankur2.com 1,9
 Seats booked for ankur2@ankur2.com 1,10
 Seats booked for ankur2@ankur2.com 2,1
 Seats booked for ankur2@ankur2.com 2,2
 Seats booked for ankur2@ankur2.com 2,3

Booking Completed for  seatHoldId = 2
Less than 180 sec between hold and reserved so valid .
Seats availaible at present = 87
***************
reservedRow 2
colnum 4
reservedSeats 9
 Seats booked for ankur@ankur.com 2,4
 Seats booked for ankur@ankur.com 2,5
 Seats booked for ankur@ankur.com 2,6
 Seats booked for ankur@ankur.com 2,7
 Seats booked for ankur@ankur.com 2,8
 Seats booked for ankur@ankur.com 2,9
 Seats booked for ankur@ankur.com 2,10
 Seats booked for ankur@ankur.com 3,1
 Seats booked for ankur@ankur.com 3,2
 Seats booked for ankur@ankur.com 3,3
 Seats booked for ankur@ankur.com 3,4
 Seats booked for ankur@ankur.com 3,5
 Seats booked for ankur@ankur.com 3,6

Booking Completed for  seatHoldId = 3
Less than 180 sec between hold and reserved so valid .
Seats availaible at present = 78
***************
reservedRow 3
colnum 7
reservedSeats 9
 Seats booked for ankur4@ankur4.com 3,7
 Seats booked for ankur4@ankur4.com 3,8
 Seats booked for ankur4@ankur4.com 3,9
 Seats booked for ankur4@ankur4.com 3,10
 Seats booked for ankur4@ankur4.com 4,1
 Seats booked for ankur4@ankur4.com 4,2
 Seats booked for ankur4@ankur4.com 4,3

Booking Completed for  seatHoldId = 4
Less than 180 sec between hold and reserved so valid .
Seats availaible at present = 69
***************
reservedRow 4
colnum 4
reservedSeats 8
 Seats booked for ankur5@ankur5.com 4,4
 Seats booked for ankur5@ankur5.com 4,5
 Seats booked for ankur5@ankur5.com 4,6
 Seats booked for ankur5@ankur5.com 4,7
 Seats booked for ankur5@ankur5.com 4,8
 Seats booked for ankur5@ankur5.com 4,9
 Seats booked for ankur5@ankur5.com 4,10
 Seats booked for ankur5@ankur5.com 5,1
 Seats booked for ankur5@ankur5.com 5,2
 Seats booked for ankur5@ankur5.com 5,3
 Seats booked for ankur5@ankur5.com 5,4
 Seats booked for ankur5@ankur5.com 5,5

Booking Completed for  seatHoldId = 5
Less than 180 sec between hold and reserved so valid .
Seats availaible at present = 61
***************
Enter the number of seats to be booked
