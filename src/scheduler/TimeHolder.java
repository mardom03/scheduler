package scheduler;

public class TimeHolder {
	private int[] timeHolder;
	
	public TimeHolder(int[] times) {
	this.timeHolder = times;
	}
	
	public TimeHolder() {
		this.timeHolder = null;
	}
	
	public int[] getTimes() {
		return timeHolder;
	}
}
