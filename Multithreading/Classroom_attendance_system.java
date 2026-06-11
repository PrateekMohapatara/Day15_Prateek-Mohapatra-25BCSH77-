/*
Classroom Attendance System

Teacher thread:

Takes attendance

Student thread:

Waits until attendance starts
Requirements
Students should not proceed immediately.
Students must wait.
Teacher gives signal.
Students continue after signal.

Expected Flow:

Student Waiting...

Teacher Started Attendance

Student Marked Present
Concepts Tested
wait()
notifyAll()


Instructions - 
Create Class Classroom

    Variable:
        attendanceStarted = false

    synchronized method waitForAttendance()

        While attendanceStarted is false

            Print:
                "Student Waiting..."

            wait()

        Print:
            "Student Marked Present"


    synchronized method startAttendance()

        attendanceStarted = true

        Print:
            "Teacher Started Attendance"

        notifyAll()


Create Class TeacherThread

    Classroom classroom

    run()

        classroom.startAttendance()


Create Class StudentThread

    Classroom classroom

    run()

        classroom.waitForAttendance()


Main Method

    Create Classroom object

    Create multiple Student threads

    Create Teacher thread

    Start Student threads

    Wait for a few seconds

    Start Teacher thread
Thread Coordination
Synchronization
*/
package day15_progs;
import java.util.*;
class system{
	boolean isStarted =false;
	synchronized void Wait_attendance() {
		while(!isStarted) {
			System.out.println(Thread.currentThread().getName() + " Waiting...");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	
		System.out.println(Thread.currentThread().getName() +" marked present");
	}
				
	synchronized void start_attendance(){
		
		System.out.println("Teacher Started Attendance");
		isStarted =true;
		notifyAll();	
		
	}
			
	}
class TeacherThread extends Thread{
	system system;
	TeacherThread(system system){
		this.system=system;
	}
	public void run() {
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			
		}
		system.start_attendance();
	}
}
class StudentThread extends Thread {
	system system;
	StudentThread(system system){
		this.system=system;
	}
	public void run() {
		system.Wait_attendance();
	}
}
public class Classroom_attendance_system {

	public static void main(String[] args) {

	    system system = new system();

	    StudentThread s1 = new StudentThread(system);
	    StudentThread s2 = new StudentThread(system);
	    StudentThread s3 = new StudentThread(system);

	    TeacherThread t1 = new TeacherThread(system);

	    s1.start();
	    s2.start();
	    s3.start();

	    t1.start();
	}
}
