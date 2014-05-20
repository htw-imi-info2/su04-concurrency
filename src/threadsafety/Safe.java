package threadsafety;

public class Safe {
	long sum = 0;
	Object justAnyObjectToSynchronizeOn = new Object();

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

	public static void main(String[] args) {
		new Safe().start();
	}

	public void start() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			sum = 0;
			Object lock = this;
			Thread inc = new Thread(new Incrementor(5000, lock));
			Thread dec = new Thread(new Decrementor(4000, lock));
			inc.start();
			dec.start();
			System.out.println("sum: " + sum);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("" + (endTime - startTime) + "ms");
	}

}
