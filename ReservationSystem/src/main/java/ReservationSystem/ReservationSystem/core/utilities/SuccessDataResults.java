package ReservationSystem.ReservationSystem.core.utilities;

public class SuccessDataResults<T> extends DataResults<T> {

	public SuccessDataResults(T data, String resultMessage) {
		super(data, true, resultMessage);

	}

	public SuccessDataResults(T data) {
		super(data, true);

	}

	public SuccessDataResults(String message) {
		super(null, true, message);

	}

	public SuccessDataResults() {
		super(null, true);

	}

}
