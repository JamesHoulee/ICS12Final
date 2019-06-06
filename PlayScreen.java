import javax.swing.JPanel; 
import javax.swing.SpringLayout;

/**
 *  
 * The PlayScreen class is meant to direct the user to a level chosen by the 
 * user. They have the option to go to Level One, Level Two, and or Level three 
 * as well as to go back to MainMenu
 * 
 * @author James Houle and JuanDiego Castano 
 * @version 1 05.30.19
 */

public class PlayScreen extends JPanel {
  LevelOneButton button; 
  LevelTwoButton button2; 
  LevelThreeButton button3; 
  SpringLayout layout;
  MenuButton backButton; 
  Images background; 
  /**
   * 
   */
  public PlayScreen(){
    
    layout = new SpringLayout (); 
    setLayout (layout); 
    
    button = new LevelOneButton (250,150); 
    button2 = new LevelTwoButton(250,150); 
    button3 = new LevelThreeButton(250,100); 
    backButton = new MenuButton (135,40); 
    // background = new Images ()
    layout.putConstraint (layout.WEST, button, 250, layout.WEST, this); 
    layout.putConstraint (layout.NORTH, button, 100 , layout.NORTH, this);
    add (button);
    
    layout.putConstraint (layout.WEST, button2, 250, layout.WEST, this); 
    layout.putConstraint (layout.NORTH, button2, 250 , layout.NORTH, this);
    add (button2);
    
    layout.putConstraint (layout.WEST, button3, 250, layout.WEST, this); 
    layout.putConstraint (layout.NORTH, button3, 400 , layout.NORTH, this);
    add (button3);
    
    layout.putConstraint (layout.EAST, backButton, 0, layout.EAST, this); 
    layout.putConstraint (layout.SOUTH, backButton, 0 , layout.SOUTH, this);
    add (backButton);
  }
}