
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
public class Menu extends MouseAdapter {
	private Game game;

	private Handler handler;

	Random r = new Random();

	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;

	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// Play button
		if (game.gameState == Game.STATE.Menu) {
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				game.gameState = Game.STATE.World;

				if(game.gameState == Game.STATE.World) {
					handler.addObject(new Player(game.WIDTH / 2,game.HEIGHT/2, ID.Player, handler, game));
					handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH/4), r.nextInt(game.HEIGHT / 2), ID.BasicEnemy, handler, game));

					}


			}
		}
		// Quit Button
		if (game.gameState == Game.STATE.Menu) {
		
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				System.exit(1);
			}
		}
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
		Font fnt = new Font("arial", 1, 50);

		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Wasteland RPG", 120, 70);

		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 270, 190);

		g.setColor(Color.white);
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 270, 290);

		g.setColor(Color.white);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 270, 390);
	}

}