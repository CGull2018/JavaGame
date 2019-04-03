
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	Game game;
	Random r = new Random();
	Handler handler;
	HUD hud;

	// Player Variable

	public int speed = 5;

	public Player(int x, int y, ID id, Handler handler, Game game, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		this.hud = hud;

	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {

		if (HUD.HEALTH <= 0) {
			handler.removeObject(this);
			game.gameState = Game.STATE.PlayerMenu;
		}

		if (handler.isPause() == true) {
			game.gameState = Game.STATE.PlayerMenu;

		}
		if (game.gameState == Game.STATE.PlayerMenu) {
			if (handler.isResume() == true) {
				game.gameState = Game.STATE.World;

			}
		}

		// player velocity

		x += velX;
		y += velY;

		// player movement

		if (game.gameState == Game.STATE.World) {
			if (handler.isUp() == true) {
				velY = -speed;
				System.out.println("MoveUp");
			} else if (!handler.isDown()) {
				velY = 0;
			}

			if (handler.isDown() == true) {
				velY = speed;
			} else if (!handler.isUp()) {
				velY = 0;
			}

			if (handler.isRight() == true) {
				velX = speed;
			} else if (!handler.isLeft()) {
				velX = 0;
			}

			if (handler.isLeft() == true) {
				velX = -speed;
			} else if (!handler.isRight()) {
				velX = 0;
			}
		}
		x = Game.clamp((int) x, 0, Game.WIDTH - 37);
		y = Game.clamp((int) y, 0, Game.HEIGHT - 62);

		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			// collision with basic enemy
			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;
					velX += r.nextInt(speed);
					velY += r.nextInt(speed);

				}
			}

			//pickup basic ammo
			if (tempObject.getId() == ID.BasicAmmo) {
				if (getBounds().intersects(tempObject.getBounds())) {
					hud.basicAmmo += r.nextInt(10);
					handler.removeObject(tempObject);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 32, 32);

	}

}
