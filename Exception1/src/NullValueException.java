import java.io.PrintStream;


public class NullValueException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value="The value must not be null. Please enter correct Value";
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return value;
	}
	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}
}
