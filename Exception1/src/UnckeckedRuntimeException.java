
public class UnckeckedRuntimeException extends RuntimeException{
	public UnckeckedRuntimeException(String m){
		super(m);
	}
	public static void main(String... args){
		try{
			throw new UnckeckedRuntimeException("UncheckedException");
		}catch(UnckeckedRuntimeException e){
			System.out.println(e.getMessage());
		}
	}
	public static void myMethod() {
		// TODO Auto-generated method stub
		throw new UnckeckedRuntimeException("MyException");
	}
}
