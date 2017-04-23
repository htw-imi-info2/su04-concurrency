package no05_threadsafety;

public class Safe {
	long sum = 0;
	
	class Incrementor implements Runnable {
		int n = 0;
		Object lock;

		Incrementor(int n, Object lock) {
			this.lock = lock;
			this.n = n;
		}

		@Override
		public void run() {
			for (int i = 0; i < n; i++)
				synchronized (lock) {
					sum++;
				}
		}
	}

	class Decrementor implements Runnable {
		int n = 0;
		Object lock;

		Decrementor(int n, Object lock) {
			this.n = n;
			this.lock = lock;
		}

		@Override
		public void run() {
			for (int i = 0; i < n; i++)
				synchronized (lock) {
					sum--;
				}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new Safe().start();
	}

	public void start() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			long startTimeLoop = System.currentTimeMillis();
			sum = 0;
			Object lock = new Object();
			Thread inc = new Thread(new Incrementor(50000, lock));
			Thread dec = new Thread(new Decrementor(40000, lock));
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
