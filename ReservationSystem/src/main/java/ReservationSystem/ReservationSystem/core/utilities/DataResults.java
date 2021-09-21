package ReservationSystem.ReservationSystem.core.utilities;

public class DataResults<T> extends Result {

	private T data;

	public DataResults(T data, boolean success, String resultMessage) {
		super(success, resultMessage);
		this.data = data;

	}

	public DataResults(T data, boolean success) {
		super(success);
		this.data = data;

	}

	public T getData() {
		return this.data;
	}

}
