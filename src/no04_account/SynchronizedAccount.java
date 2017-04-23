package no04_account;

/**
 * By using the synchronized keyword on the methods, access to these
 * methods will be synchronized using the instance as the lock 
 * object. Note that while this is a simple and working solution,
 * it might not be effective if you usually use the Account class
 * in a context where no synchronization is needed.
 * 
 * (This is the reason the new Java Collection classes are *not*
 * synchronized; e.g. see the "Note that this implementation is not synchronized."
 * in the JavaDoc of ArrayList.)
 * 
 * @author kleinen
 *
 */
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
