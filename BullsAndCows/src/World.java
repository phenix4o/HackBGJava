import java.util.List;
import java.util.Scanner;

public class World {
	private Scanner input;
	public static boolean flag = true;
	private static int score = 20;

	public static void setFlag(boolean flag) {
		World.flag = false;
		HighScoreManager hm = new HighScoreManager();
		Scanner scan = new Scanner(System.in);
		System.out.println("\nCongratulations! You win!");
		System.out.print("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println();

		hm.addScore(name, score);
		System.out.println(hm.getHighscoreString());
		System.out.println("Please press enter to exit");
		
		
	}

	final static String welcome = "==========Welcome to Bulls and Cows==========\n\n==========To exit the Game enter'*'==========\n\nPlease enter your guess with spaces like 1 2 3 4\n";

	public World(Scanner input) {
		this.input = new Scanner(System.in);

	}

	public void startGameLoop() {

		System.out.println(welcome);
		String word;
		Entity entity = new Entity();

		while (!(word = input.nextLine()).equals("*") && flag) {
			entity.update(word);
			score--;
			if (score == -1) {
				flag = false;
				System.out.println("\n\nGame over ;(");
				System.out.println(GameLogic.number);
			}
		}
	}

	public static void update(List<Integer> list) {
		System.out.println("cows: " + list.get(1) + " bulls: " + list.get(0)
				+ " score: " + score);
	}

}
