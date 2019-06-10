import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * The LevelOne class is a subclass of LevelFramework. 
 * This class defines the progression of the first level of the game. The player controls a character
 * who moves across a background (the background moves behind the player) while they see how people with social
 * anxiety go through a school day. 
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>background </b> This variable holds the information of an Images object representing the level's background
 * <p>
 * <b>brotherSprite </b> This variable holds the information of an Images object representing the sprite 
 *                       of the character's big brother 
 * <p>
 * <b>friendSprite </b> This variable holds the information of an Images object representing the sprite 
 *                      of the character's friend
 * <p>
 * <b>firstText </b> This variable holds the information of an Images object representing the level's first text bubble
 * <p>
 * <b>secondText </b> This variable holds the information of an Images object representing the level's second text bubble
 * <p>
 * <b>fromWhere <b> This variable is an integer representation of where the player came from.
 * <p>
 * <b>anxietyCheck </b> This variable represents whether or not the player has reached the first anxiety increase checkpoint
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.30.19
 */ 
public class LevelTwoOutside extends LevelFramework {

  private Images background;
  private Images brotherSprite;
  private Images friendSprite;
  private Images firstText;
  private Images secondText;
  private Images card;
  
  private int fromWhere;
  private boolean anxietyCheck;
  
  /**
   * This is the constructor for the LevelTwoOutside class. It instantiates all required objects and sets the constraints
   * for all on screen objects. The constraints are applied differently depending on where the player is coming from.
   * 
   * @param fromWhere is an integer representation of where the player came from. If fromWhere = 1, the player is from 
   *        the inside the school. Otherwise, the player just started the level.
   */
  public LevelTwoOutside (int fromWhere) {
    
    this.fromWhere = fromWhere;
    
    /**
     * This instantiates a new Images object with a location of "OutsideSchoolV2.png" and dimensions of 
     * 2500 by 750
     */
    background = new Images ("OutsideSchoolV2.png",2500,750);
    /**
     * This instantiates a new Images object with a location of "BigBrother.png" and a dimensions 210 by 200
     */
    brotherSprite = new Images ("BigBrotherRev.png",210,200);
    /**
     * This instantiates a new Images object with a location of "FriendSprite.png" and a dimensions 200 by 200
     */
    friendSprite = new Images ("FriendSprite.png",200,200); 
    /**
     * This instantiates a new Images object with a location of "LevelTwoA.png" and a dimensions 280 by 145
     */
    firstText = new Images ("LevelTwoA.png",280,145);
    /**
     * This instantiates a new Images object with a location of "LevelTwoB.png" and a dimensions 280 by 145
     */
    secondText = new Images ("LevelTwoB.png",280,145);
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    y = -40;
    if (fromWhere != 1){
      x = 0;
      anxietyCheck = false;
      
      card = new Images ("theStruggle.png", 1000, 750);
      add (card);
      sprite.setVisible (false);
      
      //applies the constraints for the first text bubble and adds it to the JPanel
      layout.putConstraint (layout.WEST, firstText, -70, layout.EAST, brotherSprite);
      layout.putConstraint (layout.SOUTH, firstText, 50, layout.NORTH, brotherSprite);
      add (firstText);
      
      //applies the constraints for the second text bubble and adds it to the JPanel
      layout.putConstraint (layout.EAST, secondText, 70, layout.WEST, friendSprite);
      layout.putConstraint (layout.SOUTH, secondText, 50, layout.NORTH, friendSprite);
      add (secondText);
      secondText.setVisible (false);
      
      //applies the constraints for the big brother's sprite and adds it to the JPanel
      layout.putConstraint (layout.WEST, brotherSprite, 10, layout.WEST, background);
      layout.putConstraint (layout.SOUTH, brotherSprite, -40, layout.SOUTH, this);
      add (brotherSprite);
      
      //applies the constraints for the friend's sprite and adds it to the JPanel
      layout.putConstraint (layout.WEST, friendSprite, 1340, layout.WEST, background);
      layout.putConstraint (layout.SOUTH, friendSprite, -120, layout.SOUTH, background);
      add (friendSprite);
      friendSprite.setVisible (false);
    }
    else {
      x = 990;
      anxietyCheck = true;
    }
    
    //applies the constraints for the main character's sprite and adds it to the JPanel
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    //applies the constraints for the background and adds it to the JPanel
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  /**
   * The actionPerformed method defines how the game reacts to a players specific input. This method 
   * defines the boundaries of the game, the movement of the jump, and how the player is allowed to 
   * move around stairs. It also defines the locations of events in the game such as when the anxiety
   * bar has to change, and when and how the non-player characters will move. 
   * 
   * @param e is an object of the ActionEvent class
   */
  @Override
  public void actionPerformed (ActionEvent e){
    if (fromWhere == 1){
      sprite.setVisible (true);
    }
    time ++;
    if (time == 400 && fromWhere != 1){
      remove (card);
      sprite.setVisible (true);
    }
    if (x < 0){
      x = 0;
      dx = 0;
    }
    if (x > 1200){
      x = 1200;
      dx = 0;
    } 
    //defines the jump motion
    if (x < 300){
      if (y < -240){
        y = -240;
        dy = 2;
      }
      if (y > -40){
        y = -40;
        dy = 0;
      }
      if (dy == 0)
        y = -40;
    }
    //first step
    if (x >= 300 && x <= 370 && y <= -80){
      if (y < -280){
        y = -280;
        dy = 2;
      }
      if (y > -80){
        y = -80;
        dy = 0;
      }
      if (dy == 0)
        y = -80;
    }
    //top platform
    if (x >= 370){
      if (y < -320){
        dy = 2;
        y = -320;
      }
      if (y > -120){
        dy = 0;
        y = -120;
      }
    }
    
    //makes friend appear 
    if (x == 666){
      friendSprite.setVisible (true);
      secondText.setVisible (true);
      if (anxietyCheck == false){
        anxietyBar.increasePercent (15);
        anxietyCheck = true;
      }
    }
    
    x += dx;
    y += dy;
    update ();
  }
  
  /**
   * The update method redefines the constraints of any objects that can move or change
   */
  @Override
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    
    if (fromWhere != 1){
      layout.putConstraint (layout.WEST, friendSprite, 1440, layout.WEST, background);
      layout.putConstraint (layout.SOUTH, friendSprite, -120, layout.SOUTH, background);
    }
    
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
    if ((c == KeyEvent.VK_UP || c == KeyEvent.VK_W) && (y == -40 || y == -80)){
      dy = -2;
    }
    if (c == KeyEvent.VK_E && x >= 985 && x <= 1200){
      menuButton.setPath (8);
    }
    
    update ();
  }
  
  /**
   * The keyReleased method defines what happens when the player releases whatever key they were pressing
   * 
   * @param e is a KeyEvent object
   */
  @Override
  public void keyReleased (KeyEvent e){ //put override?
    if (dy == 0)
      dx = 0;
  }
}
  
  
    
  
  
  
  