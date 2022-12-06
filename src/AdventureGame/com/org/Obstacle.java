package AdventureGame.com.org;

public class Obstacle {
	int damage;
	int healthy;
	String name;
	int number;
	
	public Obstacle(int damage, int healthy, String name, int number) {
		this.damage = damage;
		this.healthy = healthy;
		this.name = name;
		this.number = number;
		
	}
	public int obstacleNumber() {
		return number;
	}
}
