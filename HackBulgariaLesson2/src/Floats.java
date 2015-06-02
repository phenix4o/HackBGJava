
public class Floats {
	
	public static void main(String... args){
		System.out.println(roundDoubleValue(0.6566275f, 2));
	}
	
	public static float roundDoubleValue(float value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (float) tmp / factor;
	} 
}
