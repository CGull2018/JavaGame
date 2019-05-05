import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;

public class MouseInput implements MouseMotionListener {
	private Handler handler;
	private HUD hud;

	public int mx;
	public int my;

	public MouseInput(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

		int mx = (int) (e.getX());
		int my = (int) (e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		mx = (int) e.getXOnScreen();
		my = (int) e.getYOnScreen();

	}
}
