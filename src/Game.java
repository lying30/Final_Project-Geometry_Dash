import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Game implements ActionListener {

    public final int NUM_OBSTACLES = 20;
    private Player playerClass;
    private GameViewer window;
    private int score;
    private int deaths;
    private int level;
    int[] arr;
    private boolean gameOver;
    private Obstacle obstacleClass;
    private static final int SLEEP_TIME = 10;
    private ArrayList<Obstacle> obstacles;
    private static final int    WINDOW_WIDTH = 1212,
            WINDOW_HEIGHT = 720;

    private Player player;

    public Game(){
        window = new GameViewer(this);
        score = 0;
        deaths = 0;
        level = 1;
        gameOver = false;


        player = new Player(window, window.getIcon());
        obstacles = new ArrayList<Obstacle>();
        createObstacles();

        Timer clock = new Timer(SLEEP_TIME, this);
        clock.start();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Player getPlayer() {
        return player;
    }
    private void createObstacles() {

        Obstacle obstacle0 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+40);
        obstacles.add(obstacle0);
        Obstacle obstacle1 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+140);
        obstacles.add(obstacle1);
        Obstacle obstacle2 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+800);
        obstacles.add(obstacle2);
        Obstacle obstacle3 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+1340);
        obstacles.add(obstacle3);
        Obstacle obstacle4 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+1823);
        obstacles.add(obstacle4);
        Obstacle obstacle5 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+2159);
        obstacles.add(obstacle5);
        Obstacle obstacle6 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+2259);
        obstacles.add(obstacle6);
        Obstacle obstacle7 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+2435);
        obstacles.add(obstacle7);
        Obstacle obstacle8 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+3000);
        obstacles.add(obstacle8);
        Obstacle obstacle9 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+3200);
        obstacles.add(obstacle9);
        Obstacle obstacle10 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+3400);
        obstacles.add(obstacle10);
        Obstacle obstacle11 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+3600);
        obstacles.add(obstacle11);
        Obstacle obstacle12 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+3900);
        obstacles.add(obstacle12);
        Obstacle obstacle13 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+4134);
        obstacles.add(obstacle13);
        Obstacle obstacle14 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+4300);
        obstacles.add(obstacle14);
        Obstacle obstacle15 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+4500);
        obstacles.add(obstacle15);
        Obstacle obstacle16 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+4900);
        obstacles.add(obstacle16);
        Obstacle obstacle17 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+5400);
        obstacles.add(obstacle17);
        Obstacle obstacle18 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+5600);
        obstacles.add(obstacle18);
        Obstacle obstacle19 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+5800);
        obstacles.add(obstacle19);
        Obstacle obstacle20 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+6000);
        obstacles.add(obstacle20);
    }

    public boolean collides(int playerX, int playerY) {

        //loop through the arraylist of obstacles
        //get the x and y and height and width using getters from obstacle
        //do the checks for each obstacle and check if that obstacle is ever in contact with the player
        //x1 y1 and x2 and y2
        //check whether the player has passed an obstacle but only worry about the y2 and x2 sides the other ones will never touch the obstacle
        //

        //        Rectangle obstacleBounds = new Rectangle(x, y, width, height);
//        Rectangle playerBounds = new Rectangle(playerX, playerY, 50, 50);
//        return obstacleBounds.intersects(playerBounds);
    }
    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }
    public void actionPerformed(ActionEvent e) {
        // Call move on the player.
        player.move();
        for(int i = 0; i<NUM_OBSTACLES; i++){
            Obstacle obstacle = obstacles.get(i);
            obstacle.move();
            if(collides(player.getX(), player.getY())){
              gameOver = true;
            }

        }
        // Update the window.
        window.repaint();
    }

    public void playGame(){
        window.repaint();
    }

    public void updatePercentage(){

    }
    public void updateDeaths() {

    }


    public static void main(String[] args) {
        //Make game object to call the methods in the game class
        Game game = new Game();

        game.playGame();
    }

}

