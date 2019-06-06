import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Thread;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class EnglishClass extends ClassRoom implements ActionListener{
  
  double increasePercent;
  
  public EnglishClass (){
    increasePercent = (double)(anxietyBar.getPercent ());
    System.out.println ("Please come to the front of the class to do your speach, Alex");
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
      }
      catch (Exception e){}
      anxietyBar.increasePercent (4);//change the number
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
  
    