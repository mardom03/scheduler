package scheduler;
import java.io.*;
import java.util.*;

public class Event {
	private String name;
	private int time;
	
	public Event(int time, String name) {
		this.time = time;
		this.name = name;
	}
}
