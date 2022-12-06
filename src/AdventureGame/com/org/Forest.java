package AdventureGame.com.org;

public class Forest extends BattleLoc{
	
	public Forest(Obstacle Vampire) {
		super(Vampire);
		//System.out.println(Vampire.damage + Vampire.healthy + Vampire.name + Vampire.number);
	}

	@Override
	public boolean onLocation() {
		if (Game.player.location == 3) {
			if (this.obstacle.number == 0) {
				System.out.println("Tüm vampirler ölmüş:)" );
				
			} else {
				System.out.println("Eyvah burada " + Game.forest.obstacle.number + " tane " + Game.forest.obstacle.name + " var!");
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
						System.out.println("Tüm vampirler öldü. Ödülün 12 papel ve yakacak odun :)" );
						Game.player.inventory.firewoord = true;
						Game.player.money += 12;
						break;
					}
						
					System.out.println("Kalan canın: " + Game.player.healthy + " Zırh canın: " + Game.player.inventory.armorDefence);
					System.out.println(this.obstacle.number + " tane vampir var ve savaşta olduğun vampirin canı " + this.obstacle.healthy);
					System.out.println("Savaşmak istiyor musun? Evet için 1'e bas.");
					Main.choice = Main.input.nextInt();
				}
				return true;
			}
		}
		return false;
	}
	
}
