package scheduler;
import java.io.*;
import java.util.*;

public class Week{
	private Day[] week;
	
	public Week(ArrayList<Event> eventList) {
		week = new Day[]{new Day(), new Day(), new Day(), new Day(), new Day()};
	
	}
	
	
	public Day[] getWeek()
	{
		return week;
	}
	

}
