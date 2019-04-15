import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bullet extends GameObject {

	Random r = new Random();
	private Handler handler;
	private HUD hud;
	private Player player;

	// bullet direction
	private double rad;
	private double dx;
	private double dy;

	// bullet speed
	private double speed = 15;

	// bullet damage
	public int damage = 20;
	public double scatter = (r.nextDouble() - rad) * -.5  ;

	public Bullet(float x, float y, ID id, Handler handler, Player player) {
		super(x, y, id);
		this.handler = handler;
		this.player = player;

		rad = Math.toRadians(player.direction);
		dx = Math.cos(rad);
		dy = Math.sin(rad);
		
		
	}

	@Override
	public void tick() {

		switch (player.weaponState) {
		case Pistol:

			player.firingDelay = 300;
			x += dx * speed;
			y += dy * speed;
			break;
		case Scatter:
			player.firingDelay = 500;
			x += (dx + Math.abs(scatter + .5)) * speed;
			y += (dy + Math.abs(scatter + .5)) * speed;
			break;
		case Auto:
			player.firingDelay = 200;
			x += dx * speed;
			y += dy * speed;
			break;

		}

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Bullet) {
				if (x < -8 || x > Game.WIDTH + 8 || y < -8 || y > Game.HEIGHT) {
					handler.object.remove(this);
					System.out.println("Bullet total:" + handler.object.size());
				}
			}
		}

		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

		}
	}

	@Override
	public void render(Graphics g) {

		switch (player.weaponState) {
		case Pistol:
			g.setColor(Color.GREEN);
			g.fillOval((int) x, (int) y, 8, 8);
			break;
		case Scatter:
			g.setColor(Color.CYAN);
			g.fillOval((int) x, (int) y, 4, 4);
			g.setColor(Color.black);
			g.drawOval((int) x, (int)y, 4, 4);
			break;
		case Auto:
			g.setColor(Color.YELLOW);
			g.fillOval((int) x, (int) y, 4, 8);

		}
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 8, 8);
	}

}
