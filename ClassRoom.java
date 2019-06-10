import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * The ClassRoom class extends LevelFramework. This class defines how any classroom should function.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>background </b> This variable holds the information of an Images object representing the level's background
 * <p>
 * <b>teacherSprite </b> This variable holds the information of an Images object representing the teacher
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.08.19
 */
public abstract class ClassRoom extends LevelFramework {
  
  protected Images background;
  protected Images teacherSprite;
  
  /**
   * This is the constructor for the ClassRoom class. This constructor instatiates all the required images
   * and it sets up the constraints for all the instantiated objects.
   */
  public ClassRoom (){
    
    /**
     * This instantiates a new Images object with a location of "TeacherSprite.png" and a dimensions 200 by 200
     */
    teacherSprite = new Images ("TeacherSprite.png",200,200);
    
    x = 100;
    y = 0;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    //applies the constraints for the main character's sprite and adds it to the JPanel
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    add (sprite);
    
    add (teacherSprite);
    
    update ();
  }
  
  /**
   * The actionPerformed method defines how the game reacts to a players specific input. This method 
   * defines the boundaries of the game. It also defines the locations of events in the game such as when the anxiety
   * bar has to change. 
   * 
   * @param e is an object of the ActionEvent class
   */
  @Override
  public void actionPerformed (ActionEvent e){
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
    
    update ();
    x += dx;
    y += dy;
    repaint ();
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
  }
  
  /**
   * The keyReleased method defines what happens when the player releases whatever key they were pressing
   * 
   * @param e is a KeyEvent object
   */
  @Override
  public void keyReleased (KeyEvent e) {//this is basic fix this
    dx = 0;
    dy = 0;
  }
  
  /**
   * The update method redefines the constraints of any objects that can move or change
   */
  @Override
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    refresh ();
  }
}


