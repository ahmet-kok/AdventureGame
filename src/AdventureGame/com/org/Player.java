package AdventureGame.com.org;

public class Player {
	Inventory inventory = new Inventory();
	int damage;
	int healthy;
	int money;
	String name;
	int location = 0;
	
	public void selectChar() {
		System.out.print("Merhaba " + Main.playerName + " hadi karakterini seç." + "\n"
				+ "1 - Samuray - damage = 5, healthy = 21, money = 15" + "\n"
				+ "2 - Okçu - damage = 7, healthy = 18, money = 20\"" + "\n"
				+ "3 - Şövalye - damage = 8, healthy = 24, money = 5\"" + "\n"
				+ "Seçimin: "
				);
		Main.choice = Main.input.nextInt();
		
		switch(Main.choice) {
			case 1:
				damage = 5;
				healthy = 21;
				money = 15;
				name = "Samuray";
				break;
			case 2:
				damage = 7;
				healthy = 18;
				money = 20;
				name = "Okçu";
				break;
			case 3:
				damage = 8;
				healthy = 24;
				money = 5;
				name = "Şövalye";
				break;
			default:
				damage = 5;
				healthy = 21;
				money = 15;
				name = "Samuray";
				break;
		}
		
	}

	@Override
	public String toString() {
		return Main.playerName + ": [Hasar=" + damage + ", Sağlık=" + healthy + ", Para=" + money
				+ ", Konum=" + location + ", Zırh:" + inventory.armorName + ", Zırh durumu:" + inventory.armorDefence + ", Silahı:" + inventory.weaponName + ", Silah gücü:" + inventory.weaponDamage + ", Su:" + inventory.water + ", Ekmek:" + inventory.food + ", Odun:" + inventory.firewoord+ "]";
	}

}
