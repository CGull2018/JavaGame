import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Gullickson
 */
public class BasicEnemy extends GameObject {

	Random r = new Random();

	// basic stats
	public int enemyHealth = 100;
	public int ammoDrop = r.nextInt(10);

	public int roamX = 0;
	public int roamY = 0;
	
	// AI alert distances
	public float roamDistance = 400;
	public float alertDistance = 250;
	public float chaseDistance = 150;

	Game game;
	Handler handler;
	Player player;
	HUD hud;


	public enum STATE {
		Roam, Alert, Chase;
	}

	public STATE watchState = STATE.Roam;

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

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player) {

				float diffX = x - player.getX();
				float diffY = y - player.getY();
				float distance = (float) Math
						.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

				// enemy Movement
				if (game.gameState == Game.STATE.World) {
					if (distance >= roamDistance) {
						watchState = STATE.Roam;
					} else if (distance <= alertDistance && distance > chaseDistance) {
						watchState = STATE.Alert;
					} else if (distance <= chaseDistance) {
						watchState = STATE.Chase;
					}
					switch (watchState) {
					case Roam:
						System.out.println("Roaming " + distance);
						int choose = r.nextInt(10);

						if (choose == 6) {
							roamX = r.nextInt(4 - -4) + -2;
							roamY = r.nextInt(4 - -4) + -2;
						}
						x += roamX;
						y += roamY;

						break;
					case Alert:
						System.out.println("Alert " + distance);
						x += velX;
						y += velY;

						velX = (float) ((-1.0 / distance) * diffX * 2);
						velY = (float) ((-1.0 / distance) * diffY * 2);

						break;
					case Chase:
						System.out.println("Chase " + distance);
						x += velX;
						y += velY;

						velX = (float) ((-1.0 / distance) * diffX * 3);
						velY = (float) ((-1.0 / distance) * diffY * 3);
						break;

					}
				}

				collision();

				// enemy Living
				if (enemyHealth <= 0) {
					handler.removeObject(this);

				}
				x = Game.clamp((int) x, 0, Game.WIDTH - 37);
				y = Game.clamp((int) y, 0, Game.HEIGHT - 62);
			}
		}

	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Bullet) {
				if (getBounds().intersects(tempObject.getBounds())) {
					enemyHealth -= 20;
					handler.removeObject(tempObject);
					 handler.addObject(new BasicAmmo((float)this.getX() + r.nextInt(100),(float)this.getY() + r.nextInt(100),ID.BasicAmmo, handler));

				

				}

			}
		}
	}

	public void render(Graphics g) {

		switch (watchState) {

		case Roam:
			g.setColor(Color.green);
			g.fillRect((int) x, (int) y, 32, 32);
			break;

		case Alert:
			g.setColor(Color.yellow);
			g.fillRect((int) x, (int) y, 32, 32);
			break;

		case Chase:
			g.setColor(Color.red);
			g.fillRect((int) x, (int) y, 32, 32);
			break;
		}

		// Basic Enemy Stats

		g.setColor(Color.white);
		g.drawString("Health: " + enemyHealth, (int) x, (int) y - 25);

	}

}
