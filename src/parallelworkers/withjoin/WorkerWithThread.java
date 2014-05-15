package parallelworkers.withjoin;

import parallelworkers.Worker;

public class WorkerWithThread extends Worker {
	public WorkerWithThread(int number, int totalNumber, long delay) {
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
