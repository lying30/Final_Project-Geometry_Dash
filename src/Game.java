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

        // Creates each obstacle in its unique spot and unique shape
        // And adds it to the ArrayList of obstacles
        // Not done in a loop so the level stays the same every time
        Obstacle obstacle0 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+40);
        obstacles.add(obstacle0);
        Obstacle obstacle1 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+40);
        obstacles.add(obstacle1);
        Obstacle obstacle2 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+800);
        obstacles.add(obstacle2);
        Obstacle obstacle3 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+1340);
        obstacles.add(obstacle3);
        Obstacle obstacle4 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+1823);
        obstacles.add(obstacle4);
        Obstacle obstacle5 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+2159);
        obstacles.add(obstacle5);
        Obstacle obstacle6 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+2459);
        obstacles.add(obstacle6);
        Obstacle obstacle7 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+2735);
        obstacles.add(obstacle7);
        Obstacle obstacle8 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+3500);
        obstacles.add(obstacle8);
        Obstacle obstacle9 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+3900);
        obstacles.add(obstacle9);
        Obstacle obstacle10 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+4300);
        obstacles.add(obstacle10);
        Obstacle obstacle11 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+4600);
        obstacles.add(obstacle11);
        Obstacle obstacle12 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+4900);
        obstacles.add(obstacle12);
        Obstacle obstacle13 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+5134);
        obstacles.add(obstacle13);
        Obstacle obstacle14 = new Obstacle(window, window.getImages().get(1), WINDOW_WIDTH+5300);
        obstacles.add(obstacle14);
        Obstacle obstacle15 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+5800);
        obstacles.add(obstacle15);
        Obstacle obstacle16 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+6150);
        obstacles.add(obstacle16);
        Obstacle obstacle17 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+6400);
        obstacles.add(obstacle17);
        Obstacle obstacle18 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+6650);
        obstacles.add(obstacle18);
        Obstacle obstacle19 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+6850);
        obstacles.add(obstacle19);
        Obstacle obstacle20 = new Obstacle(window, window.getImages().get(0), WINDOW_WIDTH+7150);
        obstacles.add(obstacle20);
    }

    // Checks whether the player has collided with a obstacle
    public boolean collides(int playerX, int playerY, int playerHeight, int playerWidth) {
        // Loop through the arraylist of obstacles
        // Check whether the player has collided with an obstacle
        for(int i = 0; i < obstacles.size(); i++){
            // Create variables for the bottom right coordinate of the player
            int playerX2 = playerX+playerWidth;
            int playerY2 = playerY+playerHeight;

            if(checkCollide(playerX, playerX2, i, playerY2)){
                return true;
            }

        }
        return false;
    }

    public boolean checkCollide(int playerX, int playerX2, int i, int playerY2) {
        // If the player is to the right of the obstacle it is not colliding
        if(obstacles.get(i).getX2() < playerX){
            return false;
        }
        // If the player is to the left of the obstacle it is not colliding
        if(obstacles.get(i).getX() > playerX2){
            return false;
        }
        // If the player's Y2 coordinate is lower than the top of the obstacle it is not colliding
        if(playerY2 < obstacles.get(i).getY()){
            return false;
        }
        return true;
    }

    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }
    public void actionPerformed(ActionEvent e) {
        // If the game has started and the player has pressed "a" to start
        if(window.welcome == true) {
            // Call move on the player.
            player.move();
            // Loop through the obstacles
            for (int i = 0; i < NUM_OBSTACLES; i++) {
                Obstacle obstacle = obstacles.get(i);
                // Call move on each obstacle
                obstacle.move();
            }
        }
        // If the player collides with an obstacle
        if (collides(player.getX(), player.getY(), 50, 50)) {
            // Set gameOver to true and return
            gameOver = true;
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

