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
        this.getEnemySpaceship().paint(graphics,super.getGameScene());
        if(this.getEnemyFire().isAppears()) {
            this.getEnemyFire().paint(graphics, super.getGameScene());
        }


    }

}
