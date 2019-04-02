
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
public class PlayerMenu extends MouseAdapter {

	private Handler handler;
	Game game;



	public PlayerMenu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;


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

	}

	public void render(Graphics g) {

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		Font fnt = new Font("arial", 1, 50);

		g.setFont(fnt);
		g.setColor(Color.BLACK);
		g.drawString("Player Menu", 40, 70);
		//g.drawString("Pause", 40,130);
	}

}