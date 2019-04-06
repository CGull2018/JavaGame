import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class ScatterAmmo extends GameObject {

	Random r = new Random();
	
	public int ammoCount = r.nextInt(10);
	
	private Handler handler;
	
	public ScatterAmmo(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	
		int scatterDamage = 5;
		
	}


	@Override
	public void tick() {


	}


	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int) y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
