
public class Exceptionhelp {
	public static void main(String ... args){
		
		try{
			throw new Error("My error");
		}catch(Throwable e){
			System.out.println(e.getMessage());
		}finally{
		
		}
	}
}
