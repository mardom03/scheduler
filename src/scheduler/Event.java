package scheduler;
import java.io.*;
import java.util.*;

public class Event {
	private String name;
	private int[] days;
	private int[] hours;
	private int credits;
	
	//hours are the indices, index 0=8am, index 1=9am, ... index 9=5pm
	public Event(int[] days, int[] hours, String name, int cred) {
		this.days = days;
		this.name = name;
		this.hours = hours;
		this.credits = cred;
	}
	
	
	public int[] getDays() {
		return days;
	}
	public int[] getTimes() {
		return hours;
	}
	
	public String toString() {
		return this.name;
	}
	
	public int getCredits() {
		return credits;
	}
}


