package no03_parallelworkers.withjoin;

import no03_parallelworkers.simple.Start;
import no03_parallelworkers.simple.Worker;

/**
 * 
 * @author kleinen
 *
 */
public class StartWithJoin extends Start {
	
	public static void main(String[] args) {
		new StartWithJoin().doIt(args);
	}
	
	@Override
	public Worker buildAndStartNewWorker(int number, int numberOfWorkers,
			int delay) {
		WorkerWithJoin worker = new WorkerWithJoin(number, numberOfWorkers,
				delay);
		worker.setThread(new Thread(worker));
		worker.getThread().start();
		return worker;
	}
}
