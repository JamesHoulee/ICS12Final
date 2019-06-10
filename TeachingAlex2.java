import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.09.19
 */
public class TeachingAlex2 extends LevelFramework {
 
  Images background;
  Images friendSprite;
  Images firstText;
  Images secondText;
  
  int friendX;
  
  /**
   * 
   */
  public TeachingAlex2 (){
    
    background = new Images ("OutsideSchoolV2.png",2500,750);
    friendSprite = new Images ("FriendSprite.png",200,200);
    firstText = new Images ("LevelThreeQ.png",280,145);
    secondText = new Images ("LevelThreeR.png",280,145);
    
    y = -40;
    friendX = 550;
    time = 0;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    //applies the constraints for the main character's sprite and adds it to the JPanel
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, friendSprite, friendX, layout.WEST, background);
    layout.putConstraint (layout.SOUTH, friendSprite, -80, layout.SOUTH, background);
    add (friendSprite);
    
    //applies the constraints for the first text bubble and adds it to the JPanel
    layout.putConstraint (layout.EAST, firstText, 70, layout.WEST, friendSprite);
    layout.putConstraint (layout.SOUTH, firstText, 50, layout.NORTH, friendSprite);
    add (firstText);
    
    layout.putConstraint (layout.WEST, secondText, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, secondText, 50, layout.NORTH, sprite);
    add (secondText);
    secondText.setVisible (false);
    
    //applies the constraints for the background and adds it to the JPanel
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  @Override
  public void actionPerformed (ActionEvent e){
    time ++;
    
    if (time == 800){
      remove (firstText);
      secondText.setVisible (true);
    }
    if (time == 1100)
      remove (secondText);
    if (time > 800){
      x += dx;
      y += dy;
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
    update ();
  }
  
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
      menuButton.setPath (13);
    }
    
    update ();
    
  }
  
  @Override
  public void keyReleased (KeyEvent e){
    if (dy == 0)
      dx = 0;
  }
  
  @Override
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    
    refresh ();
  }
}
  