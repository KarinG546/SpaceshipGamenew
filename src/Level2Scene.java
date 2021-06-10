import javax.swing.*;
import java.awt.*;

public class Level2Scene extends DefaultScene {
    private EnemySpaceship enemySpaceship2;
    private EnemySpaceship enemySpaceship3;


    public Level2Scene(GameScene gameScene, PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship1,
                       EnemySpaceship enemySpaceship2, EnemySpaceship enemySpaceship3
                       ,EnemyFire enemyFire, Explosion explosion, ImageIcon background) {
        super(gameScene, playerSpaceship, enemySpaceship1,
                enemyFire, explosion, background);
        this.enemySpaceship2=enemySpaceship2;
        this.enemySpaceship3=enemySpaceship3;
        super.setSceneId(Definitions.LEVEL_2_SCENE);

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D createGraphics = (Graphics2D) graphics;
        createGraphics.setFont(new Font("Ariel", Font.BOLD, 50));
        createGraphics.setPaint(Color.WHITE);
        createGraphics.drawString("level 2 ", 400, 100);
        this.enemySpaceship2.paint(graphics,super.getGameScene());
        this.enemySpaceship3.paint(graphics,super.getGameScene());

    }
}
