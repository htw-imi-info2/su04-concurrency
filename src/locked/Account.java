package locked;

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
