package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

import roundrobin.Scheduler;

public class Timer implements Runnable {
	public Timer() {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
		// Set a fixed time as a quantum
		executor.scheduleAtFixedRate(this, 0, 8000, TimeUnit.MILLISECONDS);
	}

	@Override
	public void run() {
		Scheduler.getInstance().schedule();
	}
	
}
