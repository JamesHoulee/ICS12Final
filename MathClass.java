import javax.swing.JDialog;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MathClass class extend ClassRoom and implements ActionListener. This class defines the progression of the math
 * class portion of the second level.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>firstText </b> This variable holds the information of an Images object representing the level's first text bubble
 * <p>
 * <b>secondText </b> This variable holds the information of an Images object representing the level's second text bubble
 * <p>
 * <b>thirdText </b> This variable holds the information of an Images object representing the level's third text bubble
 * <p>
 * <b>test </b> This variable holds the information of a JDialog for the player's test.
 * <p>
 * <b>testOpen </b> This represents whether or not the test is currently open.
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 3 06.08.19
 */
public class MathClass extends ClassRoom implements ActionListener {
  
  private Images firstText;
  private Images secondText;
  private Images thirdText;
  
  private JDialog test;
  private static boolean testOpen;
  
  /**
   * This is the constructor for the MathClass class. This constructor instatiates all the required images
   * and it sets up the constraints for all the instantiated objects. Different objects are instantiated depending
   * on where the player came from.
   */
  public MathClass (){
    testOpen = false;
    background = new Images ("ClassV2.png",1000,750);
    firstText = new Images ("MathClassA.png",280,145);
    
    layout.putConstraint (layout.SOUTH, firstText, 70, layout.NORTH, teacherSprite);
    layout.putConstraint (layout.EAST, firstText, 75, layout.WEST, teacherSprite);
    add (firstText);
    
    layout.putConstraint (layout.EAST, teacherSprite, -50, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, teacherSprite, -100, layout.SOUTH, this);
    
    if (inventory.getPencilCase () == false){
      secondText = new Images ("MathClassB.png",280,145);
      thirdText = new Images ("MathClassC.png",280,145);
      
      layout.putConstraint (layout.EAST, secondText, 75, layout.WEST, sprite);
      layout.putConstraint (layout.SOUTH, secondText, 50, layout.NORTH, sprite);
      add (secondText);
      secondText.setVisible (false);
      
      layout.putConstraint (layout.SOUTH, thirdText, 70, layout.NORTH, teacherSprite);
      layout.putConstraint (layout.EAST, thirdText, 75, layout.WEST, teacherSprite);
      add (thirdText);
      thirdText.setVisible (false);
    }
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
  }
  
  /**
   * The keyPressed method defines how the program will react when certain keys are pressed
   * 
   * @param e is a KeyEvent object
   */
  @Override
  public void keyPressed (KeyEvent e){
    int c = e.getKeyCode ();
    
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A)
      dx = -2;
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D)
      dx = 2;
    if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W)
      dy = -2;
    if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S)
      dy = 2;
    if (c == KeyEvent.VK_E && x >= 0 && x <= 80 && y >= -20)
      menuButton.setPath (8);
    if (c == KeyEvent.VK_E && x >= 240 && x <= 310 && y <= -35 && y >= -110){
      remove (firstText);
      if (inventory.getPencilCase() == true)
        testOpen = true;
      else {
        getPencil ();
      }
    }
  }
  
  /**
   * The getPencil method is used when the player didn't bring their pencil case and needs to get a pencil from their 
   * teacher.
   */
  private void getPencil (){
    anxietyBar.increasePercent (50);
    secondText.setVisible (true);
    thirdText.setVisible (true);
    testOpen = true;
  }
  
  /**
   * The actionPerformed method defines how the game reacts to a players specific input. This method 
   * defines the boundaries of the game. It also defines the locations of events in the game such as when the anxiety
   * bar has to change. 
   * 
   * @param e is an object of the ActionEvent class
   */
  @Override 
  public void actionPerformed (ActionEvent ae){
    time ++;
    if (x < 0){
      x = 0;
      dx = 0;
    }
    if (x > 780){
      x = 780;
      dx = 0;
    }
    if (y > 0){
      y = 0;
      dy = 0;
    }
    if (y < -500){
      y = -500;
      dy = 0;
    }
    
    if (testOpen == true && (time % 300) == 0){
      anxietyBar.increasePercent (3);
    }
    
    update ();
    x += dx;
    y += dy;
    repaint ();
  }
  
  /**
   * The testOpen method is used to get the value of testOpen.
   * 
   * @return testOpen
   */
  public boolean testOpen (){
    return testOpen;
  }
  
  /**
   * The closeTest method is used to change the value of testOpen to false
   */
  public static void closeTest (){
    testOpen = false;
  }
}

