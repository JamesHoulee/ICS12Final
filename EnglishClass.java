import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Thread;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class EnglishClass extends ClassRoom implements ActionListener{
  
  public EnglishClass (){
    
    layout.putConstraint (layout.SOUTH, firstEnglish, 70, layout.NORTH, teacherSprite);
    layout.putConstraint (layout.EAST, firstEnglish, 75, layout.WEST, teacherSprite);
    firstEnglish.setVisible (true);
    
    layout.putConstraint (layout.EAST, teacherSprite, -50, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, teacherSprite, -300, layout.SOUTH, this);
  }
  
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
    
    if (x >= 700){
      try{
        Thread.sleep (250);
        anxietyBar.increasePercent (4);//change the number
      }
      catch (Exception e){}
      
    }
    
    update ();
    x += dx;
    y += dy;
    repaint ();
  }
  
  //temp
  public static void main (String [] args){
     new AnxiousAlex ();
  }
}
  
    