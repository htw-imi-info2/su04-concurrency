package no06_lambda;

public class ThreadWithLambda {
	public static void main(String args[]) throws InterruptedException {
		Thread t = new Thread(() -> {
			while (true)
				System.out.println("running....");
		});
		t.start();
		Thread.currentThread().sleep(2000);
		t.stop();
	}
}
