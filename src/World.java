
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author Gullickson
 */
public class World extends MouseAdapter {

	private Handler handler;
	private HUD hud;
	
	private Random r = new Random();
	Game game;
	

	public World(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
}
		
	

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();



	}

	public void mouseReleased(MouseEvent e) {


	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void tick() {

		hud.tick();
		

	}

	public void render(Graphics g) {
		hud.render(g);
		
	}

}