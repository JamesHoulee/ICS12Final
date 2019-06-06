import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class AlexRoom extends JPanel implements ActionListener, KeyListener { //have to fix the boundaries for picking up the pencil case
  
  Images sprite;
  Images background;
  SpringLayout layout;
  Inventory inventory;
  
  Timer timer = new Timer(5,this);
  
  int x,y,dx,dy;
  
  MenuButton menuButton;
  
  AnxietyBar anxietyBar;
  
  public AlexRoom (){

    sprite = new Images ("AlexSmile.png",200,200);
    background = new Images ("AlexRoomV1.png",1000,750);
    
    x = 400;
    y = 20;
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
    
    inventory = new Inventory ();
    menuButton = new MenuButton (135,40);
    anxietyBar = new AnxietyBar ();
    
    //applies the constraints for the menu button and adds it to the JPanel
    layout.putConstraint (layout.EAST, menuButton, 25, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    add (menuButton);
    
    //applies the constraints for the anxiety bar and adds it to the JPanel
    layout.putConstraint (layout.WEST, anxietyBar, 25, layout.WEST, this);
    layout.putConstraint (layout.NORTH, anxietyBar, 10, layout.NORTH, this);
    add (anxietyBar);
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    add (sprite);
                          
    layout.putConstraint (layout.SOUTH, inventory, 115, layout.SOUTH, this);
    layout.putConstraint (layout.WEST, inventory, 0, layout.WEST, this);
    add (inventory);
    
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
    
    update();
    
    x = x + dx;
    y = y + dy;
    
    repaint();  
  }
  
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, background);
    
    refresh ();
  }
  
  public void refresh (){ //put override?
    repaint ();
    revalidate ();
  }
  
  public void keyPressed (KeyEvent e){ //put override?
    int c = e.getKeyCode();
    
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W){
      dy = -3;
    }
    if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S){
      dy = 3;
    }
    if (c == KeyEvent.VK_E && (x >= 380 && x <= 430 && y > -50)){
      menuButton.setPath (4);
    }
    if (c == KeyEvent.VK_E && x >= 400 && x <= 440 && y <=-450)
      inventory.setPencilCase (true);
    update ();
  }
  
  public void keyTyped (KeyEvent e){} //put override?
  
  public void keyReleased (KeyEvent e){ //put override?
    dx = 0;
    dy = 0;
  } 
  
  //temp
  public static void main (String [] args){
     new AnxiousAlex ();
  }
}