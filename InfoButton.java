import java.awt.event.MouseEvent;

/**
 * The InfoButton class is a subclass of CustomButton. This class creates a button
 * with specified dimensions and a set label of "Instructions". It also overrides
 * the mouseClicked method to set the path variable to equal 2.
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.28.19
 */
public class InfoButton extends CustomButton {
  
  /**
   * This is the constructor for the InfoButton class. It uses the superclass's
   * constructor to instantiate a new button.
   * 
   * @param width holds the width of the button
   * @param height holds the height of the button
   */
  public InfoButton (int width, int height){
    super ("Instructions", width, height);
  }
  
  /**
   * The mouseClicked method sets the path variable to equal 2 when the button 
   * is clicked.
   * 
   * @param e is an object of the MouseEvent class
   */
  @Override
  public void mouseClicked (MouseEvent e){
    setPath (2);
  }
}
    