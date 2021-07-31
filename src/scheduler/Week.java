package scheduler;
import java.io.*;
import java.util.*;

public class Week{
	private Day[] week;
	private ArrayList<Event> events;
	
	public Week(ArrayList<Event> eventList) {
		week = new Day[]{new Day(), new Day(), new Day(), new Day(), new Day()};
		events = eventList;
	}
	
	
	public Day[] getWeek()
	{
		return week;
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}

}
