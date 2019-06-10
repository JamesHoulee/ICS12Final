import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class EnglishClass extends ClassRoom implements ActionListener{
  
  private Images firstText;
  private static boolean levelComplete;
  private int level, lastBreath;
  private boolean focused;
  private Images [] speech = {new Images ("Speech1.png",280,145), new Images ("Speech2.png",280,145),
    new Images ("Speech3.png",280,145), new Images ("Speech4.png",280,145)};
  
  /**
   * @param level is the level the player is currently in
   */
  public EnglishClass (int level){
    
    background = new Images ("ClassV2.png",1000,750);
    firstText = new Images ("EnglishClassA.png",280,145);
    
    this.level = level;
    lastBreath = -800;
    
    layout.putConstraint (layout.SOUTH, firstText, 70, layout.NORTH, teacherSprite);
    layout.putConstraint (layout.EAST, firstText, 75, layout.WEST, teacherSprite);
    add (firstText);
    
    layout.putConstraint (layout.EAST, teacherSprite, -50, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, teacherSprite, -300, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, speech [0], -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech [0], 50, layout.NORTH, sprite);
    add (speech [0]);
    speech [0].setVisible (false);
    
    layout.putConstraint (layout.WEST, speech [1], -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech [1], 50, layout.NORTH, sprite);
    add (speech [1]);
    speech [1].setVisible (false);
    
    layout.putConstraint (layout.WEST, speech [2], -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech [2], 50, layout.NORTH, sprite);
    add (speech [2]);
    speech [2].setVisible (false);
    
    layout.putConstraint (layout.WEST, speech [3], -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, speech [3], 50, layout.NORTH, sprite);
    add (speech [3]);
    speech [3].setVisible (false);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
  }
  
  @Override
  public void actionPerformed (ActionEvent ae){
    time ++;
    if (x < 750){
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
      x += dx;
      y += dy;
    }
    else if (x >= 750 && level == 3){
      time = 0;
      speech[0].setVisible (true);
      if (time % 75 == 0)
        anxietyBar.increasePercent (5);
      if (time == 800){
        remove (speech[0]);
        speech[1].setVisible (true);
      }
      if (time == 1600){
        remove (speech[1]);
        speech[2].setVisible (true);
      }
      if (time == 2400){
        remove (speech[2]);
        speech[3].setVisible (true);
      }
    }
    else{
      remove (sprite);
      sprite = new Images ("AlexSadFace.png",200,200);
      add (sprite);
      if (time % 75 == 0)
        anxietyBar.increasePercent (4);
    }
    update ();
  }
  
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
    /*if (c == KeyEvent.VK_E && x >= 0 && x <= 80 && y >= -20)
      menuButton.setPath (8); */
    if (c == KeyEvent.VK_C && (time - lastBreath) >= 800){
      anxietyBar.setPercent (anxietyBar.getPercent () - 40);
      lastBreath = time;
    }
    if (c == KeyEvent.VK_F && focused == false){
      anxietyBar.setPercent (0);
      focused = true;
    }
  }
  
  public static boolean levelComplete (){
    return levelComplete;
  }
  
  public static void completeLevel (){ ///REMOVE STATIC
    levelComplete = true;
  }
}
  
    