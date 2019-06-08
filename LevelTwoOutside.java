import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.30.19
 */ 
public class LevelTwoOutside extends LevelFramework {

  Images background;
  Images brotherSprite;
  Images friendSprite;
  Images firstText;
  Images secondText;
  
  int fromWhere;
  
  /**
   * @param fromWhere is an integer representation of where the player came from. If fromWhere = 1, the player is from 
   *        the inside the school. Otherwise, the player just started the level.
   */
  public LevelTwoOutside (int fromWhere) { //maybe add the ability for the player to come back outside??
    
    this.fromWhere = fromWhere;
    
    background = new Images ("OutsideSchoolV2.png",2500,750);
    brotherSprite = new Images ("BigBrotherRev.png",210,200);
    friendSprite = new Images ("FriendSprite.png",200,200); 
    firstText = new Images ("LevelTwoA.png",280,145);
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
      
      layout.putConstraint (layout.WEST, firstText, -70, layout.EAST, brotherSprite);
      layout.putConstraint (layout.SOUTH, firstText, 50, layout.NORTH, brotherSprite);
      add (firstText);
      
      layout.putConstraint (layout.EAST, secondText, 70, layout.WEST, friendSprite);
      layout.putConstraint (layout.SOUTH, secondText, 50, layout.NORTH, friendSprite);
      add (secondText);
      secondText.setVisible (false);
      
      layout.putConstraint (layout.WEST, brotherSprite, 10, layout.WEST, background);
      layout.putConstraint (layout.SOUTH, brotherSprite, -40, layout.SOUTH, this);
      add (brotherSprite);
      
      layout.putConstraint (layout.WEST, friendSprite, 1340, layout.WEST, background);
      layout.putConstraint (layout.SOUTH, friendSprite, -120, layout.SOUTH, background);
      add (friendSprite);
      friendSprite.setVisible (false);
    }
    else {
      x = 990;
    }
    
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  public void actionPerformed (ActionEvent e){
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
      anxietyBar.increasePercent (15);
    }
    
    x += dx;
    y += dy;
    update ();
  }
  
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
  
  @Override
  public void keyPressed (KeyEvent e){ //put override?
    
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
  
  public void keyReleased (KeyEvent e){ //put override?
    if (dy == 0)
      dx = 0;
  }
  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}
  
  
    
  
  
  
  