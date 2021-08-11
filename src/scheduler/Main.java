package scheduler;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] times1 = {0,2};
		int[] times2 = {2,5};
		int[] times3 = {5,7};
		int[] times4 = {2,4};
		int[] times5 = {1};
		int[] times6 = {2,6};
		int[] days1 = {2,3,4};
		int[] days2 = {0,1,2,3,4};
		int[] days3 = {0,2,4};
		int[] days4 = {1,2,3};
		int[] days5 = {0,1,2,3};
		int[] days6 = {2,3,4};
		
		Event t1 = new Event(days1,times1, "Philosiphy",3);
		Event t2 = new Event(days2,times2, "Biogoly",5);
		Event t3 = new Event(days3, times3, "Phisics",3);
		Event t4 = new Event(days4, times4, "Chemistree",3);
		Event t5 = new Event(days5, times5, "Computronic Psyence",3);
		Event t6 = new Event(days6, times6, "Eckanomics",4);
		
		ArrayList<Event> courses = new ArrayList<Event>();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		ArrayList<Integer> days = new ArrayList<Integer>();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		Scheduler s1 = new Scheduler(courses,days,hours,schedules);
		
		int ans = 0;
		Scanner reply = new Scanner(System.in);
		while(ans != -1) {
			Event tempE = null;
			int counter = 0;
			String name = ("");
			System.out.println("1. Philosiphy");
			System.out.println("2. Biogoly");
			System.out.println("3. Phisics");
			System.out.println("4. Chemistree");
			System.out.println("5. Computronic Psyence");
			System.out.println("6. Eckanomics");
			System.out.println("Please choose your classes (-1 to receive schedules).");
			ans = reply.nextInt();
			switch(ans) {
			case 1:
			{
				name = ("Philosiphy");
				tempE = t1;
				break;
			}
			case 2:{
				name = ("Biogoly");
				tempE = t2;
				break;
			}
			case 3:{
				name = ("Phisics");
				tempE = t3;
				break;
			}
			case 4:{
				name = ("Chemistree");
				tempE = t4;
				break;
			}
			case 5:{
				name = ("Computronic Psyence");
				tempE = t5;
				break;
			}
			case 6:{
				name = ("Eckanomics");
				tempE = t6;
				break;
			}
			default:{
				break;
			}
			}
			if(name.equals("")) {
				continue;
			}
			
			for(int j = 0; j<s1.getEvents().size();j++) {
				if(s1.getEvents().get(j).toString().equals(name)) {
					break;
					}
				counter++;
			}
			if(counter == s1.getEvents().size()) {
					s1.getEvents().add(tempE);
				}
			}
		
		
		if(s1.getEvents().size() == 0) {
			System.exit(0);
		}
		
		s1.genPlans(s1.getEvents().size());
		int index = 1;
		int increment = s1.getSchedules().size()/50;
		if(increment == 0) {
			increment = 1;
		}
		System.out.println(s1.getSchedules().size());
		
		String move = ("");
		Scanner reply2 = new Scanner(System.in);
		while(!move.equals("-1")) {
			System.out.println(s1.getSchedules().get(index).getHours());
			System.out.println("Type N to see next, and L to see last");
			move = reply2.nextLine();
			if(move.equals("N") || move.equals("n")) {
				index+=increment;
			}
			else if(move.equals("B") || move.equals("b")) {
				index-=increment;
			}
			if(index>s1.getSchedules().size()) {
				index = 0;
			}
			else if(index<0) {
				index = increment*50;
			}
		}
			
					
			
			
			
			
				
				
			
			
			
				
				
				
				
			}
			
		
		
		
		/***
		ArrayList<Event> e = new ArrayList<Event>();
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		e.add(t1); e.add(t2); e.add(t3);
		h.add(2); h.add(6); h.add(9);
		d.add(2); d.add(1); d.add(4);
		Schedule s1 = new Schedule(e, h, d);
		System.out.println(s1);
		**/
	
	
	 
		
	}


