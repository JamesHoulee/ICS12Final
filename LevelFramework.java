import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * The LevelFramework class extends JPanel and implements ActionLister and KeyListener. This class defines how any level
 * created in the game should operate. This includes adding any objects that will always be on screen, and starting 
 * the animations via the Timer class.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>sprite </b> This variable holds the information of an Images object representing the sprite of the main character.
 * <p>
 * <b>layout </b> This variable holds the information of a SpringLayout object for the JPanel's layout.
 * <p>
 * <b>anxietyBar </b> This variable holds the information of an AnxietyBar object representing the player's anxiety bar.
 * <p>
 * <b>menuButton </b> This variable holds the information of a MenuButton object for the menu button
 * <p>
 * <b>inventory </b> This variable holds the information of an Inventory object for the player's inventory
 * <p>
 * <b>timer </b> This variable holds the information of a Timer object
 * <p>
 * <b>x </b> This variable represents the x-coordinate of the player
 * <p>
 * <b>y </b> This variable represents the y-coordinate of the player
 * <p>
 * <b>dx </b> This variable represents the horizontal velocity of the player
 * <p>
 * <b>dy </b> This variable represents the vertical velocity of the player
 * <p>
 * <b>time </b> this variable represents the amount of time since the Timer.start () method was called.
 * 
 * @author James Houle and Juan Diego Castano 
 * @version 1 06.08.19
 */
public abstract class LevelFramework extends JPanel implements ActionListener, KeyListener {
  
  protected Images sprite;
  protected SpringLayout layout;
  
  protected AnxietyBar anxietyBar;
  protected MenuButton menuButton;
  protected Inventory inventory;
  
  protected Timer timer;
  protected int x,y,dx,dy;
  protected int time;
  
  /**
   * This is the constructor for the LevelFramework class. It initializes all of the variables that were declared and
   * sets the layout of the JPanel to be a SpringLayout. It also puts the constraints on all the objects that will 
   * appear on screen.
   */
  public LevelFramework (){
    sprite = new Images ("AlexSmile.png",200,200);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    anxietyBar = new AnxietyBar ();
    menuButton = new MenuButton (135,40);
    inventory = new Inventory ();
    
    timer = new Timer (5, this);
    
    dx = 0;
    dy = 0;
    
    //applies the constraints for the menu button and adds it to the JPanel
    layout.putConstraint (layout.EAST, menuButton, 0, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    add (menuButton);
    
    //applies the constraints for the anxiety bar and adds it to the JPanel
    layout.putConstraint (layout.WEST, anxietyBar, 25, layout.WEST, this);
    layout.putConstraint (layout.NORTH, anxietyBar, 10, layout.NORTH, this);
    add (anxietyBar);
    
    //applies the constraints for the inventory and adds it to the JPanel
    layout.putConstraint (layout.SOUTH, inventory, 115, layout.SOUTH, this);
    layout.putConstraint (layout.WEST, inventory, 0, layout.WEST, this);
    add (inventory); 
    
    add (sprite);
  }
  
  public abstract void actionPerformed (ActionEvent e);
  
  public abstract void keyPressed (KeyEvent e);
  
  public void keyTyped (KeyEvent e){}
  
  public abstract void keyReleased (KeyEvent e);
  
  /**
   * The update method will re-apply the constraints of any objects that move across the screen
   */
  public abstract void update ();
  
  /**
   * The refresh method calls the repaint and revalidate methods.
   */
  public void refresh (){
    repaint ();
    revalidate ();
  }
}
                          
    
    
    
    