package AdventureGame.com.org;

public abstract class BattleLoc extends Location{
	public Obstacle obstacle;
	
	public BattleLoc(Obstacle o) {
		obstacle = new Obstacle(o.damage, o.healthy, o.name, o.number);
	}
	public boolean onLocation() {
		return true;
	}
	public void combat() {
		if (this.obstacle.number == 0) {
			System.out.println("Burada hiç " + this.obstacle.name + " kalmamış heheyyy");
		} else {
			Game.rand = (int) (Math.random() * 10);
			if(Game.rand > Game.level) {
				System.out.println("Saldırıyı " + this.obstacle.name + " yaptı");
				if (Game.player.inventory.armorDefence > 0 && Game.player.inventory.armorDefence >= this.obstacle.damage) {
					Game.player.inventory.armorDefence -= this.obstacle.damage;
				}
				else if(Game.player.inventory.armorDefence > 0 && Game.player.inventory.armorDefence < this.obstacle.damage) {
					Game.player.inventory.armorDefence = 0;
					Game.player.inventory.armorName = null;
				}
				else if(Game.player.healthy <= this.obstacle.damage) {
					System.out.println("Maalesef öldün :( oyun sonlandırılıyor.");
						System.exit(1);
					}
				else if (Game.player.healthy > this.obstacle.damage) {
					Game.player.healthy -= this.obstacle.damage;
				}
				
			} else {
				System.out.println("Saldırıyı sen yaptın.");
				if (Game.player.inventory.weaponDamage > 0) {
					this.obstacle.healthy -= (Game.player.damage + Game.player.inventory.weaponDamage);
				} else {
					this.obstacle.healthy -= (Game.player.damage);
				}
				if (this.obstacle.healthy <= 0) {
					this.obstacle.number -= 1;
					if (this.obstacle.name == "Zombi") {
						this.obstacle.healthy = Game.ZOMBI;						
					}
					else if (this.obstacle.name == "Vampir") {
						this.obstacle.healthy = Game.VAMPIR;						

					}
					else if (this.obstacle.name == "Ayı") {
						this.obstacle.healthy = Game.AYI;						

					}
					if (this.obstacle.number == 0) {
						Main.choice = 2;
					} else {
						System.out.println("1 " + this.obstacle.name + " öldürdün. " + this.obstacle.number + " " + this.obstacle.name + " kaldı." );								
					}	
				}
			}
		}
	}
	public void eat() {
		if(Game.player.inventory.water) {
			System.out.println("Su içmek istiyorsan 2'ye bas. Su 3 can kazandırır.");
		}
		if(Game.player.inventory.food) {
			System.out.println("Ekmek yemek istiyorsan 3'e bas. Ekmek 6 can kazandırır.");
		}
	}
	public void eat(int i) {
		if(i == 2) {
			System.out.println("Su içtin ve 3 can kazandın.");
			Game.player.inventory.water = false;
		}
		if(i == 3) {
			System.out.println("Ekmek yedin ve 6 can kazandın.");
			Game.player.inventory.food = false;
		}
	}
	
}
