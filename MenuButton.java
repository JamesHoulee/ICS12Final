import java.awt.event.MouseEvent;

/**
 * The MenuButton class is a subclass of CustomButton. This class creates a button
 * with specified dimensions and a set label of "Main Menu". It also overrides
 * the moouseClicked method to set the path variable to equal -999.
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.28.19
 */
public class MenuButton extends CustomButton {
  
  /**
   * This is the constructor for the MenuButton class. It uses the superclass's
   * constructor to instantiate a new button.
   * 
   * @param width holds the width of the button
   * @param height holds the height of the button
   */
  public MenuButton (int width, int height){
    super ("Main Menu", width, height);
  }
  
  /**
   * The mouseClicked method sets the path variable to equal -999 when the button 
   * is clicked.
   * 
   * @param e is an object of the MouseEvent class
   */
  @Override
  public void mouseClicked (MouseEvent e){
    setPath (-999);
  }
}
    