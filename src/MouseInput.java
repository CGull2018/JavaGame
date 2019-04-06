import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MouseInput extends MouseAdapter {
	Random r = new Random();
	private Handler handler;
	private HUD hud;

	public MouseInput(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX());
		int my = (int) (e.getY());

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// basic single fire weapon
				if (hud.basicAmmo > 0 && hud.weaponState == HUD.weaponSTATE.Pistol) {
					handler.addObject(new Bullet(tempObject.getX() + 16, tempObject.getY() + 16, ID.Bullet, handler, mx,
							my, hud));
					hud.basicAmmo--;

				}
				// scatter shot weapon
				if (hud.scatterAmmo > 0 && hud.weaponState == HUD.weaponSTATE.Scatter) {
					for (int s = 0; s < 3; s++) {
						handler.addObject(new Bullet(tempObject.getX() + 16, tempObject.getY() + 16, ID.Bullet, handler,
								mx + r.nextInt(10 - -10) + -15, my + r.nextInt(10 - -10) + -15, hud));

					}
					hud.scatterAmmo--;
				}
				if (hud.autoAmmo > 0 && hud.weaponState == HUD.weaponSTATE.Auto) {
					do {
					handler.addObject(new Bullet(tempObject.getX() + 16, tempObject.getY() + 16, ID.Bullet, handler, mx,
							my, hud));
					
					for(int d = 0; d < 2; d++) {
						System.out.println("Delay");
					}
					hud.basicAmmo--;
					}while(hud.autoAmmo > 0 && hud.weaponState == HUD.weaponSTATE.Auto);

				}

			}
		}
	}
}
