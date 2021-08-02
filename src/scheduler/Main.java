package scheduler;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		int[] times1 = {0,1};
		int[] times2 = {2,5};
		int[] times3 = {5,7};
		int[] times4 = {2,4};
		int[] times5 = {5,9};
		TimeHolder[] holders = {new TimeHolder(times1), new TimeHolder(times2), new TimeHolder(times3), new TimeHolder(times4), new TimeHolder(times5)};
		Event t1 = new Event(holders, "Philosiphy");
		Event t2 = new Event(holders, "Biogoly");
		Event t3 = new Event(holders, "Phisics");
			
		ArrayList<Event> e = new ArrayList<Event>();
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		e.add(t1); e.add(t2); e.add(t3);
		h.add(2); h.add(6); h.add(9);
		d.add(2); d.add(1); d.add(4);
		Schedule s1 = new Schedule(e, h, d);
		System.out.println(s1);
	}

}
