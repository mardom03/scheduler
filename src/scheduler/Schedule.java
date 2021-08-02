package scheduler;
import java.util.ArrayList;

public class Schedule {
	private ArrayList<Event> classes;
	private ArrayList<Integer> hours;
	private ArrayList<Integer> days;
	
	public Schedule(ArrayList<Event> classes, ArrayList<Integer> hours, ArrayList<Integer> days) {
		//hours are the indices, index 0=8am, index 1=9am, ... index 9=5pm
		this.classes = classes;
		this.hours = hours;
		this.days = days;
	}
	
	public String toString() {
		//Create 2D array of schedule
		Event[][] table = new Event[5][10];
		for(int i = 0; i<this.classes.size(); i++) {
			table[days.get(i)][hours.get(i)] = classes.get(i);
		}
		
		//Convert table into String to return
		int spacing = 15;
		String sch = "      "; sch+=String.format("%-" + spacing + "s", "Monday"); sch+=String.format("%-" + spacing + "s", "Tuesday"); sch+=String.format("%-" + spacing + "s", "Wednesday"); sch+=String.format("%-" + spacing + "s", "Thursday"); sch+=String.format("%-" + spacing + "s", "Friday"); sch+="\n";
		String current = "";
		for(int i = 0; i<10; i++) {
			sch += String.format("%02d00  ", i+8);
			for(int j = 0; j<5; j++) {
				try {current = table[j][i].toString();}
				catch(Exception e) {current = "--------";}
				sch += String.format("%-" + spacing + "s", current);
			}
			sch+="\n";
		}
		
		return sch;
	}

	
/***
 * Just thinking about how we can display the schedule, and this might be a good spot to use a 2d array to enter data,
 * that way you can organize the classes both by day and time of day. 
 * Then just use a for loop to print out that array very cleanly. Just a thought.
***/
}
