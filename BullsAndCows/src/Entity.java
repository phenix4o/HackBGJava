import java.util.ArrayList;
import java.util.List;


public class Entity {
	private static int[] gameArray;
	public Entity(){
		
	}
	public static void update(String number){
		NumberGenerator generate = NumberGenerator.getInstance();
		GameLogic gm = GameLogic.getInstance();
		if(gameArray==null){
			gameArray = generate.getGameArray();
		}
		List<Integer>result = new ArrayList<Integer>();
		result = gm.compare(gameArray, number);
		if(result.get(0)==4){
			World.setFlag(false);
		}
		else{
			World.update(result);
		}
		
		
	}
}
