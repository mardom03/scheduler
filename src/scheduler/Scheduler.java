package scheduler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public ArrayList<Integer> getHours(){
		return hours;
	}
	
	public ArrayList<Integer> getDays(){
		return day;
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
		if(numEvents == 1) {
			for(int i : this.getEvents().get(numEvents-1).getTimes()) {
				this.hours.add(0,i);
				for(int j = 0; j<this.getEvents().get(numEvents-1).getDays().length;j++) {
					this.day.add(0, this.getEvents().get(numEvents-1).getDays()[j]);
				}
				ArrayList<Event> shallowCopy = new ArrayList(classes);
				ArrayList<Integer> shallowCopy1 = new ArrayList(hours);
				ArrayList<Integer> shallowCopy2 = new ArrayList(day);
				if(this.hasConflict(shallowCopy, shallowCopy1,shallowCopy2)) {
					System.out.println("Conflict");
				}
				
				else {
					
					this.schedules.add(new Schedule(shallowCopy, shallowCopy1, shallowCopy2));
				}
				for(int l = 0; l<this.getEvents().get(numEvents-1).getDays().length;l++) {
					day.remove(0);	
			}
				hours.remove(0);
				
				
			}
			
			
		}
		
		else {
			for(int i : this.getEvents().get(numEvents-1).getTimes()) {
				this.hours.add(0,i);
					for(int j = 0; j<this.getEvents().get(numEvents-1).getDays().length;j++) {
						this.day.add(0, this.getEvents().get(numEvents-1).getDays()[j]);
					}
					this.genPlans(numEvents-1);
					for(int l = 0; l<this.getEvents().get(numEvents-1).getDays().length;l++) {
						this.day.remove(0);
					}
				this.hours.remove(0);
					
					
				
			}
		}
		
					
				
			
		
		
		
	}
	
	public boolean hasConflict(ArrayList<Event> courses, ArrayList<Integer> hours, ArrayList<Integer> days) {
		System.out.println(hours);
		System.out.println(days);
		for(int j = 0; j<hours.size()-1;j++) {
		
			for(int i = j+1;i<hours.size();i++) {		
				
				if(hours.get(j) == hours.get(i)) {
					for(int x = 0; x<courses.get(j).getDays().length;x++) {
						for(int y = 0; y<courses.get(i).getDays().length;y++) {
							if(courses.get(j).getDays()[x] == courses.get(i).getDays()[y]) {
								return true;
							}
						}
				}
				
			}
		}
			}
		return false;
	}



}

