package parallelworkers;

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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopAndPrintStatistics(workers);
		System.out.println("Main Thread Terminated.");
	}

	public Worker buildAndStartNewWorker(int number, int numberOfWorkers,
			int delay) {
		Worker worker = new Worker(number, numberOfWorkers, delay);
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