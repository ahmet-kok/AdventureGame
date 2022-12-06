package AdventureGame.com.org;

public class River extends BattleLoc{

	public River(Obstacle Bear) {
		super(Bear);
		//System.out.println(Bear.damage + Bear.healthy + Bear.name + Bear.number);
	}

	@Override
	public boolean onLocation() {
		if (Game.player.location == 5) {
			if (this.obstacle.number == 0) {
				System.out.println("Tüm ayılar ölmüş:)" );
				
			} else {
				System.out.println("Eyvah burada " + Game.river.obstacle.number + " tane " + Game.river.obstacle.name + " var!");
				System.out.println("Savaşmak istiyor musun? Evet için 1'e bas.");
				eat();
				Main.choice = Main.input.nextInt();
				if(Main.choice == 2 || Main.choice == 3) {
					eat(Main.choice);
				}
				if (Main.choice == 1)
					System.out.println("Savaş başlasın.");
				while(Main.choice == 1) {
					combat();
					if (this.obstacle.number == 0) {
						System.out.println("Tüm ayılar öldü. Ödülün 15 papel ve bir şişe su :)" );
						Game.player.inventory.water = true;
						Game.player.money += 15;
						break;
					}
						
					System.out.println("Kalan canın: " + Game.player.healthy + " Zırh canın: " + Game.player.inventory.armorDefence);
					System.out.println(this.obstacle.number + " tane ayı var ve savaşta olduğun ayının canı " + this.obstacle.healthy);
					System.out.println("Savaşmak istiyor musun? Evet için 1'e bas.");
					Main.choice = Main.input.nextInt();
				}
				return true;
			}
		}
		return false;
	}
}
