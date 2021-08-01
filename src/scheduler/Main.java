package scheduler;

public class Main {
	public static void main(String[] args) {
		
		int[] times = {0,1,2,3,4};
		TimeHolder[] holders = {new TimeHolder(times), new TimeHolder(times), new TimeHolder(times), new TimeHolder(times), new TimeHolder(times)};
		Event t1 = new Event(holders, "Philosophy");
			
	}

}
