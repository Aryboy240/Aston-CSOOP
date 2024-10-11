package uk.ac.aston.oop.calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DayTest.
 *
 * @author (Aryan Kora)
 * @version (23/01/2024)
 */
public class DayTest {

	@Test public void appointmentStartOfDay() {
		// Arrange
		Day day = new Day(1);
		Appointment appointment = new Appointment("This is a test",1);
		//Act
		boolean sucsess = day.makeAppointment(Day.START_OF_DAY, appointment);
		Appointment fetch = day.getAppointment(Day.START_OF_DAY);
		//Assert
		assertTrue(sucsess, "Making an appointment at the start of a new day should work");
		assertSame(appointment, fetch, "It should be possible to fetch the appointment we just made");
	}
	
	@Test public void appointmentBeforeStartOfDay() {
		// Arrange
		Day day = new Day(2);
		Appointment appointment = new Appointment("This is a second test",1);
		//Act
		boolean sucsess = day.makeAppointment(Day.START_OF_DAY - 1, appointment);
		Appointment fetch = day.getAppointment(Day.START_OF_DAY - 1);
		//Assert
		assertFalse(sucsess, "Making an appointment before the start of the day should fail");
		assertNull(fetch, "There should be no appointment before the start of the day");
	}
	
	@Test public void twoAppsOnSameTime() {
		// Arrange
		Day day = new Day(3);
		Appointment appointmentA = new Appointment("This is a third test - Appointment A",1);
		Appointment appointmentB = new Appointment("This is a third test - Appointment B",1);
		
		//Act
		boolean sucsessA = day.makeAppointment(Day.START_OF_DAY, appointmentA);
		Appointment fetchA = day.getAppointment(Day.START_OF_DAY);
		boolean sucsessB = day.makeAppointment(Day.START_OF_DAY, appointmentB);
		Appointment fetchB = day.getAppointment(Day.START_OF_DAY);
		
		//Assert
		assertTrue(sucsessA, "making an appointment in an empty slot should work");
		assertSame(appointmentA, fetchA, "The expected appointment was fetched back from the Day at the expected time");
		assertFalse(sucsessB, "Making an appointment in an occupied slot should not work");
		assertNotSame(appointmentB, fetchB, "This check is to ensure that the second appointment did not overwrite the existing one");
	}
	
	@Test public void twoHourAppointmentAtStart() {
		// Arrange
		Day day = new Day(4);
		Appointment appointment = new Appointment("This is a forth test - 2 hour appointment",2);
		//Act
		boolean sucsess = day.makeAppointment(Day.START_OF_DAY, appointment);
		Appointment appointmentAt9 = day.getAppointment(Day.START_OF_DAY);
		Appointment appointmentAt10 = day.getAppointment(Day.START_OF_DAY + 1);
		//Assert
		assertTrue(sucsess, "Making a two-hour appointment at the start of the day should work");
		assertSame(appointment, appointmentAt9, "Fetching the appointment at 9 o'clock should return the same 2-hour appointment");
		assertSame(appointment, appointmentAt10, "Fetching the appointment at 10 o'clock should return the same 2-hour appointment");
	}

	@Test public void twoHourAppointmentBeyondEnd() {
		// Arrange
		Day day = new Day(4);
		Appointment appointment = new Appointment("This is a fith test - 2 hour after end",2);
		//Act
		boolean sucsess = day.makeAppointment(Day.FINAL_APPOINTMENT_TIME, appointment);
		Appointment appointmentAt17 = day.getAppointment(Day.FINAL_APPOINTMENT_TIME);
		Appointment appointmentAt18 = day.getAppointment(Day.FINAL_APPOINTMENT_TIME + 1);
		//Assert
		assertFalse(sucsess, "Making a two-hour appointment at the end of the day shouldn't work");
		assertNull(appointmentAt17, "There should be no appointment at 17:00");
        assertNull(appointmentAt18, "There should be no appointment at 18:00");
	}
	
	@Test public void overlappingTwoHourAppointments() {
		// Arrange
		Day day = new Day(4);
		Appointment appointment1 = new Appointment("This is a fith test - 2 hours overlapping",2);
		Appointment appointment2 = new Appointment("This is a fith test - 2 hours overlapping (2)",2);
		//Act
		boolean sucsess = day.makeAppointment(11, appointment1);
		Appointment appointmentAt11 = day.getAppointment(11);
		Appointment appointmentAt12 = day.getAppointment(12);
		
		boolean sucsess2 = day.makeAppointment(10, appointment2);
		Appointment appointmentAt10 = day.getAppointment(10);
		Appointment appointmentAt11Again = day.getAppointment(11);
		//Assert
		assertTrue(sucsess, "Making a two-hour appointment from 11-12 should work");
		assertSame(appointment1, appointmentAt11, "There should be a 2-hour appointment at 11:00");
		assertSame(appointment1, appointmentAt12, "There should be a 2-hour appointment at 12:00");
		
		assertFalse(sucsess2, "Making the overlapping appointment should not work");
		assertNull(appointmentAt10, "There should be no appointment at 10:00");
		assertNotSame(appointment2,appointmentAt11Again, "This check is to ensure that the second appointment did not overwrite the existing one");
	}
}