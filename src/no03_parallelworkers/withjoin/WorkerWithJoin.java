package no03_parallelworkers.withjoin;

import no03_parallelworkers.Worker;

public class WorkerWithJoin extends Worker {
	public WorkerWithJoin(int number, int totalNumber, long delay) {
		super(number, totalNumber, delay);
	}

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
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
