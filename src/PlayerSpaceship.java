import javax.swing.*;
import java.awt.*;

public class PlayerSpaceship {
    private ImageIcon playerSpaceship;
    private int x;
    private int y;
    private boolean alive;

    public PlayerSpaceship(int x, int y){
        this.playerSpaceship = new ImageIcon("images/spaceship.png");
        this.x = x;
        this.y = y;
        this.alive=true;
    }

    public void moveDown(Graphics graphics, GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x,this.y=y+4);
    }

    public void moveUp(Graphics graphics, GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x,this.y=y-4);
    }

    public void paint (Graphics graphics, GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x,this.y);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public ImageIcon getPlayerSpaceship() {
        return playerSpaceship;
    }

    public void setPlayerSpaceship(ImageIcon playerSpaceship) {
        this.playerSpaceship = playerSpaceship;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
