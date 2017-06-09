package vo;


public enum OrderStatus {

	EXECUTED(3), UNEXECUTED(4);
	int value;

	private OrderStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
