package no03_parallelworkers.withjoin;

import no03_parallelworkers.simple.Worker;

public class WorkerWithJoin extends Worker {
	public WorkerWithJoin(int number, int totalNumber, long delay) {
		super(number, totalNumber, delay);
	}
	// this is new! holds a reference to the thread it runs in to
	// be able to join it later
	Thread thread;

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	
	public void stop() {
		super.stop();
		try {
			// think about which thread executes this method!
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
