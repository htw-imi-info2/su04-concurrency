package no06_lambda;

public class ThreadWithLambda {
	static boolean shouldRun = true;
	public static void main(String args[]) throws InterruptedException {
		Thread t = new Thread(() -> {
			while (shouldRun)
				System.out.println("running....");
			System.out.println("Done.");
		});
		t.start();
		Thread.sleep(2000);
		shouldRun = false;
	}
}
