import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

	private Handler handler;


	public Bullet(float x, float y, ID id, Handler handler, int mx, int my) {
		super(x, y, id);
		this.handler = handler;


		velX = (mx - x) / 10;
		velY = (my - y) / 10;

	}

	@Override
	public void tick() {

		x += velX;
		y += velY;

		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {


				}
			}
		}
	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.GREEN);
		g.fillOval((int) x, (int) y, 8, 8);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 8, 8);
	}

}
