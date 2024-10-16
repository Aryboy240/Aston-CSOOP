package uk.ac.aston.oop.calendar;

public class Day {
	// The first and final bookable hours in a day.
	public static final int START_OF_DAY = 9;
	public static final int FINAL_APPOINTMENT_TIME = 17;

	// The number of bookable hours in a day.
	public static final int MAX_APPOINTMENTS_PER_DAY = FINAL_APPOINTMENT_TIME - START_OF_DAY + 1;

	// A day number within a particular year. (1-366)
	private int dayNumber;
	// The current list of appointments for this day.
	private Appointment[] appointments;

	/**
	 * Constructor for objects of class Day.
	 * 
	 * @param dayNumber The number of this day in the year (1-366).
	 */
	public Day(int dayNumber) {
		this.dayNumber = dayNumber;
		appointments = new Appointment[MAX_APPOINTMENTS_PER_DAY];
	}

	/**
	 * Make an appointment.
	 * 
	 * @param time        The hour at which the appointment starts.
	 * @param appointment The appointment to be made.
	 * @return true if the appointment was successful, false otherwise.
	 */
	public boolean makeAppointment(int time, Appointment appointment) {
		if (validTime(time) && validTime(time + appointment.getDuration() - 1)) {
	        int startIndex = time - START_OF_DAY;
	        int endIndex = startIndex + appointment.getDuration() - 1;

	        for (int i = startIndex; i <= endIndex; i++) {
	            if (appointments[i] != null) {
	                // There's already an appointment in this time range.
	                return false;
	            }
	        }

	        // All time slots are available, make the appointment.
	        for (int i = startIndex; i <= endIndex; i++) {
	            appointments[i] = appointment;
	        }

	        return true;
	    } else {
	        // Invalid time range.
	        return false;
	    }
	}

	/**
	 * @param time Which time of day. This must be between the START_OF_DAY time and
	 *             the FINAL_APPOINTMENT_TIME.
	 * @return The Appointment at the given time. null is returned if either the
	 *         time is invalid or there is no Appointment at the given time.
	 */
	public Appointment getAppointment(int time) {
		if (validTime(time)) {
			return appointments[time - START_OF_DAY];
		} else {
			return null;
		}
	}

	/**
	 * @return The number of this day within the year (1 - 366).
	 */
	public int getDayNumber() {
		return dayNumber;
	}

	/**
	 * @return true if the time is between FINAL_APPOINTMENT_TIME and END_OF_DAY,
	 *         false otherwise.
	 */
	public boolean validTime(int time) {
		return time >= START_OF_DAY && time <= FINAL_APPOINTMENT_TIME;
	}
}
