import java.awt.*;

public class Obstacle {
    private int x;
    private int y;
    private int height;
    private int width;

    private Game game;
    private static final int SPEED = 10;

    private GameViewer viewer;

    private Image square;
    private Image triangle;

    public Obstacle(GameViewer viewer){
        this.viewer = viewer;

        //get the obstacle to move across the screen next.

        square = viewer.getImages()[0];
        triangle = viewer.getImages()[1];

        this.x = 25;
        this.y = 50;
        this.height = viewer.getHeight();
        this.width = viewer.getWidth();

    }

    //Moves the obstacle
    public void jump(){

    }
    //checks to see if the obstacle and player have collided
    public void collide(){

    }


    public void draw(Graphics g) {
        // TODO: Write the Fish's draw() method.

    }
}
