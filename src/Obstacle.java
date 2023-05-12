/**
 * Geometry Dash - Final Project
 * @author: Lucas Ying
 * @version: 5/12/23
 * Class: Obstacle
 */
import java.awt.*;

public class Obstacle {
    private int x;
    private final int y;
    private final int dx;
    private final int height;
    private final int width;
    private static final int SPEED = 8;

    private static final int    WINDOW_WIDTH = 1212,
            WINDOW_HEIGHT = 720;
    private final GameViewer viewer;
    private final Image image;

    public Obstacle(GameViewer viewer, Image image, int x){
        this.viewer = viewer;
        this.image = image;
        this.x = x;
        this.y = 500;
        this.dx = SPEED;
        this.height = image.getHeight(viewer);
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
    public int getY2() { return y+height; }
    public int getHeight() { return height; }
    public int getWidth() { return width; }

    // Moves the obstacle to the left by dx
    public void move(){
        x = x-dx;
    }
    public void draw(Graphics g) {
        g.drawImage(image,x,y,viewer);
    }
}
