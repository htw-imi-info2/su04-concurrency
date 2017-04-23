package no04_account;

/**
 * Example of synchronizing the access to the Account methods via an explicit 
 * lock object. In practice, if your Account will always be used in a context
 * where synchronization is needed, you would probably use a solution as shown
 * in SynchronizedAccount.
 * @author kleinen
 *
 */
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

	public static void main(String[] args) {
		new Safe().start();
	}

	public void start() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			sum = 0;
			Object lock = new Object();
			Thread inc = new Thread(new Incrementor(8000, lock));
			Thread dec = new Thread(new Decrementor(3000, lock));
			inc.start();
			dec.start();
			
			try {
				inc.join();
				dec.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("sum: " + sum);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("" + (endTime - startTime) + "ms");
	}

}
