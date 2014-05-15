package parallelworkers.withjoin;

import parallelworkers.Start;
import parallelworkers.Worker;

public class StartWithJoin extends Start {
	public static void main(String[] args) {
		new StartWithJoin().doIt(args);
	}

	public Worker buildAndStartNewWorker(int number, int numberOfWorkers,
			int delay) {
		WorkerWithThread worker = new WorkerWithThread(number, numberOfWorkers,
				delay);
		worker.setThread(new Thread(worker));
		worker.getThread().start();
		return worker;
	}
}
