import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame{
    private Game a;
    private Image background;
    private Image icon;

    private Image[] obstacleImages;
    private static final int    WINDOW_WIDTH = 1212,
            WINDOW_HEIGHT = 720;

    public GameViewer(Game a) {
        this.a = a;

        background = new ImageIcon("Resources/geometry dash background.jpeg").getImage();
        icon = new ImageIcon("Resources/icon.png").getImage();

        obstacleImages[0] = new ImageIcon("Resources/square.png").getImage();
        obstacleImages[1] = new ImageIcon("Resources/triangle.png").getImage();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Geometry Dash");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return obstacleImages;
    }





    public void paint(Graphics g) {
        g.drawImage(background, 		// image to draw
                0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, 	// (x, y) of upper left corner in output window and width, height
                this);
        g.fillRect(0,550,WINDOW_WIDTH,25);

        g.drawImage(icon, 25, 50, 50, 50, 	// (x, y) of upper left corner in output window and width, height
                this);

    }


}
