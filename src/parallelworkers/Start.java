package parallelworkers;

import java.util.ArrayList;
import java.util.List;

public class Start {

	public Start() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int numberOfWorkers = (args.length > 0) ? Integer.valueOf(args[0]) : 6;
		int delay = 2000;
		List<Worker> workers = new ArrayList<>();
		for (int i = 0; i < numberOfWorkers; i++) {
			Worker worker = new Worker(i+1, numberOfWorkers, delay);
			new Thread(worker).start();
			workers.add(worker);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopAndPrintStatistics(workers);
		System.out.println("Main Thread Terminated.");
	}

	private static void stopAndPrintStatistics(List<Worker> workers) {
		for (Worker worker : workers) {
			worker.stop();

		}
		for (Worker worker : workers) {
			System.out.println("Worker #" + worker.getNumber() + " ran "
					+ worker.getCounter() + " times.");

		}
	}

}
