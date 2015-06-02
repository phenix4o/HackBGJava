package week5Annotations;

public class TestIt {
	private static Test test;
	public static boolean testClass(Test test){
		//this.test = test;
		int i = test.getClass().getAnnotations().length;
		return false;
	}
	public static void main(String... args){
		Test t = new Test();
		System.out.println( t.getClass().getAnnotations().length);
	}
}
