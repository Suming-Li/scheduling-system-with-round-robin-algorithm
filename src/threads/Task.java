package threads;

import roundrobin.Scheduler;
import jobs.CounterJob;


public class Task implements Runnable {	
	public static final int TASK_RUNNING = 1;
	private boolean justStart = true;
	private long startExec;
	private int status = TASK_RUNNING;
	private String name;
	private CounterJob job;
		
	public Task(String name, CounterJob job) {
		this.name = name;
		this.job = job;
		Scheduler.getInstance().addTask(this);
	}
	
	public long getStartExec() {
		return startExec;
	}

	public void setStartExec(long startExec) {
		this.startExec = startExec;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
	public CounterJob getJob() {
		return job;
	}

	public void setJob(CounterJob job) {
		this.job = job;
	}
	


	public boolean isJustStart() {
		return justStart;
	}

	public void setJustStart(boolean justStart) {
		this.justStart = justStart;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void run() {
		if (!justStart) {
			job.contextSwitchIn();
		}
		
		job.run();
	}
	
}