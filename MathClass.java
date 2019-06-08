import javax.swing.JDialog;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class MathClass extends ClassRoom implements ActionListener {
  
  Images firstText;
  Images secondText;
  Images thirdText;
  
  JDialog test;
  static boolean testOpen;
  
  public MathClass (){
    testOpen = false;
    background = new Images ("ClassV2.png",1000,750);
    firstText = new Images ("MathClassA.png",280,145);
    
    layout.putConstraint (layout.SOUTH, firstText, 70, layout.NORTH, teacherSprite);
    layout.putConstraint (layout.EAST, firstText, 75, layout.WEST, teacherSprite);
    add (firstText);
    
    layout.putConstraint (layout.EAST, teacherSprite, -50, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, teacherSprite, -100, layout.SOUTH, this);
    
    if (inventory.getPencilCase () == false){
      secondText = new Images ("MathClassB.png",280,145);
      thirdText = new Images ("MathClassC.png",280,145);
      
      layout.putConstraint (layout.EAST, secondText, 75, layout.WEST, sprite);
      layout.putConstraint (layout.SOUTH, secondText, 50, layout.NORTH, sprite);
      add (secondText);
      secondText.setVisible (false);
      
      layout.putConstraint (layout.SOUTH, thirdText, 70, layout.NORTH, teacherSprite);
      layout.putConstraint (layout.EAST, thirdText, 75, layout.WEST, teacherSprite);
      add (thirdText);
      thirdText.setVisible (false);
    }
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
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
    if (c == KeyEvent.VK_E && x >= 0 && x <= 80 && y >= -20)
      menuButton.setPath (8);
    if (c == KeyEvent.VK_E && x >= 240 && x <= 310 && y <= -35 && y >= -110){
      remove (firstText);
      if (inventory.getPencilCase() == true)
        testOpen = true;
      else {
        getPencil ();
      }
    }
  }
  
  public void getPencil (){
    anxietyBar.increasePercent (50);
    secondText.setVisible (true);
    thirdText.setVisible (true);
    testOpen = true;
  }
  
  @Override 
  public void actionPerformed (ActionEvent ae){
    time ++;
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
    
    if (testOpen == true && (time % 300) == 0){
      anxietyBar.increasePercent (1);
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
  
    