package scheduler;
import java.util.ArrayList;

public class Scheduler {
	private ArrayList<Schedule> schedules;
	private ArrayList<Integer> hours;
	private ArrayList<Event> classes;
	private ArrayList<Integer> day;

	public Scheduler(ArrayList<Event> classes, ArrayList<Integer> day, ArrayList<Integer> hours, ArrayList<Schedule> schedules) {
		this.schedules = schedules;
		this.hours = hours;
		this.classes = classes;
		this.day = day;

	}
	
	public ArrayList<Schedule> getSchedules(){
		return schedules;
	}
	
	public ArrayList<Event> getEvents(){
		return classes;
	}
	
	public int findPossibilities() {
		int possibilities = 1;
		int eventTimes = 0;
		for(Event event : this.getEvents()) {
			eventTimes = 0;
			eventTimes = eventTimes + event.getTimes().length;
			possibilities = possibilities*eventTimes;
			}
			
		return possibilities;
		}
	
	public void genPlans(int numEvents){
		day.add(0);
		if(numEvents == 1) {
			for(int i = 0; i<this.getEvents().get(numEvents-1).getTimes().length;i++) {
					for(int j = 0; j<this.getEvents().get(numEvents-1).getTimes().length;j++) {
						hours.add(this.getEvents().get(numEvents-1).getTimes()[i]);
					if(this.hasConflict(classes,hours,day)) {
						for(int l = 0; l<this.getEvents().get(numEvents-1).getTimes().length;l++) {
							hours.remove(0);
						}
						continue;
						}
					schedules.add(new Schedule(classes, hours, day));
					for(int l = 0; l<this.getEvents().get(numEvents-1).getTimes().length-1;l++) {
						hours.remove(0);
					
				}
				day.set(numEvents-1, day.get(numEvents-1)+1);
				
			}
			}
		}
		
		else {
			for(int i = 0; i<this.getEvents().get(numEvents-1).getTimes().length;i++) {
				for(int j = 0; j<this.getEvents().get(numEvents-1).getTimes().length;j++) {
					hours.add(this.getEvents().get(numEvents-1).getTimes()[i]);
				this.genPlans(numEvents-1);
				for(int l = 0; l<this.getEvents().get(numEvents-1).getTimes().length-1;l++) {
					hours.remove(0);
				}
				day.set(numEvents-1, day.get(numEvents-1)+1);
				
			}
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
