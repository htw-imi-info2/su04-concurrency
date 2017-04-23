package no05_threadsafety;

public class NotSafe {
	long sum = 0;

	class Incrementor implements Runnable {
		int n = 0;

		Incrementor(int n) {
			this.n = n;
		}

		@Override
		public void run() {
			for (int i = 0; i < n; i++)
				sum++;
		}
	}

	class Decrementor implements Runnable {
		int n = 0;

		Decrementor(int n) {
			this.n = n;
		}

		@Override
		public void run() {
			for (int i = 0; i < n; i++)
				sum--;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new NotSafe().start();
	}

	public void start() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			long startTimeLoop = System.currentTimeMillis();
			sum = 0;
			Thread inc = new Thread(new Incrementor(50000));
			Thread dec = new Thread(new Decrementor(40000));
			inc.start();
			dec.start();
			inc.join();
			dec.join();
			long endTimeLoop = System.currentTimeMillis();
			System.out.println("sum: " + sum +" time: "+ (endTimeLoop - startTimeLoop) + " ms");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("" + (endTime - startTime) + "ms");
	}

}
