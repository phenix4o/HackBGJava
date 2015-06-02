public class ServiceNotAvailableException extends Exception {
	String message;

	public ServiceNotAvailableException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	

}