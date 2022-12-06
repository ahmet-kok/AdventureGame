package AdventureGame.com.org;

public class Inventory {
	public boolean water = false;
	public boolean food = false;
	public boolean firewoord = false;
	public String weaponName;
	public String armorName;
	public int weaponDamage = 0;
	public int armorDefence = 0;
	
	public void use(int i) {
		switch(i) {
			case 1: 
				if (Game.player.inventory.food == false)
					break;
				Game.player.inventory.food = false;
				Game.player.healthy += 4;
				break;
			case 2:
				if (Game.player.inventory.water == false)
					break;
				Game.player.inventory.water = false;
				Game.player.healthy += 2;
				break;
			case 3:
				if (Game.player.inventory.firewoord == false)
					break;
				Game.player.inventory.firewoord = false;
				Game.player.healthy += 1;
				break;
			default:
				break;
		}
	}
}
