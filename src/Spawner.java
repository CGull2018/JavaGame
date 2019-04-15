import java.util.Random;

public class Spawner {

	private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private int scoreKeep = 0;

    public Spawner(Handler handler, Game game, HUD hud ) {
        this.handler = handler;
        this.game = game;
        this.hud = hud;
        
    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.BasicEnemy, handler, game));

            }
            if (hud.getLevel() == 4) {
                handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.BasicEnemy, handler, game));
                handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.BasicEnemy, handler, game));
                handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.BasicEnemy, handler, game));
            }
        }

    }
}