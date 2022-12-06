package AdventureGame.com.org;

public class SafeHouse extends NormalLoc{
	public void home() {
		switch(Game.player.name) {
			case "Samuray":
				Game.player.healthy = 21;
				break;
			case "Okçu":
				Game.player.healthy = 18;
				break;
			case "Şövalye":
				Game.player.healthy = 24;
				break;
		}
	}
	@Override
	public boolean onLocation() {
		home();
		if (Game.player.location == 1)
			return true;
		return false;
	}
	
}
