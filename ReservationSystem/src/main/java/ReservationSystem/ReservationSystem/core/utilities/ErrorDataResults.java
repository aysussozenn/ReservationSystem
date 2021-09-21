package ReservationSystem.ReservationSystem.core.utilities;

public class ErrorDataResults<T> extends DataResults<T> {

	public ErrorDataResults(T data, String resultMessage) {
		super(data, false, resultMessage);
		
	}
	
	public ErrorDataResults(T data) {
		super(data, false);
		
	}
	
	public ErrorDataResults(String message) {
		super(null, false,message);
		
	}
	public ErrorDataResults() {
		super(null, false);
		
	}
}
