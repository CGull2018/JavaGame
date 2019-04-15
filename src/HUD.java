import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class HUD {
	
	Random r = new Random();
	private Game game;
	private Handler handler;


	public HUD(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;

	}

	private int score = 0;
	private int level = 1;

	public static float HEALTH = 100;
	public float greenValue = 255;
	public float blueValue = 255;


	public void tick() {

		score++;
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);

		greenValue = HEALTH * 2;


	}
	
	public void render(Graphics g) {

		// player Health
		g.setColor(Color.WHITE);
		g.drawRect(400, 350, 200, 75);
		g.drawString("Player: " + ID.Player, 405, 380);
		g.drawString("Player Health: " + HEALTH, 405, 400);



		g.drawString("SCORE: " + score, 10, 32);
		g.drawString("LEVEL: " + level, 10, 64);
	

	
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
