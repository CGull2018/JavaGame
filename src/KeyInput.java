import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(true);
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(true);
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(true);
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(true);
				}
				// player pause 
				if (key == KeyEvent.VK_P) {
					handler.setPause(true);
				}
				// player resume
				if (key == KeyEvent.VK_0) {
					handler.setResume(true);
				}
				// weapon slot 1
				if(key == KeyEvent.VK_1) {
					handler.setWs1(true);
					System.out.println("Weapon Slot 1 equip");
				}
				//weapon slot 2
				if(key == KeyEvent.VK_2) {
					handler.setWs2(true);
					System.out.println("Weapon Slot 2 equip");

				}
				//weapon slot 3
				if(key == KeyEvent.VK_3) {
					handler.setWs3(true);
					System.out.println("Weapon Slot 3 equip");

				}
				//weapon slot 4
				if(key == KeyEvent.VK_4) {
					handler.setWs4(true);
					System.out.println("Weapon Slot 4 equip");

				}

			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(false);
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(false);
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(false);
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(false);
				}
				// player pause 
				if (key == KeyEvent.VK_P) {
					handler.setPause(false);
				}
				// player resume
				if (key == KeyEvent.VK_0) {
					handler.setResume(false);
				}
				// weapon slot 1
				if(key == KeyEvent.VK_1) {
					handler.setWs1(false);
				}
				//weapon slot 2
				if(key == KeyEvent.VK_2) {
					handler.setWs2(false);
				}
				//weapon slot 3
				if(key == KeyEvent.VK_3) {
					handler.setWs3(false);
				}
				//weapon slot 4
				if(key == KeyEvent.VK_4) {
					handler.setWs4(false);
				}
				

			}
		}
	}
}