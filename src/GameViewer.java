import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameViewer extends JFrame implements KeyListener {
    private Game a;
    private Image background;
    private Image icon;
    private Image welcomePage;
    private Image level;
    private Image gameOver;
    private Image square;
    private Image triangle;
    private int x;
    private Player playerClass;
    public boolean welcome;

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
        welcomePage = new ImageIcon("Resources/welcome.jpeg").getImage();
        level = new ImageIcon("Resources/level.jpeg").getImage();


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
    // Key pressed method that takes in keyboard input
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // If the space bar is clicked and the player is back at the ground floor, jump
        if (keyCode == KeyEvent.VK_SPACE && a.getPlayer().getY() == 510) {
            a.getPlayer().jump();
        }
        if(keyCode == KeyEvent.VK_A){
            welcome = true;
        }
        repaint();
    }



    public void paint(Graphics g) {
        // Draw the welcome page
        g.drawImage(welcomePage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.green);
        g.drawString("PRESS A TO START!!!", WINDOW_WIDTH/2, WINDOW_HEIGHT/2 + 225);
        // If the player has clicked "a"
        if(welcome != false) {
            // Draw background
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.setColor(Color.black);
            g.fillRect(0, 560, WINDOW_WIDTH, 25);

            // If the player isn't null draw it
            if (a.getPlayer() != null) {
                a.getPlayer().draw(g);
            }

            // Draw each obstacle in the Array List
            if (a.getObstacles() != null) {
                for (int i = 0; i < a.NUM_OBSTACLES; i++) {
                    a.getObstacles().get(i).draw(g);
                }
            }

            // If the game is over because they have lost, then draw the game over screen
            if (a.isGameOver() == true) {
                g.drawImage(gameOver, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            }
            // If the game is not over yet and the last obstacle reaches the left side of the screen.
            // Then draw the win screen.
            if(a.isGameOver() == false && a.getObstacles().get(19).getX2() == 0) {
                g.drawImage(level, 0,0, WINDOW_WIDTH, WINDOW_HEIGHT,this);
                g.drawRect(WINDOW_WIDTH/2-80, WINDOW_HEIGHT/2-80, 400,300);
            }


            Toolkit.getDefaultToolkit().sync();
        }
    }


}
