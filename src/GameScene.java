import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    private ImageIcon background;
    private int scene;
    private PlayerSpaceship playerSpaceship;
    private EnemySpaceship enemySpaceship;
    private EnemyFire enemyFire;
    private Explosion explosion;
   // private JButton playButton;

    public GameScene() {
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.background = new ImageIcon("images/space.png");
        this.playerSpaceship = new PlayerSpaceship(0,Definitions.SPACESHIP_STARTING_POSITION);
        this.enemySpaceship = new EnemySpaceship(Definitions.WINDOW_WIDTH,Definitions.SPACESHIP_STARTING_POSITION);
        this.enemyFire = new EnemyFire(Definitions.WINDOW_WIDTH,Definitions.SPACESHIP_STARTING_POSITION);
        this.explosion = new Explosion(playerSpaceship.getX(),playerSpaceship.getY());
        this.scene = 1;
        /*this.playButton = new JButton("Start Game");
        this.playButton.setBounds(400,300,200,50);
        this.playButton.addActionListener((e -> {
            if (this.scene == Definitions.MENU_SCENE){
                this.scene = Definitions.LEVEL_1_SCENE;
            }
        }));
        this.add(playButton);*/
        this.mainGameLoop();

    }

    public void paint (Graphics graphics) {
        super.paint(graphics);
        this.background.paintIcon(this,graphics,0,0);
        switch (this.scene){
            case Definitions.MENU_SCENE:
                Graphics2D createGraphics = (Graphics2D) graphics;
                createGraphics.setFont( new Font("Ariel", Font.BOLD, 50));
                createGraphics.setPaint( Color.WHITE );
                createGraphics.drawString("Welcome to Space Wars",200,100);
                createGraphics.dispose();
               break;
            case Definitions.LEVEL_1_SCENE:
               // this.playButton.setVisible(false);
                if(this.playerSpaceship.isAlive()) {
                    this.playerSpaceship.paint(graphics, this);
                }
                this.enemySpaceship.paint(graphics,this);
                if(this.enemyFire.isAppears()) {
                    this.enemyFire.paint(graphics, this);
                }
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
        Rectangle playerRectangle = new Rectangle(playerSpaceship.getX(),playerSpaceship.getY(),120,120);
        Rectangle enemyRectangle = new Rectangle(enemySpaceship.getX(),
                enemySpaceship.getY(),155,155);
        Rectangle enemyFireRectangle = new Rectangle(enemyFire.getX(),
                enemyFire.getY(),128,128);
        boolean collision1 = playerRectangle.intersects(enemyRectangle);
        boolean collision2 = playerRectangle.intersects(enemyFireRectangle);
        if (collision1) return collision1;
        if (collision2) return collision2;
        return false;
    }

    private void mainGameLoop() {
        new Thread(() -> {
            while (true) {
                switch (this.scene) {
                    case Definitions.LEVEL_1_SCENE:
                        enemySpaceship.moveLeft(this.getGraphics(), this);
                        enemyFire.moveLeft(this.getGraphics(), this);
                        if (collision(playerSpaceship, enemySpaceship, enemyFire)) {
                            this.playerSpaceship.setAlive(false);
                            this.enemyFire.setAppears(false);
                            this.explosion.paint(this.getGraphics(),this);
                            this.scene = Definitions.LOSING_SCENE;
                        }
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
