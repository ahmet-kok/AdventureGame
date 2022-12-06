package AdventureGame.com.org;

public class Cave extends BattleLoc{
	
	public Cave(Obstacle Zombie) {
		super(Zombie);
		//System.out.println(Zombie.damage + Zombie.healthy + Zombie.name + Zombie.number);
	}

	@Override
	public boolean onLocation() {
		if (Game.player.location == 4) {
			if (this.obstacle.number == 0) {
				System.out.println("Tüm zombiler ölmüş:)" );
				
			} else {
				System.out.println("Eyvah burada " + Game.cave.obstacle.number + " tane " + Game.cave.obstacle.name + " var!");
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
						System.out.println("Tüm zombiler öldü. Ödülün 10 papel ve bir ekmek :)" );
						Game.player.inventory.food = true;
						Game.player.money += 10;
						break;
					}
						
					System.out.println("Kalan canın: " + Game.player.healthy + " Zırh canın: " + Game.player.inventory.armorDefence);
					System.out.println(this.obstacle.number + " tane zombi var ve savaşta olduğun zombinin canı " + this.obstacle.healthy);
					System.out.println("Savaşmak istiyor musun? Evet için 1'e bas.");
					Main.choice = Main.input.nextInt();
				}
				return true;
			}
		}
		return false;
	}
}
