import java.util.Scanner;


public class BullsAndCowsTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		World world = new World(input);
		world.startGameLoop();
		if(world.flag==false){
			input.close();
		}
	}

}
