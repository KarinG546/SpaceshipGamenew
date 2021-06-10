import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    private ImageIcon background;
    private int sceneId;
    private PlayerSpaceship playerSpaceship;
    private EnemySpaceship enemySpaceship1,enemySpaceship2,enemySpaceship3;
    private EnemyFire enemyFire;
    private Explosion explosion;
    private Level1Scene level1Scene;
    private Level2Scene level2Scene;

    public GameScene() {
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.background = new ImageIcon("images/space.png");
        this.playerSpaceship = new PlayerSpaceship(0,Definitions.SPACESHIP_STARTING_POSITION);
        this.enemySpaceship1 = new EnemySpaceship(Definitions.WINDOW_WIDTH,Definitions.SPACESHIP_STARTING_POSITION,
                new ImageIcon("images/enemySpaceship.png"));
        this.enemySpaceship2 = new EnemySpaceship(Definitions.WINDOW_WIDTH,Definitions.ENEMY_SPACESHIP_2_STARTING_POSITION,
                new ImageIcon("images/enemySpaceship2.png"));
        this.enemySpaceship3 = new EnemySpaceship(Definitions.WINDOW_WIDTH,Definitions.ENEMY_SPACESHIP_3_STARTING_POSITION,
                new ImageIcon("images/enemySpaceship3.png"));
        this.enemyFire = new EnemyFire(Definitions.WINDOW_WIDTH,Definitions.SPACESHIP_STARTING_POSITION);
        this.explosion = new Explosion(playerSpaceship.getX(),playerSpaceship.getY());
        this.level1Scene= new Level1Scene(this,this.playerSpaceship,this.enemySpaceship1,this.enemyFire,
                this.explosion,this.background);
        this.level2Scene = new Level2Scene(this,this.playerSpaceship,this.enemySpaceship1,this.enemySpaceship2,this.enemySpaceship3,
                this.enemyFire,this.explosion,this.background);
        this.add(level1Scene);
        this.add(level2Scene);
        this.mainGameLoop();

    }

    public int startGame(){
        this.sceneId = Definitions.LEVEL_1_SCENE;
        return sceneId;
    }

    public void paint (Graphics graphics) {
        super.paint(graphics);
        this.background.paintIcon(this,graphics,0,0);
        switch (this.sceneId){
            case Definitions.MENU_SCENE:
                Graphics2D createGraphics = (Graphics2D) graphics;
                createGraphics.setFont( new Font("Ariel", Font.BOLD, 50));
                createGraphics.setPaint( Color.WHITE );
                createGraphics.drawString("Welcome to Space Wars",200,100);
                createGraphics.drawString("To start game, press space key",200,600);
                createGraphics.dispose();
               break;
            case Definitions.LEVEL_1_SCENE:
                this.level1Scene.paint(graphics);
                break;
            case Definitions.LEVEL_2_SCENE:
                this.level2Scene.paint(graphics);
                break;
            case Definitions.LOSING_SCENE:
                Graphics2D createGraphics1 = (Graphics2D) graphics;
                createGraphics1.setFont( new Font("Ariel", Font.BOLD, 50));
                createGraphics1.setPaint( Color.WHITE );
                createGraphics1.drawString("YOU LOST",200,100);
                createGraphics1.dispose();
                break;

        }

    }

    public boolean collision (PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship, EnemyFire enemyFire){
        Rectangle playerRectangleWithEnemy = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),90,90);
        Rectangle playerRectangleWithFire = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),75,75);
        Rectangle enemyRectangle = new Rectangle(enemySpaceship.getX(),
                enemySpaceship.getY(),155,155);
        Rectangle enemyFireRectangle = new Rectangle(enemyFire.getX(),
                enemyFire.getY(),5,5);
        boolean collision1 = playerRectangleWithEnemy.intersects(enemyRectangle);
        boolean collision2 = playerRectangleWithFire.intersects(enemyFireRectangle);
        if (collision1) return collision1;
        if (collision2) return collision2;
        return false;
    }

    private void mainGameLoop() {
        new Thread(() -> {
            while (true) {
                switch (this.sceneId) {
                    case Definitions.LEVEL_1_SCENE:
                        enemySpaceship1.moveLeft(this.getGraphics(), this);
                        enemyFire.moveLeft(this.getGraphics(), this);
                        if (collision(playerSpaceship, this.level1Scene.getEnemySpaceship(), this.level1Scene.getEnemyFire())) {
                            this.playerSpaceship.setAlive(false);
                            this.enemyFire.setAppears(false);
                            this.explosion.paint(this.getGraphics(),this);
                            this.sceneId = Definitions.LOSING_SCENE;
                        }
                       if (this.level1Scene.getEnemySpaceship().getX() == 0 )
                           this.sceneId = Definitions.LEVEL_2_SCENE;
                        break;
                }
                repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public PlayerSpaceship getPlayerSpaceship() {
        return playerSpaceship;
    }

    public void setPlayerSpaceship(PlayerSpaceship playerSpaceship) {
        this.playerSpaceship = playerSpaceship;
    }
}
