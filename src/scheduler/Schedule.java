package scheduler;
import java.util.ArrayList;

public class Schedule {
	private ArrayList<Event> classes;
	private ArrayList<Integer> hours;
	private ArrayList<Integer> days;
	
	public Schedule(ArrayList<Event> courses, ArrayList<Integer> hours, ArrayList<Integer> days) {
		//hours are the indices, index 0=8am, index 1=9am, ... index 9=5pm
		classes = courses;
		this.hours = hours;
		this.days = days;
		
	}

	
/***
 * Just thinking about how we can display the schedule, and this might be a good spot to use a 2d array to enter data,
 * that way you can organize the classes both by day and time of day. 
 * Then just use a for loop to print out that array very cleanly. Just a thought.
***/
}
