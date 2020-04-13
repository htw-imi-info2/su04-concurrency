package no03_parallelworkers;

import no03_parallelworkers.withjoin.WorkerWithJoin;

import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		new Start().doIt(args);
	}

	public void doIt(String[] args) {
		int numberOfWorkers = (args.length > 0) ? Integer.valueOf(args[0]) : 6;
		int delay = 2000;
		List<Worker> workers = new ArrayList<>();
		for (int i = 0; i < numberOfWorkers; i++) {
			workers.add(buildAndStartNewWorker(i + 1, numberOfWorkers, delay));
		}
		try {
			Thread.sleep(60*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopAndPrintStatistics(workers);
		System.out.println("Main Thread Terminated.");
		// this is the effective end of the program, note that is will end all 
		// child threads. To see how to wait for them, look in no03_parallelworkers.withjoin
	}

	public Worker buildAndStartNewWorker(int number, int numberOfWorkers,
			int delay) {
		Worker worker = new WorkerWithJoin(number, numberOfWorkers, delay);
		new Thread(worker).start();
		return worker;
	}

	private void stopAndPrintStatistics(List<Worker> workers) {
		for (Worker worker : workers) {
			worker.stop();
		}
		for (Worker worker : workers) {
			System.out.println("Worker #" + worker.getNumber() + " ran "
					+ worker.getCounter() + " times.");
		}
	}

}
