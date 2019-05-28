import java.awt.event.MouseEvent;

/**
 * The QuitButton class is a subclass of CustomButton. This class creates a button
 * with specified dimensions and a set label of "Quit". It also overrides
 * the mouseClicked method to set the path variable to equal 3.
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.28.19
 */
public class QuitButton extends CustomButton {
  
  /**
   * This is the constructor for the QuitButton class. It uses the superclass's
   * constructor to instantiate a new button.
   * 
   * @param width holds the width of the button
   * @param height holds the height of the button
   */
  public QuitButton (int width, int height){
    super ("Quit", width, height);
  }
  
  /**
   * The mouseClicked method sets the path variable to equal 3 when the button 
   * is clicked.
   * 
   * @param e is an object of the MouseEvent class
   */
  @Override
  public void mouseClicked (MouseEvent e){
    setPath (3);
  }
}
    