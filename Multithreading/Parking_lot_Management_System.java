/*
A shopping mall has:

Available Parking Slots = 3

Multiple cars arrive simultaneously.

Each car is represented by a separate thread.

Requirements
Create a shared ParkingLot class.
Initially:
slots = 3
When a car arrives:
If a slot is available:
Park the car
Reduce available slots
Print:
Car 1 Parked
Available Slots: 2
Otherwise:
No Parking Available for Car 4
Use synchronization to prevent incorrect slot allocation.
Create at least 6 car threads.

Instructions - 
Create Class ParkingLot

    availableSlots ← 3

    synchronized Method parkCar(carName)

        IF availableSlots > 0

            Print carName + " Parked"

            availableSlots ← availableSlots - 1

            Print "Available Slots: " + availableSlots

        ELSE

            Print "No Parking Available for " + carName

        END IF


Create Class CarThread

    ParkingLot parkingLot
    carName

    Method run()

        parkingLot.parkCar(carName)


Main Method

    Create ParkingLot object

    Create Car1 thread till Car6 thread
    Start Car1 till  Car6


*/
package day15_progs;
import java.util.*;
class parking_Slot {
    int slots = 3;

    synchronized void availability() {
        if (slots > 0) {
            System.out.println(Thread.currentThread().getName()
                    + " Parked");
            System.out.println("Available Slots: " + (--slots));
        } else {
            System.out.println("No Parking Available for "
                    + Thread.currentThread().getName());
        }
    }
}
class cars extends Thread{
	parking_Slot parking_Slot;
	cars(parking_Slot parking_Slot ,String name){
		super(name);
		this.parking_Slot=parking_Slot;
	}
	public void run() {
		parking_Slot.availability();
	}
}
public class Parking_lot_Management_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parking_Slot parking_Slot = new parking_Slot();
		cars c1 = new cars(parking_Slot, "Car 1");
		cars c2 = new cars(parking_Slot, "Car 2");
		cars c3 = new cars(parking_Slot, "Car 3");
		cars c4 = new cars(parking_Slot, "Car 4");
		cars c5 = new cars(parking_Slot, "Car 5");
		cars c6 = new cars(parking_Slot, "Car 6");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
	}

}
