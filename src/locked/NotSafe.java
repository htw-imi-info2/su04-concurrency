package locked;

public class NotSafe {

	public static void main(String[] args) throws InterruptedException {
		new NotSafe().start();
	}

	public void start() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		long plus = 8000, minus = 3000;
		for (int i = 0; i < 100; i++) {
			Account account = new Account();
			//SynchronizedAccount account = new SynchronizedAccount();
			Thread inc = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < plus; i++)
						account.increase();
				}
			});
			Thread dec = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < minus; i++)
						account.decrease();
				}
			});
			inc.start();
			dec.start();
			inc.join();
			dec.join();
			System.out.println("amount: " + account.getAmount());
		}
		long endTime = System.currentTimeMillis();
		System.out.println("" + (endTime - startTime) + "ms");
	}
}
