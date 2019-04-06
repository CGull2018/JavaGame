import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

	private Handler handler;
	private HUD hud;

	public int damage = 20;
	public int velTotal = 2;

	public Bullet(float x, float y, ID id, Handler handler, int mx, int my, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;


		if(hud.weaponState == HUD.weaponSTATE.Pistol) {
		velX = ((mx - x) / 10) * velTotal;
		velY = ((my - y) / 10) * velTotal;
		}
		if(hud.weaponState == HUD.weaponSTATE.Scatter) {
		velX = ((mx - x) / 30) * velTotal;
		velY = ((my - y) / 30 )* velTotal;
		
		}
		if(hud.weaponState == HUD.weaponSTATE.Auto) {
		velX = ((mx - x) / 20) * velTotal;
		velY = ((my - y) / 20 )* velTotal;
		
		}
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

		}
	}

	@Override
	public void render(Graphics g) {

		
		switch(hud.weaponState) {
		case Pistol:
			g.setColor(Color.GREEN);
			g.fillOval((int) x, (int) y, 8, 8);
			break;
		case Scatter:
			g.setColor(Color.CYAN);
			g.fillOval((int) x, (int) y, 4, 4);
			break;
		case Auto:
			g.setColor(Color.YELLOW);
			g.fillOval((int)x, (int)y, 4, 8);
			
		}
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 8, 8);
	}

}
