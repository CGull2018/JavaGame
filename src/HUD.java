import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	private Game game;
	private Handler handler;


	// weapon states
	public enum weaponSTATE {
		Open, Unarmmed, Pistol, Scatter, Auto;
	}

	public weaponSTATE weaponState = weaponSTATE.Open;


	public HUD(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;

	}

	private int score = 0;
	private int level = 1;

	public static float HEALTH = 100;
	public float greenValue = 255;
	public float blueValue = 255;

	// weapon init
	public int basicAmmo = 10;
	public int scatterAmmo = 10;
	public int autoAmmo = 20;


	public static float STAMINA = 110;


	
	

	public void tick() {

		score++;
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);

		greenValue = HEALTH * 2;

		STAMINA = Game.clamp(STAMINA, 0, 100);
		blueValue = Game.clamp(blueValue, 0, 255);

		blueValue = STAMINA * 2;
		
		///////////////////////// player weapon keys

		if (handler.isWs1() == true) {
			weaponState = weaponSTATE.Unarmmed;
			System.out.println("Weapon State ws 1");
		}
		if (handler.isWs2() == true) {
			weaponState = weaponSTATE.Pistol;
			System.out.println("Weapon State ws 2");
		}
		if (handler.isWs3() == true) {
			weaponState = weaponSTATE.Scatter;
			System.out.println("Weapon State ws 3");
		}
		if (handler.isWs4() == true) {
			weaponState = weaponSTATE.Auto;
			System.out.println("Weapon State ws 4");
		}

	}
	
	public void render(Graphics g) {

		// player Health
		g.setColor(Color.WHITE);
		g.drawRect(400, 350, 200, 75);
		g.drawString("Player: " + ID.Player, 405, 380);
		g.drawString("Player Health: " + HEALTH, 405, 400);



		g.drawString("SCORE: " + score, 10, 32);
		g.drawString("LEVEL: " + level, 10, 64);
	
	switch (weaponState) {
	case Unarmmed:
		g.drawString("Player Unarmmed: " , 405, 420);

		break;
	case Pistol:
		g.drawString("Player Basic Ammo: " + basicAmmo, 405, 420);
		break;
	case Scatter:
		g.drawString("Player Scatter Ammo: " + scatterAmmo, 405, 420);
		break;
	case Auto:
		g.drawString("Player Auto Ammo: " + autoAmmo, 405, 420);
		break;
	default:
		break;
	}
	
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
