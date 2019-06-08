import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.05.19
 */
public abstract class ClassRoom extends LevelFramework {
  
  Images background;
  Images teacherSprite;
  Images firstEnglish;
  
  public ClassRoom (){
    
    teacherSprite = new Images ("TeacherSprite.png",200,200);
    firstEnglish = new Images ("EnglishClassA.png",280,145);
    
    x = 100;
    y = 0;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    add (sprite);
    
    add (teacherSprite);
    
    
    add (firstEnglish);
    firstEnglish.setVisible (false);
    
    update ();
  }
  
  public void actionPerformed (ActionEvent e){
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
    
    update ();
    x += dx;
    y += dy;
    repaint ();
  }
  
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
  }
  
  public void keyReleased (KeyEvent e) {//this is basic fix this
    dx = 0;
    dy = 0;
  }
  
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    refresh ();
  }
  
  public void refresh (){
    repaint ();
    revalidate ();
  }
  
  //temp
  public static void main (String [] args){
     new AnxiousAlex ();
  }
}
  
    
  