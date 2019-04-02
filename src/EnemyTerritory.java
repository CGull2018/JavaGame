import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyTerritory extends GameObject{

	public EnemyTerritory(float x, float y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, 32, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, 32,32);
	}

}
