import java.awt.*;
import java.awt.event.KeyListener;

public class Obstacle {
    private int x;
    private int y;
    private int dx;
    private int height;
    private int width;

    private Game game;
    private final int NUM_OBSTACLES = 20;

    private static final int SPEED = 8;

    private static final int    WINDOW_WIDTH = 1212,
            WINDOW_HEIGHT = 720;
    private GameViewer viewer;

    private Image image;

    public Obstacle(GameViewer viewer, Image image, int x){
        this.viewer = viewer;
        this.image = image;
        //get the obstacle to move across the screen next.

        this.x = x;
        this.y = 500;
        this.dx = SPEED;
        this.height = viewer.getHeight();
        this.width = viewer.getWidth();

    }
    //you can have all of the obstacles drawn out already but just drawn past your screen and you cant see them.
    //then you can just call move() on each one and move them over across your screen and through the game.
    // then i can have the player jump over the obstacles as they come through the game.

    //Moves the obstacle
    public void move(){
        x = x-dx;
    }
    //checks to see if the obstacle and player have collided

//
//    public boolean intersects(Rectangle player) {
//        return this.x < player.x + player.width &&
//                this.x + width > player.x &&
//                this.y < player.y + player.height &&
//                this.y + height > player.y;
//    }


    public void draw(Graphics g) {
        g.drawImage(image,x,y,viewer);
    }
}
