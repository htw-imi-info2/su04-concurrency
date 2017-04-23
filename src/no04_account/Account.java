package no04_account;

/**
 * unsynchronized version of account - will lead to inconsistent 
 * amounts if methods are called
 * from different threads.
 * @author kleinen
 *
 */
public class Account {
	private long amount = 0;

	public Account() {
	}

	public long getAmount() {
		return amount;
	}

	public void increase() {
		amount++;
	}

	public void decrease() {
		amount--;
	}

}
