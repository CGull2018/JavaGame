import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	// create game settings
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;

	// imported objects
	private Handler handler;
	private Menu menu;
	private Help help;
	private Player player;
	private BasicEnemy basicEnemy;
	private Bullet bullet;
	private HUD hud;
	private Spawner spawner;
	private World world;
	private PlayerMenu playerMenu;

	// GameState
	public enum STATE {
		Menu, Help, Game, PlayerMenu, Battle, World, End;
	}

	public STATE gameState = STATE.Menu;


	// game spawn
	public Game() {
		handler = new Handler();
		hud = new HUD(this, handler);
		menu = new Menu(this, handler, hud);
		playerMenu = new PlayerMenu(this, handler);
		world = new World(this, handler, hud);
		spawner = new Spawner(handler, this, hud);

		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler, hud));

		new Window(WIDTH, HEIGHT, "JavaGame RPG", this);

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {

		handler.tick();

		switch (gameState) {

		case Game:
			break;
		case Menu:
			this.addMouseListener(menu);
			menu.tick();
			break;
		case Help:
			this.addMouseListener(help);
			break;
		case End:
			break;

		case World:

			world.tick();
			spawner.tick();

			break;

		case PlayerMenu:
			playerMenu.tick();
			break;
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);

		switch (gameState) {

		case Game:
			break;
		case Menu:
			menu.render(g);
			break;
		case World:
			world.render(g);

			break;
		case PlayerMenu:
			playerMenu.render(g);
		}

		g.dispose();
		bs.show();

	}

	public static float clamp(float var, float min, float max) {
		if (var >= max) {
			return var = max;

		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}

	public static void main(String args[]) {

		new Game();

	}
}
