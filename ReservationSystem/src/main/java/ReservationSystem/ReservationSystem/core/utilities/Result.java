package ReservationSystem.ReservationSystem.core.utilities;

public class Result {

	private boolean success;
	private String resultMessage;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String resultMessage) {
		this(success);
		this.resultMessage = resultMessage;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public String getResultMessage() {
		return this.resultMessage;
	}

}
