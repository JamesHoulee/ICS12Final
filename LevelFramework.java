import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * @author James Houle and Juan Diego Castano 
 * @version 1 06.08.19
 */
public abstract class LevelFramework extends JPanel implements ActionListener, KeyListener {
  
  Images sprite;
  SpringLayout layout;
  
  AnxietyBar anxietyBar;
  MenuButton menuButton;
  Inventory inventory;
  
  Timer timer;
  int x,y,dx,dy;
  int time;
  
  public LevelFramework (){
    sprite = new Images ("AlexSmile.png",200,200);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    anxietyBar = new AnxietyBar ();
    menuButton = new MenuButton (135,40);
    inventory = new Inventory ();
    
    timer = new Timer (5, this);
    
    dx = 0;
    dy = 0;
    
    //applies the constraints for the menu button and adds it to the JPanel
    layout.putConstraint (layout.EAST, menuButton, 0, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    add (menuButton);
    
    //applies the constraints for the anxiety bar and adds it to the JPanel
    layout.putConstraint (layout.WEST, anxietyBar, 25, layout.WEST, this);
    layout.putConstraint (layout.NORTH, anxietyBar, 10, layout.NORTH, this);
    add (anxietyBar);
    
    layout.putConstraint (layout.SOUTH, inventory, 115, layout.SOUTH, this);
    layout.putConstraint (layout.WEST, inventory, 0, layout.WEST, this);
    add (inventory); 
    
    add (sprite);
  }
  
  public abstract void actionPerformed (ActionEvent e);
  
  public abstract void keyPressed (KeyEvent e);
  
  public void keyTyped (KeyEvent e){}
  
  public abstract void keyReleased (KeyEvent e);
  
  public abstract void update ();
  
  public void refresh (){
    repaint ();
    revalidate ();
  }
}
                          
    
    
    
    