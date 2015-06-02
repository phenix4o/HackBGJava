import java.util.ArrayList;
import java.util.List;

public class GameLogic {
	private static GameLogic game;
	private int cows, bulls;
	public static String number;
	private GameLogic() {

	}

	public static GameLogic getInstance() {
		if (game == null) {
			game = new GameLogic();
		}
		return game;
	}

	public List<Integer> compare(int[] gameArray, String input) {
		int[] playerArray = new int[4];
		List<Integer> result = new ArrayList<Integer>();
		String[] split = input.split(" ");
		cows = 0;
		bulls = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < playerArray.length; i++) {
			
			sb.append(gameArray[i]);
	
			if(number==null&&i==3){
				number = sb.toString();
				//System.out.println(number);
			}
			playerArray[i] = Integer.parseInt(split[i]);
			if (playerArray[i] == gameArray[i]) {
				bulls++;
			}
			else if(input.contains(String.valueOf(gameArray[i]))){
				cows++;
			}
		}
		result.add(bulls);
		result.add(cows);
		
		return result;

	}

}
