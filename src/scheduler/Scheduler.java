package scheduler;
import java.util.ArrayList;

public class Scheduler {
	private Week schoolWeek;
	private Schedule[] schedules;
	private ArrayList<Integer> hours;
	private ArrayList<Event> classes;
	private ArrayList<Integer> day;
	private int counter;

	public Scheduler(Week week) {
		schoolWeek = week;
		schedules = new Schedule[this.findPossibilities(this.schoolWeek)];
		hours = this.hours;
		classes = this.classes;
		day = this.day;
		counter = 0;

	}
	
	public ArrayList<Event> getEvents(){
		return classes;
	}
	
	public int findPossibilities(Week week) {
		int possibilities = 1;
		int eventTimes = 0;
		for(Event event : this.getEvents()) {
			eventTimes = 0;
			for(TimeHolder time : event.getTimes()) {
			eventTimes = eventTimes + time.getTimes().length;
			}
			possibilities = possibilities*eventTimes;
			
			}
		return possibilities;
		}
	
	public void genPlans(int numEvents){
		day.add(0);
		if(numEvents == 1) {
			for(TimeHolder holder : this.getEvents().get(numEvents-1).getTimes()) {
				for(int j = 0;j<holder.getTimes().length;j++) {
					hours.add(j);
					schedules[counter] = new Schedule(classes, hours, day);
					counter++;
					hours.remove(0);
					
				}
				day.set(numEvents-1, day.get(numEvents-1)+1);
				
			}
		}
		
		else {
			for(TimeHolder holder : this.getEvents().get(numEvents-1).getTimes()) {
				for(int j = 0;j<holder.getTimes().length;j++) {
					hours.add(j);
					this.genPlans(numEvents-1);
					hours.remove(0);
				}
				day.set(numEvents-1, day.get(numEvents-1)+1);
				
			}
		}
		
	}



}
