import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Game {

    private final int NUM_OBSTACLES = 20;

    private GameViewer window;
    private int score;
    private int deaths;
    private int level;
    private boolean gameover;
    private Obstacle obstacleClass;
    private Obstacle[] obstacles;

    public Game(){
        window = new GameViewer(this);
        score = 0;
        deaths = 0;
        level = 1;
        gameover = false;

        obstacles = new Obstacle[NUM_OBSTACLES];

    }
    public Obstacle[] getImages() {
        return obstacles;
    }

    public void playGame(){
        window.repaint();
    }

    public void updatePercentage(){

    }
    public void updateDeaths() {

    }
    public void checkGameOver() {

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            obstacleClass.jump();
        }
    }

    public static void main(String[] args) {
        //Make game object to call the methods in the game class
        Game game = new Game();
        game.playGame();
    }

}

