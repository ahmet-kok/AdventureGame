package AdventureGame.com.org;

public class Game {
	public static Player player = new Player();
	public static SafeHouse safeHouse = new SafeHouse();
	public static ToolStore toolStore = new ToolStore();
	static Tools[] weaponArr = new Tools[3];
	static Tools[] armorArr = new Tools[3];
	public static final int ZOMBI = 10;
	public static final int VAMPIR = 14;
	public static final int AYI = 20;
	static int rand = (int) ((Math.random() * 10 / 3) + 1);
	static {
		rand = (int) ((Math.random() * 10 / 3) + 1);
	}
	public static Forest forest = new Forest(new Obstacle(4, 14, "Vampir", rand));
	static {
		rand = (int) ((Math.random() * 10 / 3) + 1);
	}
	public static River river = new River(new Obstacle(7, 20, "Ayı", rand));
	static {
		rand = (int) ((Math.random() * 10 / 3) + 1);
	}
	public static Cave cave = new Cave(new Obstacle(3, 10, "Zombi", rand));
	public static int level;
	
	
	public void start() {
		Game.weaponArr[0] = new Tools("Tabanca", 2, 25);
		Game.weaponArr[1] = new Tools("Kılıç", 3, 35);
		Game.weaponArr[2] = new Tools("Tüfek", 7, 45);
		Game.armorArr[0] = new Tools("Hafif", 1, 15);
		Game.armorArr[1] = new Tools("Orta", 3, 25);
		Game.armorArr[2] = new Tools("Ağır", 5, 40);
		
		
		System.out.println("Hoşgeldin");
		System.out.print("Adın ne? ");
		Main.playerName = Main.input.nextLine();
		System.out.println("Hangi zorluk seviyesinde oynamak istersin?");
		System.out.println("(1) Kolay \n(2) Orta\n(3) Zor");
		level = Main.input.nextInt();
		switch (level) {
			case 1:
				System.out.println("Bu kadar korkmana gerek yoktu ya :D");
				level = 5;
				break;
			case 2:
				System.out.println("Bi dahaki sefere zora da bekleriz.");
				level = 4;
				break;
			case 3:
				System.out.println("Birileri zor seviyor ha.");
				level = 3;
				break;
			default:
				System.out.println("Birileri zor seviyor ha.");
				level = 3;
				break;
		}
		
		player.selectChar();
		System.out.println(player.toString());
		System.out.println("Seçtiğin karakter: " + player.name);
		player.location = 1;
		System.out.println("Bu hikayeye evinde başlıyorsun dostum...");
		System.out.println("Uyan hadi uykucu " + player.name);

	}
	public static void location() {
		System.out.println("Nereye gitmek istersin?");
		switch (player.location) {
			case 1:
				System.out.println("1 - Market" + "\n"
						+ "2 - Orman" + "\n"
						+ "3 - Mağara" + "\n"
						+ "4 - Nehir" + "\n"
						+ "5 - Özelliklerim");
				Main.choice = Main.input.nextInt() + 1;
				break;
			case 2:
				System.out.println("1 - Ev" + "\n"
						+ "2 - Orman" + "\n"
						+ "3 - Mağara" + "\n"
						+ "4 - Nehir" + "\n"
						+ "5 - Özelliklerim");
				Main.choice = Main.input.nextInt();
				if (Main.choice > 1)
					Main.choice += 1;
				break;
			case 3:
				System.out.println("1 - Ev" + "\n"
						+ "2 - Market" + "\n"
						+ "3 - Mağara" + "\n"
						+ "4 - Nehir" + "\n"
						+ "5 - Özelliklerim");
				Main.choice = Main.input.nextInt();
				if (Main.choice > 2)
					Main.choice += 1;
				break;
			case 4:
				System.out.println("1 - Ev" + "\n"
						+ "2 - Market" + "\n"
						+ "3 - Orman" + "\n"
						+ "4 - Nehir" + "\n"
						+ "5 - Özelliklerim");
				Main.choice = Main.input.nextInt();
				if (Main.choice > 3)
					Main.choice += 1;
				break;
			case 5:
				System.out.println("1 - Ev" + "\n"
						+ "2 - Market" + "\n"
						+ "3 - Orman" + "\n"
						+ "4 - Mağara" + "\n"
						+ "5 - Özelliklerim");
				Main.choice = Main.input.nextInt();
				if (Main.choice > 4)
					Main.choice += 1;
				break;
			case 6:
				System.out.println("1 - Ev" + "\n"
						+ "2 - Market" + "\n"
						+ "3 - Orman" + "\n"
						+ "4 - Mağara" + "\n"
						+ "5 - Nehir" + "\n"
						+ "6 - Özelliklerim");
		}
		player.location = Main.choice;
		switch(Main.choice) {
			case 1:
				player.location = 1;
				System.out.println("Evdesin ve canın da yenilendi yubbiii");
				safeHouse.onLocation();
				break;
			case 2:
				player.location = 2;
				System.out.println("Markete hoş geldiniz efenim.");
				ToolStore.products();
				break;
			case 3:
				player.location = 3;
				System.out.println("Ormana gidiyorsun geçe kalma, dikkatli ol.");
				forest.onLocation();
				break;
			case 4:
				player.location = 4;
				cave.onLocation();
				break;
			case 5:
				player.location = 5;
				System.out.println("Nehire gidiyorsun akıntıya dikkat et.");
				river.onLocation();
				break;
			case 6:
				player.location = 1;
				System.out.println(player.toString());
				break;
		}
	}
}
