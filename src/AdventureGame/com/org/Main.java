package AdventureGame.com.org;
import java.util.Scanner;

public class Main {
	public static String playerName;
	public static Scanner input = new Scanner(System.in);
	public static int choice;
	public static int number = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.start();
		while (Game.player.healthy > 0) {
			Game.location();
			
		}
		
	}

}
