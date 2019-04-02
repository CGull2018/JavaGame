import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Gullickson
 */
public class BasicEnemy extends GameObject {

	public int enemyHealth = 100;
	public int enemyStamina = 100;

	Game game;
	Handler handler;
	Player player;
	HUD hud;

	public BasicEnemy(int x, int y, ID id, Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;

		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player)
				player = (Player) handler.object.get(i);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {

		// enemy Living
		if (enemyHealth <= 0) {
			handler.removeObject(this);

		}
		// enemy Movement
		if (game.gameState == Game.STATE.World) {
			for (int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if (tempObject.getId() == ID.Player) {

					x += velX;
					y += velY;

					float diffX = x - player.getX();
					float diffY = y - player.getY();
					float distance = (float) Math.sqrt(
							(x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

					velX = (float) ((-1.0 / distance) * diffX);
					velY = (float) ((-1.0 / distance) * diffY);

					if (distance == 0) {
						// enemy Collision
						collision();
					}
				}
			}

		}
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);


			}
		}
	}

	public void render(Graphics g) {

		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 32, 32);
		// Basic Enemy Stats

		g.setColor(Color.WHITE);
		g.drawRect(25, 350, 200, 75);
		g.drawString("Enemy: " + ID.BasicEnemy, 30, 380);
		g.drawString("Enemy Health: " + enemyHealth, 30, 400);
		g.drawString("Enemy Stamina: " + enemyStamina, 30, 420);

	}

}
