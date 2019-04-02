import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	Handler handler;

	public static float HEALTH = 100;
	public float greenValue = 255;
	public float blueValue = 255;

	public static float STAMINA = 110;

	public void tick() {

		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);

		greenValue = HEALTH * 2;

		STAMINA = Game.clamp(STAMINA, 0, 100);
		blueValue = Game.clamp(blueValue, 0, 255);

		blueValue = STAMINA * 2;

	}

	public void render(Graphics g){
    	
    	// player Health
        g.setColor(Color.WHITE);
        g.drawRect(400, 350, 200, 75);
        g.drawString("Player: " + ID.Player, 405, 380);
        g.drawString("Player Health: " + HEALTH , 405, 400); 
        g.drawString("Player Stamina: " + STAMINA , 405, 420);
        

}}

