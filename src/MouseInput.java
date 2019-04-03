import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	private Handler handler;
	private HUD hud;

	public MouseInput(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX());
		int my = (int) (e.getY());
	
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(hud.basicAmmo > 0) {
				handler.addObject(new Bullet (tempObject.getX() + 16,tempObject.getY() + 16, ID.Bullet, handler, mx, my));
				hud.basicAmmo --;
			
			}
			
		}
			}
		}
}
