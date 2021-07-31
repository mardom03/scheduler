package scheduler;
import java.math.BigInteger;

public class Scheduler {

	public static void main(String[] args) {
		Week schoolWeek = new Week();
		

	}
	
	public long findPossibilities(Week week) {
		long possibilities = 1;
		long eventTimes = 0;
		for(Event event : week.getEvents()) {
			eventTimes = 0;
			for(TimeHolder time : event.getTimes()) {
			eventTimes = eventTimes + time.getTimes().length;
			}
			possibilities = possibilities*eventTimes;
			
			}
		return possibilities;
		}



}
