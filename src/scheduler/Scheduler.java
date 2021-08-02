package scheduler;
import java.util.ArrayList;
import java.util.Scanner;

public class Scheduler {
	private ArrayList<Schedule> schedules;
	private ArrayList<Integer> hours;
	private ArrayList<Event> classes;
	private ArrayList<Integer> day;
	private int eventAmt;

	public Scheduler(ArrayList<Event> classes) {
		this.classes = classes;
		this.eventAmt = classes.size();

	}
	
	public void run() {
		String input = "";
		Scanner scan = new Scanner(System.in);
		int poss = findPossibilities();
		int div = poss/50;
		int current = 0;
		
		genPlans(this.eventAmt);
		
		System.out.println(this.schedules.get(current));
		System.out.println("Press enter for next schedule, type b for back, exit to exit");
		while(true){
			input = scan.nextLine();
			if(input.equals("")) {
				current = Math.abs((current+div)%poss);
				System.out.println("Schedule " + (current/(div%poss))+1 + "\n" + this.schedules.get(current));
			}
			else if(input.equals("b")) {
				current = Math.abs((current-div)%poss);
				System.out.println("Schedule " + (current/(div%poss))+1 + "\n" + this.schedules.get(current));
			}
			else if(input.equals("exit")) {
				break;
			}
			else {
				System.out.println("That is not a valid input");
			}
			
		}
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
