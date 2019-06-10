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
  Images fourthText;
  Images fifthText;
  
  Images speech1;
  Images speech2;
  Images speech3;
  Images speech4;
  Images speech5;
  Images speech6;
  Images speech7;
  
  int time, lastBreath;
  int friendX;
  private static boolean inYard;
  boolean speech;
  
  public HelpingAlex (){
    
    background = new Images ("OutsideSchoolV2.png", 1000, 750);
    friendSprite1 = new Images ("FriendSprite.png", 200, 200);
    friendSprite2 = new Images ("FriendSprite.png", 200, 200);
    friendSprite3 = new Images ("FriendSprite.png", 200, 200);
    
    firstText = new Images ("LevelThreeE.png", 280, 145);
    secondText = new Images ("LevelThreeF.png", 280, 145);
    thirdText = new Images ("LevelThreeG.png", 280, 145);
    fourthText = new Images ("LevelThreeI.png",280,145);
    fifthText = new Images ("LevelThreeH.png", 280,145);
    
    speech1 = new Images ("LevelThreeJ.png",280,145);
    speech2 = new Images ("LevelThreeK.png",280,145);
    speech3 = new Images ("LevelThreeL.png",280,145);
    speech4 = new Images ("LevelThreeM.png",280,145);
    speech5 = new Images ("LevelThreeN.png",280,145);
    speech6 = new Images ("LevelThreeO.png",280,145);
    speech7 = new Images ("LevelThreeP.png",280,145);
    
    time = 0;
    lastBreath = -800;
    speech = false;
    
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
    
    layout.putConstraint (layout.WEST, fourthText, 580, layout.WEST, this);
    layout.putConstraint (layout.NORTH, fourthText, 320, layout.NORTH, this);
    add (fourthText);
    fourthText.setVisible (false);
    
    layout.putConstraint (layout.WEST, fifthText, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, fifthText, 50, layout.NORTH, sprite);
    add (fifthText);
    fifthText.setVisible (false);
    
    layout.putConstraint (layout.WEST, speech1, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech1, 50, layout.NORTH, sprite);
    add (speech1);
    speech1.setVisible (false);
    
    layout.putConstraint (layout.WEST, speech2, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech2, 50, layout.NORTH, sprite);
    add (speech2);
    speech2.setVisible (false);
    
    layout.putConstraint (layout.WEST, speech3, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech3, 50, layout.NORTH, sprite);
    add (speech3);
    speech3.setVisible (false);
    
    layout.putConstraint (layout.WEST, speech4, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech4, 50, layout.NORTH, sprite);
    add (speech4);
    speech4.setVisible (false);
    
    layout.putConstraint (layout.WEST, speech5, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech5, 50, layout.NORTH, sprite);
    add (speech5);
    speech5.setVisible (false);
    
    layout.putConstraint (layout.WEST, speech7, 580, layout.WEST, this);
    layout.putConstraint (layout.NORTH, speech7, 320, layout.NORTH, this);
    add (speech7);
    speech7.setVisible (false);
    
    layout.putConstraint (layout.WEST, speech6, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech6, 50, layout.NORTH, sprite);
    add (speech6);
    speech6.setVisible (false);
    
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
    else if (inYard == true && speech == false){
      x += dx;
      y += dy;
    }
    else {
      if (speech == true){
        if (time < 3000){
          if (time % 100 == 0)
            anxietyBar.increasePercent (4);
        }
        else {
          if (time % 100 == 0)
            anxietyBar.increasePercent (6);
        }
        if (time == 800){
          remove (fifthText);
          speech1.setVisible (true);
        }
        if (time == 1400){
          remove (speech1);
          speech2.setVisible (true);
        }
        if (time == 2200){
          remove (speech2);
          speech3.setVisible (true);
        }
        if (time == 3000){
          remove (speech3);
          speech4.setVisible (true);
        }
        if (time == 3800){
          remove (speech4);
          speech5.setVisible (true);
        }
        if (time == 4600){
          remove (speech5);
          speech6.setVisible (true);
          speech7.setVisible (true);
          speech = false;
        }
      }
    }
    update ();
  }
  
  public void yard (){
    
    fourthText.setVisible (true);
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
    
    if ((c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) && speech == false) {
      dx = -3;
    }
    if ((c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D) && speech == false){
      dx = 3;
    }
    /*if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W){
      dy = -3;
    }
    if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S){
      dy = 3;
    }*/
    if (c == KeyEvent.VK_C && (time - lastBreath) >= 800){
      anxietyBar.setPercent (anxietyBar.getPercent () - 40);
      lastBreath = time;
    }
    if (inYard == true && c == KeyEvent.VK_E){
      speech = true;
      time = 0;
      remove (fourthText);
      fifthText.setVisible (true);
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
  
  public static boolean inYard (){
    return inYard;
  }
  
  public static void leaveYard (){
    inYard = false;
  }
  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}
    