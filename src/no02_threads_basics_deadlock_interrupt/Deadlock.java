package no02_threads_basics_deadlock_interrupt;

/**
 * Simple example of a Deadlock.
 *
 */
public class Deadlock {
	Object lock1 = new Object();
	Object lock2 = new Object();

	public Deadlock() {

	}

	public void startThreads() throws InterruptedException {
		Runnable runner1 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (lock1) {
						System.out.println("runner1 got lock1!");

						Thread.sleep(100);
						synchronized (lock2) {
							System.out.println("runner1 got lock2!");
							while (true) {
								System.out.println("runner 1 running!");
								Thread.sleep(1000);
							}
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Interrupted!");
				}
			}
		};
		Runnable runner2 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (lock2) {
						System.out.println("runner2 got lock2!");
						Thread.sleep(100);
						synchronized (lock1) {
							System.out.println("runner2 got lock1!");
							while (true) {
								System.out.println("runner 2 running!");
								Thread.sleep(1000);
							}
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Interrupted!");
				}
			}
		};
		Thread runnerThread1 = new Thread(runner1,"Runner 1");
		Thread runnerThread2 = new Thread(runner2,"Runner 2");
		runnerThread1.start();
		runnerThread2.start();
		Thread.yield();
		for (int i = 0; i < 10; i++) {
			System.out.println("State 1: " + runnerThread1.getState());
			System.out.println("State 2: " + runnerThread2.getState());
			Thread.sleep(1000);
		}
		//System.out.println("Stopping Thread 1");
		//runnerThread1.stop();
		Thread.sleep(2000);
		//runnerThread1.join();
		//runnerThread2.join();
		System.out.println("Done! - Main Thread will be terminated.");
	}

	public static void main(String[] args) throws InterruptedException {
		(new Deadlock()).startThreads();
	}
}
