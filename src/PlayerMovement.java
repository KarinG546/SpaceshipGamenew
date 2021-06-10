import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {

    private PlayerSpaceship playerSpaceship;
    private GameScene gameScene;
    private Graphics graphics;
    private  int sceneId;

    public PlayerMovement(PlayerSpaceship playerSpaceship, GameScene gameScene, Graphics graphics, int sceneId){
        this.playerSpaceship = playerSpaceship;
        this.gameScene = gameScene;
        this.graphics = graphics;
        this.sceneId=sceneId;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (playerSpaceship.isAlive()) {
            if (keyCode == KeyEvent.VK_DOWN) {
                playerSpaceship.moveDown(this.graphics, gameScene);
            }
            if (keyCode == KeyEvent.VK_UP) {
                playerSpaceship.moveUp(this.graphics, gameScene);
            }
            if (keyCode == KeyEvent.VK_SPACE && sceneId == Definitions.MENU_SCENE) {
                gameScene.startGame();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
