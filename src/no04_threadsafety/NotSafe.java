package no04_threadsafety;

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

	public static void main(String[] args) {
		new NotSafe().start();
	}

	public void start() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			sum = 0;
			Thread inc = new Thread(new Incrementor(5000));
			Thread dec = new Thread(new Decrementor(4000));
			inc.start();
			dec.start();
			System.out.println("sum: " + sum);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("" + (endTime - startTime) + "ms");
	}

}
