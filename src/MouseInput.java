import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{
	private Handler handler;

	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX());
		int my = (int) (e.getY());
	
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				handler.addObject(new Bullet (tempObject.getX() + 16,tempObject.getY() + 16, ID.Bullet, handler, mx, my));
			}
			
		}
	}
}
