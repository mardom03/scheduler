package scheduler;
import java.io.*;
import java.util.*;

public class Event {
	private String name;
	private TimeHolder[] time;
	
	//hours are the indices, index 0=8am, index 1=9am, ... index 9=5pm
	public Event(TimeHolder[] times, String name) {
		this.time = times;
		this.name = name;
	}
	
	
	public TimeHolder[] getTimes() {
		return time;
	}
	
	public String toString() {
		return this.name;
	}
}


