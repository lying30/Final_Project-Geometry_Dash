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
        this.x = x;
        this.y = 500;
        this.dx = SPEED;
        this.height = image.getHeight(viewer);;
        this.width = image.getWidth(viewer);

    }

    public int getX() {
        return x;
    }

    public int getX2() {
        return x+width;
    }
    public int getY() {
        return y;
    }
    public int getY2() {
        return y+height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    // Moves the obstacle to the left by dx
    public void move(){
        x = x-dx;
    }

    public void draw(Graphics g) {
        g.drawImage(image,x,y,viewer);
    }
}
