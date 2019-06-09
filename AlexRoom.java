import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * The AlexRoom class extends LevelFramework. This class defines the progression as well as the boundaries of Alex's
 * room. The main purpose of the room is for the player to pick up their pencil case before leaving for school.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>background </b> This variable holds the information of an Images object representing the level's background
 * <p>
 * <b>tip </b> This variable holds the information of an Images object representing a tip for the player.
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class AlexRoom extends LevelFramework { //have to fix the boundaries for picking up the pencil case
  
  private Images background;
  private Images tip;
  
  /**
   * This is the constructor for the AlexRoom class. It instantiates all required objects and sets the constraints
   * for all on screen objects.
   */
  public AlexRoom (){
    /**
     * This instantiates a new Images object with a location of "AlexRoomV2.png" and dimensions of 1000 by 750
     */
    background = new Images ("AlexRoomV2.png",1000,750);
    /**
     * This instantiates a new Images object with a location of "AlexRoomTip.png" and dimensions of 225 by 130
     */
    tip = new Images ("AlexRoomTip.png",225,130);
    
    x = 400;
    y = 20;

    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.EAST, tip, 0, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, tip, 0, layout.SOUTH, this);
    add (tip);
                           
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  /**
   * The actionPerformed method defines how the game reacts to a players specific input. This method 
   * defines the boundaries of the game.
   * 
   * @param e is an object of the ActionEvent class
   */
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

    x = x + dx;
    y = y + dy;
    update();;  
  }
  
  /**
   * The update method redefines the constraints of any objects that can move or change
   */
  @Override
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, background);
    
    refresh ();
  }
  
  /**
   * The keyPressed method defines how the program will react when certain keys are pressed
   * 
   * @param e is a KeyEvent object
   */
  @Override
  public void keyPressed (KeyEvent e){
    int c = e.getKeyCode();
    
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W){
      dy = -3;
    }
    if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S){
      dy = 3;
    }
    if (c == KeyEvent.VK_E && (x >= 380 && x <= 430 && y > -50)){
      menuButton.setPath (4);
    }
    if (c == KeyEvent.VK_E && x >= 400 && x <= 440 && y <=-450)
      inventory.setPencilCase (true);
    update ();
  }
  
  /**
   * The keyReleased method defines what happens when the player releases whatever key they were pressing
   * 
   * @param e is a KeyEvent object
   */
  public void keyReleased (KeyEvent e){ //put override?
    dx = 0;
    dy = 0;
  } 
}