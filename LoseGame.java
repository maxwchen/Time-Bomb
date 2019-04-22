
/**
 * Write a description of class LoseGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.applet.*;


public class LoseGame extends JFrame//this is the frame that appears when the player loses the game
{
    private ImageIcon image;
    private JFrame frame;
    private JPanel panel;
    public LoseGame()//constructs a new game losing screen
    {
        setSize(1280,760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().removeAll();

        JPanel keyPanel1 = new JPanel(); //Main Panel
        keyPanel1.setLayout(new BorderLayout()); //Layout of Main

        ImageIcon icon = new ImageIcon("lose.jpg"); //imports lose game image
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);

        keyPanel1.add(thumb, BorderLayout.CENTER);
        add(keyPanel1);


    }

    
}
