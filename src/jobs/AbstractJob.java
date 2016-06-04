package jobs;

import roundrobin.Scheduler;
import threads.CPU;

public abstract class AbstractJob {
	protected boolean isSched;

	public void contextSwitchIn() {
		isSched = true;
	}
	
	public void contextSwitchOut() {
		isSched = false;
	}

	public void run() {
		jobRun();
		
		if (isSched) {
			CPU.getInstance().setCurrentTask(null);
			Scheduler.getInstance().schedule();
		}
		
	}
	
	public abstract void jobRun();
}
