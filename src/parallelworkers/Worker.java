package parallelworkers;

public class Worker implements Runnable {
	int number, remainderBars;
	boolean shouldRun = true;
	long delay = 1000;
	long counter = 0;

	public Worker(int number, int totalNumber, long delay) {
		this.number = number;
		this.delay = delay;
		this.remainderBars = totalNumber - number;
	}

	public void stop() {
		shouldRun = false;
	}

	public String nSpaces(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += " | ";
		}
		return result;
	}

	@Override
	public void run() {
		while (shouldRun) {
			counter++;
			System.out.println(nSpaces(number - 1) + " " + number + " "
					+ nSpaces(remainderBars));
		}
	}

	@Override
	public String toString() {
		return "#" + number + " (" + counter + ")";
	}

	public int getNumber() {
		return number;
	}

	public long getCounter() {
		return counter;
	}
}
