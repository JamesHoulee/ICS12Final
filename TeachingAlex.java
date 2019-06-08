import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.lang.Thread;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.06.19
 */
public class TeachingAlex extends JPanel implements ActionListener, KeyListener {
   
  Images sprite;
  Images brotherSprite;
  Images background;
  
  SpringLayout layout;
  MenuButton menuButton;
  Inventory inventory;
  AnxietyBar anxietyBar;
  
  Images firstText;
  Images secondText;
  Images thirdText;
  Images fourthText;
  
  Timer timer = new Timer (5, this);
  int x,y,dx,dy;
  int time, lastBreath;
  
  public TeachingAlex (){
    
    sprite = new Images ("AlexSmile.png",200,200);
    brotherSprite = new Images ("BigBrother.png",210,200);
    background = new Images ("AlexRoomV2.png", 1000, 750);
    
    firstText = new Images ("LevelThreeA.png", 280, 145);
    secondText = new Images ("LevelThreeB.png", 280, 145);
    thirdText = new Images ("LevelThreeC.png", 280, 145);
    fourthText = new Images ("LevelThreeD.png", 280, 145);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    menuButton = new MenuButton (135,40);
    inventory = new Inventory ();
    anxietyBar = new AnxietyBar ();
    anxietyBar.setPercent (50);
    
    x = 50;
    y = -200;
    dx = 0;
    dy = 0;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    time = 0;
    lastBreath = -800;
    
    layout.putConstraint (layout.EAST, menuButton, -25, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    add (menuButton);
    
    layout.putConstraint (layout.SOUTH, inventory, 115, layout.SOUTH, this);
    layout.putConstraint (layout.WEST, inventory, 0, layout.WEST, this);
    add (inventory);
    
    //applies the constraints for the anxiety bar and adds it to the JPanel
    layout.putConstraint (layout.WEST, anxietyBar, 25, layout.WEST, this);
    layout.putConstraint (layout.NORTH, anxietyBar, 10, layout.NORTH, this);
    add (anxietyBar);
    
    layout.putConstraint (layout.WEST, sprite, 50, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, -200, layout.SOUTH, this);
    add (sprite);
    
    layout.putConstraint (layout.EAST, brotherSprite, -50, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, brotherSprite, -200, layout.SOUTH, this);
    add (brotherSprite);
    
    layout.putConstraint (layout.WEST, firstText, -70, layout.EAST, sprite);
    layout.putConstraint (layout.SOUTH, firstText, 50, layout.NORTH, sprite);
    add (firstText);
    
    layout.putConstraint (layout.EAST, secondText, 70, layout.WEST, brotherSprite);
    layout.putConstraint (layout.SOUTH, secondText, 50, layout.NORTH, brotherSprite);
    add (secondText);
    secondText.setVisible (false);
    
    layout.putConstraint (layout.EAST, thirdText, 70, layout.WEST, brotherSprite);
    layout.putConstraint (layout.SOUTH, thirdText, 50, layout.NORTH, brotherSprite);
    add (thirdText);
    thirdText.setVisible (false);
    
    layout.putConstraint (layout.EAST, fourthText, 70, layout.WEST, brotherSprite);
    layout.putConstraint (layout.SOUTH, fourthText, 50, layout.NORTH, brotherSprite);
    add (fourthText);
    fourthText.setVisible (false);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  public void actionPerformed (ActionEvent e){
    time ++;
    if (time == 400){
      remove (firstText);
      secondText.setVisible (true);
    }
    if (time == 1200){
      remove (secondText);
      thirdText.setVisible (true);
    }
    if (time == 2000){
      remove (thirdText);
      fourthText.setVisible (true);
    }
    if (time == 2800){
      remove (fourthText);
    }
    if (time > 0) { //put to 2800
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
      
      x = x + dx;
      y = y + dy;
    }
    update ();
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
      menuButton.setPath (11);
    }
    if (c == KeyEvent.VK_C && time > 2800 && (time - lastBreath) >= 800){
      anxietyBar.setPercent (anxietyBar.getPercent () - 40);
      lastBreath = time;
    }
    update ();
  }
  
  public void keyTyped (KeyEvent e){}
  
  public void keyReleased (KeyEvent e){ //put override?
    dx = 0;
    dy = 0;
  } 
  
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, background);
    
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