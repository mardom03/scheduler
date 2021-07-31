package scheduler;
import java.io.*;
import java.util.*;

public class Week{
	private Day[] week;
	private Event[] events;
	
	public Week(Event[] eventList) {
		week = new Day[]{new Day(), new Day(), new Day(), new Day(), new Day()};
		events = eventList;
	}
	
	
	public Day[] getWeek()
	{
		return week;
	}
	
	public Event[] getEvents() {
		return events;
	}

}
