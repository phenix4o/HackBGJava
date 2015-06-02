import static org.junit.Assert.*;

import org.junit.Test;


public class Testt {

	@Test(expected=UnckeckedRuntimeException.class)
	public void test() {
		UnckeckedRuntimeException.myMethod();
	}

}
