package scheduler;
import java.util.ArrayList;

public class Scheduler {
	private Week schoolWeek;
	private Schedule[] schedules;
	private ArrayList<Integer> hours;

	public Scheduler(Week week) {
		schoolWeek = week;
		schedules = new Schedule[this.findPossibilities(this.schoolWeek)];
		hours = this.hours;

	}
	
	public int findPossibilities(Week week) {
		int possibilities = 1;
		int eventTimes = 0;
		for(Event event : week.getEvents()) {
			eventTimes = 0;
			for(TimeHolder time : event.getTimes()) {
			eventTimes = eventTimes + time.getTimes().length;
			}
			possibilities = possibilities*eventTimes;
			
			}
		return possibilities;
		}
	
	public void genPlans(int numEvents) {
		if(numEvents == 1) {
			for(int j = 0; j<this.schoolWeek.getEvents().get(numEvents-1).getTimes().length;j++) {
				
			}
		}
		
		else {
			for(int j = 0; j<this.schoolWeek.getEvents().get(numEvents-1).getTimes().length;j++) {
				this.genPlans(numEvents-1);
			}
		}
		
	}



}
