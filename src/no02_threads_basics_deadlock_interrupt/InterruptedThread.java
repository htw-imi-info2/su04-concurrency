package no02_threads_basics_deadlock_interrupt;

/**
 * This is an example of how another thread can be interrupted and catch the
 * Interrupted Exception.
 * 
 * @author Barne Kleinen
 *
 */
public class InterruptedThread {

	public void startThread() throws InterruptedException {
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				System.out.println("runner: I'm running!");
				try {
					int count = 0;
					while (true) {
						 if ((count++ % 100) == 0)
						System.out.println("runner: I'm still running!");
						Thread.yield();
						Thread.sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.println("runner: Ouch! I have been interrupted!");
				}
			}
		};
		Thread runnerThread = new Thread(runner);
		runnerThread.start();
		System.out.println("Main Thread yielding");
		Thread.yield();
		System.out.println("Main Thread about to sleep");
		Thread.yield();Thread.sleep(3 * 1000);
		System.out.println("Main Thread about to sleep");
		Thread.yield();Thread.sleep(3 * 1000);
		runnerThread.interrupt();
		System.out.println("Main Thread interrupted the runner.");
	}

	public static void main(String[] args) throws InterruptedException {
		(new InterruptedThread()).startThread();
	}
}
