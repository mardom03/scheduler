package scheduler;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] times1 = {0,2,4,5};
		int[] times2 = {2,5,8,9};
		int[] times3 = {5,7,3,6};
		int[] times4 = {2,4,7,9};
		int[] times5 = {1,3,4};
		int[] times6 = {2,6,7,8};
		int[] times7 = {1,5,9};
		int[] times8 = {1,4,6,8};
		int[] times9 = {4,6,7,8,9};
		int[] times10 = {1,2,6,7};
		int[] days1 = {2,3,4};
		int[] days2 = {0,1,2,3,4};
		int[] days3 = {0,2,4};
		int[] days4 = {1,2,3};
		int[] days5 = {0,1,2};
		int[] days6 = {2,3,4};
		int[] days7 = {0,2,4};
		int[] days8 = {0,3};
		int[] days9 = {1,2,4};
		int[] days10 = {0,1,3,4};
		
		Event t1 = new Event(days1,times1, "Philosiphy",3);
		Event t2 = new Event(days2,times2, "Biogoly",5);
		Event t3 = new Event(days3, times3, "Phisics",3);
		Event t4 = new Event(days4, times4, "Chemistree",3);
		Event t5 = new Event(days5, times5, "Computronics",3);
		Event t6 = new Event(days6, times6, "Eckanomics",4);
		Event t7 = new Event(days7, times7, "Memeology",3);
		Event t8 = new Event(days8, times8, "Dirt Sculpting",2);
		Event t9 = new Event(days9, times9, "Basketweaving",3);
		Event t10 = new Event(days10, times10, "Frog Fractions",4);
		
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
			System.out.println("7. Memology");
			System.out.println("8. Dirt Sculpting");
			System.out.println("9. Basketweaving");
			System.out.println("10. Frog Fractions");
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
			case 7:{
				name = ("Memeology");
				tempE = t7;
				break;
			}
			case 8:{
				name = ("Dirt Sculpting");
				tempE = t8;
				break;
			}
			case 9:{
				name = ("Basketweaving");
				tempE = t9;
				break;
			}
			case 10:{
				name = ("Frog Fractions");
				tempE = t10;
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
		int cred = 0;
		for(int i = 0; i< s1.getEvents().size(); i++) {
			cred += s1.getEvents().get(i).getCredits();
		}
		
		s1.genPlans(s1.getEvents().size());
		int index = 0;
		int increment = s1.getSchedules().size()/50;
		if(increment == 0) {
			increment = 1;
		}
		System.out.println(s1.getSchedules().size());
		
		String move = ("");
		Scanner reply2 = new Scanner(System.in);
		while(!move.equals("-1")) {
			System.out.println("Schedule # " + (index/increment+1));
			System.out.println("Credits: " + cred);
			System.out.println(s1.getSchedules().get(index).toString());
			System.out.println("Type N to see next, and L to see last");
			move = reply2.nextLine();
			if(move.equals("N") || move.equals("n")) {
				index = index + increment;
			}
			else if(move.equals("L") || move.equals("l")) {
				index= index - increment;
			}
			if(index>s1.getSchedules().size()-1) {
				index = 0;
			}
			else if(index<0) {
				if(s1.getSchedules().size() >= 50) {
					index = increment*50;
				}
				else {
					index = s1.getSchedules().size()-1;
				}
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


