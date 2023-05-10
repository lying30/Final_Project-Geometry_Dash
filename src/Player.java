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
        x = 50;
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
        //subtract my dy over time in move
        dy = 40;

        //boolean is jumping true maybe
    }
    public void move() {
        if(isJumping){
            y = y - dy;
            dy -= GRAVITY;
            if(y >= 510){
                y = 510;
                isJumping = false;
                dy = 0;
            }
        }

    }
    public void die(){

    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, 50, 50, 	// (x, y) of upper left corner in output window and width, height
                viewer);
    }


}
