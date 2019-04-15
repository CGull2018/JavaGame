import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;

public class MouseInput extends MouseAdapter {
	private Handler handler;
	private HUD hud;

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
	}
	
