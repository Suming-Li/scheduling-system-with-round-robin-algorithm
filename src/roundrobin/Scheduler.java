package roundrobin;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import threads.CPU;
import threads.Task;

public class Scheduler {
	private static Scheduler scheduler = new Scheduler();
	
	private Queue<Task> runQueue = new ConcurrentLinkedQueue<Task>();
	private Queue<Task> jobQueue = new ConcurrentLinkedQueue<Task>();
	
	private Scheduler() {
	}
	
	public static Scheduler getInstance() {
		return scheduler;
	}
	
	public void schedule() {
		if (runQueue.isEmpty()) {
			return;
		}
		
		long now = new Date().getTime();
		Task current = CPU.getInstance().getCurrentTask();
		
		if (current == null) {
			Task task = runQueue.poll();
			CPU.getInstance().setCurrentTask(task);
			task.setJustStart(false);
			return;
		}
		
		// Schedule jobs in jobQueue to place them in runQueue if there is a seat available
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!jobQueue.isEmpty()) {
					
					/*
					 * Place a new job in runQueue when only 2 jobs left
					 * Do it when runQueue.size() < 2, because the currently running job is temporarily not in runQueue  
					 */
					if (runQueue.size() < 2) {
						Task task = jobQueue.poll();
						if (task != null) {
							runQueue.offer(task);
						}
					}
				}
			}
		}).start();
		
		
		// Schedule jobs in runQueue based on quantum
		if (now - current.getStartExec() >= CPU.DEFAULT_TIME_SLICE) {
			if (runQueue.isEmpty()) {
				// Keep current job running until it completes
				return;
			}
			
			// If runQueue is not empty, schedule a job in runQueue to run and put the current job back to runQueue
			Task task = runQueue.poll();
			CPU.getInstance().switchOutTask();
			task.setJustStart(false);
			CPU.getInstance().switchInTask(task);
			runQueue.offer(current);
		}   	
	}
	
	
	/* 
	 * Each time when a new job is created, the scheduling system should judge in which queue the new job should be put.
	 * Always put a new job in jobQueue when there are already 3 jobs in runQueue.
	 * Do it when runQueue.size() >= 2, because the currently running job is temporarily not in runQueue
	 */
	public void addTask(Task t) {
		if (runQueue.size() >= 2) {
			jobQueue.offer(t);
		} else {
			runQueue.offer(t);
		}
	}
	
	public void addTask(Task t) {
		if (runQueue.size() >= 2) {
			jobQueue.offer(t);
		} else {
			runQueue.offer(t);
		}
	}
	
}
