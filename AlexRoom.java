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
 * @version 1 05.29.19
 */
public class AlexRoom extends JPanel implements ActionListener, KeyListener {
  
  Images sprite;
  Images background;
  SpringLayout layout;
  
  Timer timer = new Timer(5,this);
  
  int x,y,dx,dy;
  
  Main main = new Main ();
  
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
    
    layout.putConstraint (layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    add (sprite);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);

    /*x = 400;
    y = 20;
    dx = 0;
    dy = 0;*/
    
    
    
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
    if (c == KeyEvent.VK_E && (x >= 380 && x <= 620 && y > -250)){
      main.button.setPath (1);
    }
    update ();
  }
  
  public void keyTyped (KeyEvent e){} //put override?
  
  public void keyReleased (KeyEvent e){ //put override?
    dx = 0;
    dy = 0;
  }
  
  //temp
  public static void main (String [] args){
    JFrame frame = new JFrame ("hello");
    AlexRoom room = new AlexRoom ();
    
    frame.setSize (1000,750);
    frame.setVisible (true);
    frame.add (room);
  }
    
}