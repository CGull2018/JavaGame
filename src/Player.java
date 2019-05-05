
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class Player extends GameObject {
	Game game;
	Random r = new Random();
	Handler handler;
	HUD hud;
	MouseInput mouseInput;

	// weapon init
	// weapon damages

	// ammo Pickup amount
	public int basicAmmoPickup = r.nextInt(5);
	// ammo Pickup boolean
	public boolean basicPickup = false;

	// weapon states
	private boolean ws1;
	private boolean ws2;
	private boolean ws3;
	private boolean ws4;

	public int basicAmmo = 10;
	public int scatterAmmo = 10;
	public int autoAmmo = 20;

	// Player Variable

	public int speed;
	public int direction;
	public int mouseX;
	public int mouseY;

	private boolean isFire;
	private long firingTimer;
	public long firingDelay;

	// weapon states
	public enum weaponSTATE {
		Open, Unarmmed, Pistol, Scatter, Auto;
	}

	public weaponSTATE weaponState = weaponSTATE.Open;

	public int weaponSlot = 0;

	public Player(int x, int y, ID id, Handler handler, Game game, HUD hud, MouseInput mouseInput) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		this.hud = hud;
		this.mouseInput = mouseInput;


		speed = 5;


		// Weapon Delay
		isFire = false;
		firingTimer = System.nanoTime();

	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {

		mouseX = mouseInput.mx;
		mouseY = mouseInput.my;
		
		System.out.print("MOuseX: " + mouseX);
		
		// menu states
		if (HUD.HEALTH <= 0) {
			handler.removeObject(this);
			game.gameState = Game.STATE.PlayerMenu;
		}

		if (handler.isPause() == true) {
			game.gameState = Game.STATE.PlayerMenu;

		}
		if (game.gameState == Game.STATE.PlayerMenu) {
			if (handler.isResume() == true) {
				game.gameState = Game.STATE.World;

			}
		}

		// player velocity

		x += velX;
		y += velY;

		// player movement

		if (game.gameState == Game.STATE.World) {
			if (handler.isUp() == true) {
				velY = -speed;
				direction = 270;
				
			} else if (!handler.isDown()) {
				velY = 0;
			}

			if (handler.isDown() == true) {
				velY = speed;
				direction = 90;
			} else if (!handler.isUp()) {
				velY = 0;
			}

			if (handler.isRight() == true) {
				velX = speed;
				direction = 0;
			} else if (!handler.isLeft()) {
				velX = 0;
			}

			if (handler.isLeft() == true) {
				velX = -speed;
				direction = 180;
			} else if (!handler.isRight()) {
				velX = 0;
			}

			// weapon inventory up
			if (handler.isWeaponP() == true) {
				if (weaponSlot >= 0 || weaponSlot <= 3) {
					weaponSlot += 1;
					System.out.println("WeaponSlot: " + weaponSlot);
				}
			}
			// weapon inventory down
			if (handler.isWeaponM() == true) {
				if (weaponSlot >= 0 || weaponSlot <= 3) {
					weaponSlot -= 1;
					System.out.println("WeaponSlot: " + weaponSlot);
				}
			}
				//weapons in inventory
			switch (weaponSlot) {
			case 0:

				weaponState = weaponSTATE.Unarmmed;
				System.out.println("Weapon State ws 1");

				break;
			case 1:

				weaponState = weaponSTATE.Pistol;
				System.out.println("Weapon State ws 2");
				

				
				if (handler.isFire() == true) {
					long elapsed = (System.nanoTime() - firingTimer) / 1000000;
					if (elapsed > firingDelay) {
						handler.addObject(new Bullet(x + 16, y - 16, ID.Bullet, handler, this, mouseX, mouseY));
						firingTimer = System.nanoTime();
					}

				}

				break;
			case 2:

				weaponState = weaponSTATE.Scatter;
				System.out.println("Weapon State ws 3");
				if (handler.isFire() == true) {
					long elapsed = (System.nanoTime() - firingTimer) / 1000000;
					if (elapsed > firingDelay) {
						for (int s = 0; s < 3; s++) {
							handler.addObject(new Bullet(x + 16, y - 16, ID.Bullet, handler, this, mouseX, mouseY));

						}
						firingTimer = System.nanoTime();

					}
				}
				break;
			case 3:

				weaponState = weaponSTATE.Auto;
				System.out.println("Weapon State ws 4");
				if (handler.isFire() == true) {
					long elapsed = (System.nanoTime() - firingTimer) / 1000000;
					if (elapsed > firingDelay) {

						handler.addObject(new Bullet(x + 16, y - 16, ID.Bullet, handler, this, mouseX, mouseY));
						firingTimer = System.nanoTime();

					}
				}
				break;
			}

		}

		// Border Collision
		x = Game.clamp((int) x, 0, Game.WIDTH - 37);
		y = Game.clamp((int) y, 0, Game.HEIGHT - 62);

		// event collision
		collision();

	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			// collision with basic enemy
			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;
					velX += r.nextInt(speed);
					velY += r.nextInt(speed);

				}
			}

			// pickup basic ammo
			if (tempObject.getId() == ID.BasicAmmo) {
				if (getBounds().intersects(tempObject.getBounds())) {

				}
			}

		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 32, 32);

		switch (weaponState) {
		case Unarmmed:
			g.drawString("Player Unarmmed: ", 405, 420);

			break;
		case Pistol:
			g.drawString("Player Basic Ammo: " + basicAmmo, 405, 420);
			break;
		case Scatter:
			g.drawString("Player Scatter Ammo: " + scatterAmmo, 405, 420);
			break;
		case Auto:
			g.drawString("Player Auto Ammo: " + autoAmmo, 405, 420);
			break;
		default:
			break;
		}
	}

}
