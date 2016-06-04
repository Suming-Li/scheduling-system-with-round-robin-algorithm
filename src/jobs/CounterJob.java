package jobs;

import threads.CPU;

public class CounterJob extends AbstractJob {
	private int counter;
	private int endVal;
	
	public CounterJob(int initVal, int endVal) {
		this.counter = initVal;
		this.endVal = endVal;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	public int getEndVal() {
		return endVal;
	}

	public void setEndVal(int endVal) {
		this.endVal = endVal;
	}
	
	@Override
	/*
	 * Count how many times the job has run
	 * Override function in abstract class "AbstractJob"
	 */
	public void jobRun() {
		 while (this.isSched && counter <= endVal) {
			 System.out.println(CPU.getInstance().getCurrentTask().getName() + " is running...     [ " + counter++ + " time(s) ]");
			 System.out.println("   ");	
			 try {
				 // A new output appears after 2 seconds
				 Thread.sleep(2000); 
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		 }
	}

}
