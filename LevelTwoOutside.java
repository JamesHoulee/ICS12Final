import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.JFrame;
/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.30.19
 */ 
public class LevelTwoOutside extends JPanel implements ActionListener, KeyListener {

  Images sprite;
  Images background;
  Images brotherSprite;
  Images friendSprite;
  SpringLayout layout;
  int x,y,dx,dy;
  CustomButton path;
  Timer timer = new Timer(5,this);
  
  public LevelTwoOutside () { //maybe add the ability for the player to come back outside??
    
    sprite = new Images ("AlexSmile.png",200,200);
    background = new Images ("OutsideSchoolV1.png",2000,750);
    brotherSprite = new Images ("BigBrother.png",210,200);
    //friendSprite = new Images ("Friend.png",200,200); need to create friend sprite
    
    x = 0;
    y = -40;
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
        
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    add (sprite);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
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
    
    update ();
    x += dx;
    y += dy;
    repaint ();
  }
  
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    
    refresh ();
  }
  
  public void refresh (){
    repaint ();
    revalidate ();
  }
  
  @Override
  public void keyPressed (KeyEvent e){ //put override?
    
    int c = e.getKeyCode();
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    
    update ();
  }
  
  public void keyTyped (KeyEvent e){} //put override?
  
  public void keyReleased (KeyEvent e){ //put override?
    dx = 0;
    dy = 0;
  }
}
  
  
    
  
  
  
  