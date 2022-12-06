package AdventureGame.com.org;

public class ToolStore extends NormalLoc{

	
	@Override
	public boolean onLocation() {
		if (player.location == 1)
			return true;
		return false;
	}
	public static void products() {
		System.out.println("1 - Silahlar \n2 - Zırhlar\n3 - Çıkış");
		Main.choice = Main.input.nextInt();
		System.out.println(Game.player.money + " liran var.");
		switch(Main.choice) {
			case 1:
				System.out.println("Silah \t Hasar \t Para" + "\n"
						+ "1 - Tabanca \t 2 \t 25" + "\n"
						+ "2 - Kılıç \t 3 \t 35" + "\n"
						+ "3 - Tüfek \t 7 \t 45" + "\n"
						+ "4 - Çıkış");
				Main.choice = Main.input.nextInt() - 1;
				if(Main.choice == 3)
					return;
				buy(Main.choice, 1);
				break;
			case 2:
				System.out.println("Zırh \t Engelleme \t Para" + "\n"
						+ "1 - Hafif \t 1 \t 15" + "\n"
						+ "2 - Orta \t 3 \t 25" + "\n"
						+ "3 - Ağır \t 5 \t 40" + "\n"
						+ "4 - Çıkış");
				Main.choice = Main.input.nextInt() - 1;
				if(Main.choice == 3)
					return;
				buy(Main.choice, 2);
				break;
			default:
				return;
		}
		System.out.println("Tamam mı, devam mı? tamam(0) / devam (1)");
		Main.choice = Main.input.nextInt();
		if (Main.choice == 1)
			products();
		
	}
	public static void buy(int choice, int type) {
		int buy;
		switch (type) {
			case 1:
				if(Game.player.money >= Game.weaponArr[choice].money) {
					System.out.println(Game.weaponArr[choice].name + " adlı ürünü almak istediğine emin misin? \n" + "1: Evet, 0: Hayır");
					buy = Main.input.nextInt();
					switch (buy) {
					case 1:
						Game.player.money -= Game.weaponArr[choice].money;
						Game.player.inventory.weaponName = Game.weaponArr[choice].name;
						Game.player.inventory.weaponDamage = Game.weaponArr[choice].defence;
						break;
					case 0:
						System.out.println("Tabi efenim");
						break;
					}
	
				} else {
					System.out.println(Game.weaponArr[choice].name + " adlı ürünü almak için yeterli bütçen yok :(");
					break;
				}
				break;
			case 2:
				if(Game.player.money >= Game.armorArr[choice].money) {
					System.out.println(Game.armorArr[choice].name + " adlı ürünü almak istediğine emin misin? \n" + "1: Evet, 0: Hayır");
					buy = Main.input.nextInt();
					switch (buy) {
						case 1:
							Game.player.money -= Game.armorArr[choice].money;
							Game.player.inventory.armorName = Game.armorArr[choice].name;
							Game.player.inventory.armorDefence = Game.armorArr[choice].defence;
							break;
						case 0:
							System.out.println("Tabi efenim");
							break;
						default:
							break;
					}
	
				} else {
					System.out.println(Game.weaponArr[choice].name + " adlı ürünü almak için yeterli bütçen yok :(");
					break;
				}
				break;
			default:
				break;
		}
	}
}
