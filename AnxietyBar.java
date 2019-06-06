import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

/**
 * The AnxietyBar class is a subclass of the JPanel class. It creates a bar that 
 * represents the anxiety level of the player's character throughout the game.
 * It displays a red rectangle within a black rectangle. The percent that the 
 * rectangle is filled shows the percent of the character's anxiety level.
 * 
 * <p>
 * <b>Instance Variable: </b>
 * <p>
 * <b>anxietyPercent </b> This is an integer representation of the character's 
 *                        anxiety percentage from values 0 - 100.
 * @author James Houle and Juan Diego Castano
 * @version 1 05.28.2019
 */
public class AnxietyBar extends JPanel{
  
  private static int anxietyPercent;
  
  /**
   * This is the constructor for the AnxietyBar class. It sets the value of the
   * anxietyPercent variable.
   * 
   * @param percent This variable is the value that anxietyPercent will be set to
   */
  public AnxietyBar (){
  }

  /**
   * The getPreferredSize method returns the dimensions for the anxietyBar when it is
   * on screen.
   * 
   * @return the dimensions of the anxiety bar
   */
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    return new Dimension(136,41);
  }
    
  /**
   * The paintComponent method draws a 135 by 40 rectangle. It then sets the color to
   * be red and fills a rectangle within the black rectangle with dimensions according to
   * the percent that is being requested to be filled defined by the anxietyPercent
   * variable.
   * 
   * @param g This is an object of the Graphics class.
   */
  @Override
  public void paintComponent (Graphics g){
    g.drawRect (0,0,135,40);
    g.setColor (Color.RED);
    g.fillRect (1,1,134*anxietyPercent/100,39);
  }
  
  /**
   * The setPercent method changes the percent of the anxiety bar that is being filled
   * 
   * @param percent This variable is the value that anxietyPercent will be set to
   */
  public void setPercent (int percent){
    anxietyPercent = percent;
    if (anxietyPercent < 0)
      anxietyPercent = 0;
  }
  
  public void increasePercent (int increase){
    anxietyPercent += increase;
  }
  
  public static int getPercent (){
    return anxietyPercent;
  }
}