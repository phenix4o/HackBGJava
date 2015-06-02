import java.io.PrintStream;


public class NullKeyException extends IllegalArgumentException {
	private String keyValue="The key must not be null. Please enter correct keyValue";
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return keyValue;
	}
	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}
	
}
