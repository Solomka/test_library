package vo;

public enum Role {
	STUDENT(5), LIBRARIAN(6);
	int value;

	private Role(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
