import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import  java.util.List;

public class PlayerSpaceship {
    private ImageIcon playerSpaceship;
    private int x;
    private int y;
    private boolean alive;
    private List<PlayerFire> playerFireList;


    public PlayerSpaceship(int x, int y){
        this.playerSpaceship = new ImageIcon("images/spaceship.png");
        this.x = x;
        this.y = y;
        this.alive=true;
        this.playerFireList = new ArrayList<>();
    }

    public void fire(){
        playerFireList.add(new PlayerFire(this.getX(),this.getY()/2));
    }

    public void moveDown(Graphics graphics, GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x,this.y=y+4);
    }

    public void moveUp(Graphics graphics, GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x,this.y=y-4);
    }

    public void moveRight(Graphics graphics, GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x = x+4,this.y);
    }

    public void moveLeft (Graphics graphics,GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x = x-4,this.y);
    }

    public void paint (Graphics graphics, GameScene gameScene){
        this.playerSpaceship.paintIcon(gameScene,graphics,this.x,this.y);
    }

    public List<PlayerFire> getPlayerFireList() {
        return playerFireList;
    }

    public void setPlayerFireList(List<PlayerFire> playerFireList) {
        this.playerFireList = playerFireList;
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
