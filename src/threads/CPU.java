package threads;

import java.util.Date;

public class CPU implements Runnable {
	public static int DEFAULT_TIME_SLICE = 8;
	
	private static CPU cpu = new CPU();
	private boolean isRunning;
	private Task currentTask;
	private Thread thread;
	
	private CPU() {
		thread = new Thread(this);
	}
	
	public static CPU getInstance() {
		return cpu;
	}
	
	@Override
	public void run() {
		System.out.println("The CPU scheduler is working...");	
		System.out.println("   ");	
		
		while(isRunning) {
			if(currentTask != null) {
				long ts = new Date().getTime();
				currentTask.setStartExec(ts);
				currentTask.run();	
			} else {
				try {
					Thread.sleep(1);	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}	
	}

	public void start() {
		thread.start();
		isRunning = true;
	}
	
	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}
	
	public void switchInTask(Task task) {
		currentTask = task;
	}
	
	public void switchOutTask() {
		currentTask.getJob().contextSwitchOut();
		currentTask = null;
	}
	
}
