package scheduler;
import java.io.*;
import java.util.*;

public class Event {
	private String name;
	private TimeHolder[] time;
	
	public Event(TimeHolder[] times, String name) {
		this.time = times;
		this.name = name;
	}
	
	
	public TimeHolder[] getTimes() {
		return time;
	}
}


