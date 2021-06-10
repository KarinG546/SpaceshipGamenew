import javax.swing.*;
import java.awt.*;

public class Level1Scene extends DefaultScene {



    public Level1Scene(GameScene gameScene, PlayerSpaceship playerSpaceship, EnemySpaceship enemySpaceship,
                       EnemyFire enemyFire, Explosion explosion, ImageIcon background){
        super(gameScene,playerSpaceship,enemySpaceship,
                enemyFire,explosion,background);
        super.setSceneId(Definitions.LEVEL_1_SCENE);

    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        Graphics2D createGraphics = (Graphics2D) graphics;
        createGraphics.setFont( new Font("Ariel", Font.BOLD, 50));
        createGraphics.setPaint( Color.WHITE );
        createGraphics.drawString("level 1 ",400,100);
        this.getEnemySpaceship().paint(graphics, super.getGameScene());
        if(this.getEnemyFire().isAppears()) {
            this.getEnemyFire().paint(graphics, super.getGameScene());
        }


    }

}
