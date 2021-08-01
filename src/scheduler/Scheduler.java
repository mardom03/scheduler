package scheduler;
import java.util.ArrayList;

public class Scheduler {
	private ArrayList<Schedule> schedules;
	private ArrayList<Integer> hours;
	private ArrayList<Event> classes;
	private ArrayList<Integer> day;

	public Scheduler() {
		schedules = this.schedules;
		hours = this.hours;
		classes = this.classes;
		day = this.day;

	}
	
	public ArrayList<Event> getEvents(){
		return classes;
	}
	
	public int findPossibilities() {
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
					hours.add(holder.getTimes()[j]);
					if(this.hasConflict(classes,hours,day)) {
						hours.remove(0);
						continue;
						}
					schedules.add(new Schedule(classes, hours, day));
					hours.remove(0);
					
				}
				day.set(numEvents-1, day.get(numEvents-1)+1);
				
			}
		}
		
		else {
			for(TimeHolder holder : this.getEvents().get(numEvents-1).getTimes()) {
				for(int j = 0;j<holder.getTimes().length;j++) {
					hours.add(holder.getTimes()[j]);
					this.genPlans(numEvents-1);
					hours.remove(0);
				}
				day.set(numEvents-1, day.get(numEvents-1)+1);
				
			}
		}
		
	}
	
	public boolean hasConflict(ArrayList<Event> courses, ArrayList<Integer> hours, ArrayList<Integer> days) {
		for(int j = 0; j<hours.size()-1;j++) {
			for(int i = j+1;i<hours.size();i++) {
				if((hours.get(j)==hours.get(i)) && (days.get(j)==days.get(i))) {
					return true;
				}
			}
		}
		return false;
	}



}
