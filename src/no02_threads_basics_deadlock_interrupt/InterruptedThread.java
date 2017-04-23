package no02_threads_basics_deadlock_interrupt;
/**
 * This is an example of how another thread can be interrupted and catch the Interrupted Exception.
 * @author Barne Kleinen
 *
 */
public class InterruptedThread {

	public void startThread() throws InterruptedException {
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("runner: I'm still running!");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					System.out.println("runner: Ouch! I have been interrupted!");
				}
			}
		};
		Thread runnerThread = new Thread(runner);
		runnerThread.start();
		Thread.sleep(10000);
		runnerThread.interrupt();
		System.out.println("Main Thread interrupted the runner.");
	}
	public static void main(String[] args) throws InterruptedException{
		(new InterruptedThread()).startThread();
	}
}
