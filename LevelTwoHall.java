import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.02.19
 */
public class LevelTwoHall extends LevelFramework {
  
  Images friendSprite;
  Images background;
  Images text;
  
  int friendX;
  int fromWhere;
  
  /**
   * @param fromWhere is an integer representation of where the player came from. If fromWhere = 1, the player is from 
   *        the math class. Otherwise, the player came from outside.
   */
  public LevelTwoHall (int fromWhere){
    
    this.fromWhere = fromWhere;
    
    friendSprite = new Images ("FriendSpriteRev.png",200,200);
    background = new Images ("LevelTwoHallV2.png",8000,750);
 
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    y = -120;
    if (fromWhere != 1){
      text = new Images ("LevelTwoC.png",280,145);
      x = 0;
      friendX = 280;

      layout.putConstraint (layout.WEST, text, -70, layout.EAST, friendSprite);
      layout.putConstraint (layout.SOUTH, text, 50, layout.NORTH, friendSprite);
      add (text);
      
      layout.putConstraint (layout.WEST, friendSprite, friendX, layout.WEST, background);
      layout.putConstraint (layout.SOUTH, friendSprite, -120, layout.SOUTH, this);
      add (friendSprite);
    }
    else {
      text = new Images ("LevelTwoD.png",280,145);
      x = 1730;
      friendX = 2040;
      
      layout.putConstraint (layout.WEST, text, -70, layout.EAST, friendSprite);
      layout.putConstraint (layout.SOUTH, text, 50, layout.NORTH, friendSprite);
      add (text);
      
      layout.putConstraint (layout.WEST, friendSprite, friendX, layout.WEST, background);
      layout.putConstraint (layout.SOUTH, friendSprite, -120, layout.SOUTH, this);
      add (friendSprite);
    }
    
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
      
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  public void actionPerformed (ActionEvent e){
    
    if (friendX < 2040 && fromWhere != 1)
      friendX += 3;
    if (friendX < 3440 && fromWhere == 1)
      friendX += 3;
    
    x += dx;
    y += dy;
    update ();
  }
  
  public void keyPressed (KeyEvent e){
    int c = e.getKeyCode();
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 7; //change back to 3
    }
    if (c == KeyEvent.VK_E && x >= 0 && x <= 150){
      menuButton.setPath (5);
    }
    if (c == KeyEvent.VK_E && x >=1730 && x <= 1950){
      menuButton.setPath (9);
    }
    if (c == KeyEvent.VK_E && x >=3140 && x <= 3370){
      menuButton.setPath (10);
    }
    
  }
  
  public void keyReleased (KeyEvent e){
    if (dy == 0)
      dx = 0;
  }
  
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, friendSprite, friendX, layout.WEST, background);
    layout.putConstraint (layout.SOUTH, friendSprite, -120, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    
    refresh ();
  }
  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}