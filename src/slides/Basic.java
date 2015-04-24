package slides;

public class Basic {

	public void startThread() throws InterruptedException {
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("running!");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					System.out.println("Interrupted!");
				}
			}
		};
		Thread runnerThread = new Thread(runner);
		runnerThread.start();
		Thread.sleep(10000);
		runnerThread.interrupt();
		System.out.println("Done!");
	}
	public static void main(String[] args) throws InterruptedException{
		(new Basic()).startThread();
	}
}
