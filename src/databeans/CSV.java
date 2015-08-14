package databeans;

public class CSV {

	private String path;
	private long amount;

	/**
	 * @param path
	 * @param amount
	 */
	public CSV(String path, long amount) {
		super();
		this.path = path;
		this.amount = amount;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "csv [path=" + path + ", amount=" + amount + "]";
	}

}
