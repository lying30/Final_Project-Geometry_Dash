import java.awt.*;

public class Player {
    GameViewer viewer;
    private int x;
    private int y;
    private int dy;
    private int height;
    private int width;
    private Image image;
    private boolean isJumping;
    private static final int GRAVITY = 2;
    private static final int    WINDOW_WIDTH = 1212,
            WINDOW_HEIGHT = 720;
    public Player(GameViewer viewer, Image image){
        this.viewer = viewer;
        this.image = image;
        isJumping = false;
        x = 250;
        y = 510;
        height = 50;
        width = 50;
        dy = 0;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void jump(){
        isJumping = true;
        dy = 40;
    }
    public void move() {
        // If player is jumping
        if(isJumping){
            // Slowly decrease the y value and go upwards and eventually downwards again as dy gets negative
            y = y - dy;
            // Decrease amount of change in y
            dy -= GRAVITY;
            // If it is at the ground floor or below
            if(y >= 510){
                // Go to ground floor
                y = 510;
                isJumping = false;
                // Reset change in y to 0 so it doesn't move anymore
                dy = 0;
            }
        }

    }
    public void draw(Graphics g) {
        g.drawImage(image, x, y, 50, 50, viewer);
    }


}
