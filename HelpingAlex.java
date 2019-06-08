import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.08.19
 */
public class HelpingAlex extends LevelFramework {
  
  Images background;
  Images friendSprite1;
  Images friendSprite2;
  Images friendSprite3;
  Images firstText;
  Images secondText;
  Images thirdText;
  int time, lastBreath;
  int friendX;
  boolean inYard;
  
  public HelpingAlex (){
    
    background = new Images ("OutsideSchoolV2.png", 1000, 750);
    friendSprite1 = new Images ("FriendSprite.png", 200, 200);
    friendSprite2 = new Images ("FriendSprite.png", 200, 200);
    friendSprite3 = new Images ("FriendSprite.png", 200, 200);
    
    firstText = new Images ("LevelThreeE.png", 280, 145);
    secondText = new Images ("LevelThreeF.png", 280, 145);
    thirdText = new Images ("LevelThreeG.png", 280, 145);
    
    time = 0;
    lastBreath = -800;
    
    x = 170;
    y = -40;
    friendX  = 400;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    layout.putConstraint (layout.EAST, firstText, 70, layout.WEST, friendSprite1);
    layout.putConstraint (layout.SOUTH, firstText, 50, layout.NORTH, friendSprite1);
    add (firstText);
    
    layout.putConstraint (layout.EAST, secondText, 70, layout.WEST, friendSprite2);
    layout.putConstraint (layout.SOUTH, secondText, 50, layout.NORTH, friendSprite2);
    add (secondText);
    secondText.setVisible (false);
    
    layout.putConstraint (layout.WEST, thirdText, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, thirdText, 50, layout.NORTH, sprite);
    add (thirdText);
    thirdText.setVisible (false);
    
    layout.putConstraint (layout.WEST, friendSprite1, friendX, layout.WEST, background);
    layout.putConstraint (layout.SOUTH, friendSprite1, -40, layout.SOUTH, this);
    add (friendSprite1);
    
    layout.putConstraint (layout.WEST, friendSprite2, 10, layout.EAST, friendSprite1);
    layout.putConstraint (layout.SOUTH, friendSprite2, -40, layout.SOUTH, this);
    add (friendSprite2);
    
    layout.putConstraint (layout.WEST, friendSprite3, 10, layout.EAST, friendSprite2);
    layout.putConstraint (layout.SOUTH, friendSprite3, -40, layout.SOUTH, this);
    add (friendSprite3);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
  }
  
  public void actionPerformed (ActionEvent e){
    time ++;
    if (inYard == false){
      if (time == 800){
        remove (firstText);
        secondText.setVisible (true);
      }
      if (time == 1600){
        remove (secondText);
        thirdText.setVisible (true);
      }
      if (time > 2000){
        remove (thirdText);
        friendX -=3;
      }
      if (time > 2100){
        if (x > 500){
          x = 500;
          dx = 0;
        }
        if (x < 0){
          inYard = true;
          yard ();
        }
        
        x += dx;
        y += dy;
      }
    }
    else {
      if (time % 6 == 0)
        anxietyBar.increasePercent (3);
      
    }
    update ();
  }
  
  public void yard (){
    
    remove (background);
    background = new Images ("TempYard.png",1000,750);
    add (background);
    x = 170;
    remove (friendSprite1);
    remove (friendSprite2);
    remove (friendSprite3);
    update ();
    time = 0;
  }
  
  public void keyPressed (KeyEvent e){ //put override?
    int c = e.getKeyCode();
    
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    /*if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W){
      dy = -3;
    }
    if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S){
      dy = 3;
    }*/
    if (c == KeyEvent.VK_E && (x >= 380 && x <= 430 && y > -50)){
      menuButton.setPath (4);
    }
    if (c == KeyEvent.VK_C && time > 2800 && (time - lastBreath) >= 800){
      anxietyBar.setPercent (anxietyBar.getPercent () - 40);
      lastBreath = time;
    }
    update ();
  }
  
  public void keyReleased (KeyEvent e){ //put override?
    dx = 0;
    dy = 0;
  } 
  
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, friendSprite1, friendX, layout.WEST, background);
    layout.putConstraint (layout.SOUTH, friendSprite1, -40, layout.SOUTH, this);
    
    refresh ();
  }
  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}
    