package no04_;

public class SynchronizedAccount {
	private long amount = 0;

	public SynchronizedAccount() {
	}

	public long getAmount() {
		return amount;
	}

	public synchronized void increase() {
		amount++;
	}

	public synchronized void decrease() {
		amount--;
	}

}
