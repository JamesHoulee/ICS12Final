import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class MathClass extends ClassRoom implements ActionListener {
  
  JDialog test;
  static boolean testOpen;
  double increasePercent;
  
  public MathClass (){
    testOpen = false;
    increasePercent = 0.0;
    
    layout.putConstraint (layout.SOUTH, firstMath, 70, layout.NORTH, teacherSprite);
    layout.putConstraint (layout.EAST, firstMath, 75, layout.WEST, teacherSprite);
    firstMath.setVisible (true);
    
    layout.putConstraint (layout.EAST, teacherSprite, -50, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, teacherSprite, -100, layout.SOUTH, this);
    
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
    if (c == KeyEvent.VK_E && x >= 50 && x <= 90 && y >= -20)
      menuButton.setPath (8);
    if (c == KeyEvent.VK_E && x >= 240 && x <= 300 && y <= -120 && y >= -170){
      if (inventory.getPencilCase() == true)
        testOpen = true;
      else {
        anxietyBar.increasePercent (50);
        increasePercent = anxietyBar.getPercent ();
        getPencil ();
      }
    }
  }
  
  public void getPencil (){
    System.out.println ("Here's a pencil");
    testOpen = true;
  }
  
  @Override 
  public void actionPerformed (ActionEvent ae){
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
    
    if (testOpen == true){
      increasePercent += 0.1;
      try {
        Thread.sleep (250);
      }
      catch (Exception e){}
      anxietyBar.setPercent ((int)(increasePercent));
      update ();
    }
    
    update ();
    x += dx;
    y += dy;
    repaint ();
  }
  
  public boolean testOpen (){
    return testOpen;
  }
  
  public static void closeTest (){
    testOpen = false;
  }
  
  //temp
  public static void main (String [] args){
     new AnxiousAlex ();
  }
}
  
    