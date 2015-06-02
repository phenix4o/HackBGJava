@FunctionalInterface
interface Action{
	public void print();
}
public class Java8Problems {
	public static void main(String... args){
	
		Action c = ()->System.out.println("bla");
		c.print();
	}
}
