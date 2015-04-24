package no02_parallelworkers.withjoin;

import no02_parallelworkers.Start;
import no02_parallelworkers.Worker;

public class StartWithJoin extends Start {
	public static void main(String[] args) {
		new StartWithJoin().doIt(args);
	}

	public Worker buildAndStartNewWorker(int number, int numberOfWorkers,
			int delay) {
		WorkerWithJoin worker = new WorkerWithJoin(number, numberOfWorkers,
				delay);
		worker.setThread(new Thread(worker));
		worker.getThread().start();
		return worker;
	}
}
