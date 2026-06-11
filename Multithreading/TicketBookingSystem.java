/*
Ticket Booking System

A movie theater has:

Total Seats = 5

Create:

Multiple booking threads
Requirements
Each thread tries to book seats.
If seats are available, booking succeeds.
Otherwise print:
Booking Failed

Concepts Tested
Threads
Shared Resource
Synchronized Method

Instructions - 
Create class Theater

    Variable:
        totalSeats = 5

    synchronized method bookSeat(int seats)

        If totalSeats >= seats

            Print:
                ThreadName + " Booking Successful"

            totalSeats = totalSeats - seats

            Print remaining seats

        Else

            Print:
                ThreadName + " Booking Failed"


Create class BookingThread extends Thread

    Theater theater
    int seatsRequired

    Constructor receives:
        theater
        seatsRequired

    run()

        theater.bookSeat(seatsRequired)


Main Method

    Create Theater object

    Create Thread1 -> wants 2 seats
    Create Thread2 -> wants 2 seats
    Create Thread3 -> wants 2 seats

    Start Thread1
    Start Thread2
    Start Thread3


Possible Output

    Thread1 Booking Successful
    Remaining Seats = 3

    Thread2 Booking Successful
    Remaining Seats = 1

    Thread3 Booking Failed
*/
package day15_progs;
import java.util.*;

class theater {
    int seats = 5;

    synchronized void counter() {
        if (seats > 0) {
            System.out.println(Thread.currentThread().getName() + " Booking Successful. Remaining Seats: " + (--seats));
        } else {
            System.out.println(Thread.currentThread().getName()+ " Booking Failed");
        }
    }
}
class BookingThread extends Thread{
	theater theater;
	BookingThread(theater theater){
		this.theater=theater;
	}
	public void run()	{
		theater.counter();
	}
}
public class TicketBookingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		theater forBooking =new theater();
		BookingThread p1 =new BookingThread(forBooking);
		BookingThread p2 =new BookingThread(forBooking);
		BookingThread p3 =new BookingThread(forBooking);
		BookingThread p4 =new BookingThread(forBooking);
		BookingThread p5 =new BookingThread(forBooking);
		BookingThread p6 =new BookingThread(forBooking);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
	
		
	}

}
