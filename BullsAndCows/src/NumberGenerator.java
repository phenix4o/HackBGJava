import java.util.Random;


public class NumberGenerator {
	private int [] array;
	private static NumberGenerator number;
	private NumberGenerator(){
		array = new int[4];
		for(int i = 0;i<array.length;i++){
			Random random = new Random();
			array[i] = random.nextInt(10);
		}
	}
	public static  NumberGenerator getInstance(){
		if(number == null){
			number = new NumberGenerator();
		}
		return number;
	}
	public int [] getGameArray(){
		return array;
	}
}
