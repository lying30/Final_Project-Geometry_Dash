import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameViewer extends JFrame implements KeyListener {
    private Game a;
    private Image background;
    private Image icon;
    private Image gameOver;
    private Image square;
    private Image triangle;
    private int x;
    private Player playerClass;

    private ArrayList<Image> obstacleImages;
    private static final int    WINDOW_WIDTH = 1212,
            WINDOW_HEIGHT = 720;

    public GameViewer(Game a) {
        this.a = a;
        x = 275;

        obstacleImages = new ArrayList<Image>();

        background = new ImageIcon("Resources/geometry dash background.jpeg").getImage();
        icon = new ImageIcon("Resources/icon.png").getImage();
        gameOver = new ImageIcon("Resources/gameOver.png").getImage();

        square = new ImageIcon("Resources/square.png").getImage();
        triangle = new ImageIcon("Resources/triangle.png").getImage();

        obstacleImages.add(square);
        obstacleImages.add(triangle);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Geometry Dash");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        addKeyListener(this);
        this.setVisible(true);
    }

    public Image getIcon() {
        return icon;
    }

    public ArrayList<Image> getImages() {
        return obstacleImages;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            a.getPlayer().jump();

        }

        repaint();
    }



    public void paint(Graphics g) {
        g.drawImage(background, 		// image to draw
                0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, 	// (x, y) of upper left corner in output window and width, height
                this);
        g.fillRect(0,560,WINDOW_WIDTH,25);


        if(a.getPlayer() != null){
            a.getPlayer().draw(g);
        }

        if(a.getObstacles() != null){
            for(int i = 0; i< a.NUM_OBSTACLES; i++) {
                a.getObstacles().get(i).draw(g);
            }
        }


        if(a.isGameOver() == true){
            g.drawImage(gameOver, 0,0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }


        Toolkit.getDefaultToolkit().sync();
    }


}
