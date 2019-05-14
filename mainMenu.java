import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is the main menu for our game. 
 */
public class MainMenu{

    /**
     * 
     */
    public MainMenu (){
        JFrame frame = new JFrame ("The Anxious Life Of Alex Jo"); 
        frame.getContentPane().addMouseListener(new ClickListener())l;        setVisible(true);
        setSize (800,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}