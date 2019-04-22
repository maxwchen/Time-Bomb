
/**
 * This is our runner class. It serves to opens up the game by creating a new Menu object (JFrame)
 * 
 * @author Nicholas Hoang
 * @version 29 May 2016
 */
import javax.swing.JFrame;
public class Runner
{
    public static void main(String[] args){
        JFrame frame = new Menu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
