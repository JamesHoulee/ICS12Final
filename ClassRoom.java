import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.05.19
 */
public abstract class ClassRoom extends JPanel implements ActionListener, KeyListener {
  
  Images sprite;
  Images background;
  Images teacherSprite;
  int x,y,dx,dy;
  Timer timer = new Timer (5, this);
  SpringLayout layout;
  
  MenuButton menuButton;
  Inventory inventory;
  AnxietyBar anxietyBar;
  
  Images firstMath;
  Images firstEnglish;
  
  public ClassRoom (){
    
    sprite = new Images ("AlexSmile.png",200,200);
    background = new Images ("ClassV2.png",1000,750);
    teacherSprite = new Images ("TeacherSprite.png",200,200);
    
    firstMath = new Images ("MathClassA.png",280,145);
    firstEnglish = new Images ("EnglishClassA.png",280,145);
    
    x = 100;
    y = 0;
    dx = 0;
    dy = 0;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    menuButton = new MenuButton (135,40);
    inventory = new Inventory ();
    anxietyBar = new AnxietyBar ();
    
    layout.putConstraint (layout.SOUTH, inventory, 115, layout.SOUTH, this);
    layout.putConstraint (layout.WEST, inventory, 0, layout.WEST, this);
    add (inventory);
    
    //applies the constraints for the anxiety bar and adds it to the JPanel
    layout.putConstraint (layout.WEST, anxietyBar, 25, layout.WEST, this);
    layout.putConstraint (layout.NORTH, anxietyBar, 10, layout.NORTH, this);
    add (anxietyBar);
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    add (sprite);
    
    add (teacherSprite);
    
    layout.putConstraint (layout.EAST, menuButton, -25, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    add (menuButton);
    
    add (firstMath);
    firstMath.setVisible (false);
    add (firstEnglish);
    firstEnglish.setVisible (false);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
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
    if (c == KeyEvent.VK_E && x >= 50 && x <= 125 && y >= -20)
      menuButton.setPath (8);
  }
  
  public void keyTyped (KeyEvent e) {}
  
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
  
    
  