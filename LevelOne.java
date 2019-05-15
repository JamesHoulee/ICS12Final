import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SpringLayout;

public class LevelOne extends JPanel implements ActionListener, KeyListener {
  
  DrawSprite sprite = new DrawSprite (Color.BLACK);
  SpringLayout layout;
  
  Timer timer = new Timer(5,this);
  int x = 0, y = 0, dx = 0, dy = 0;
  
  public LevelOne (){
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    setVisible (true);
    layout = new SpringLayout ();
    setLayout (layout);
    
    layout.putConstraint (layout.WEST, sprite, 100, layout.WEST, this);
    layout.putConstraint (layout.NORTH, sprite, 300, layout.NORTH, this);
    add (sprite);
  }
  
  @Override
  public void paintComponent (Graphics g){
    super.paintComponent (g);
    g.setColor (Color.RED);
    g.fillRect (-x, 450, 1000,100);
    g.setColor (Color.blue);
    g.fillRect (-x+1000,450,1000,100);
    g.setColor (Color.LIGHT_GRAY);
    g.fillRect (-x,0,1000,450);
    g.setColor (Color.DARK_GRAY);
    g.fillRect (-x + 1000, 0, 1000, 450);
    

  }
  
  public void actionPerformed (ActionEvent e){
    if (x < 0){
      dx = 0;
      x = 0;
    }
    if (x > 1200){
      dx = 0;
      x = 1200;
    }
    if (dy == -2 && y < -200){
      dy = 2;
      y = -200;
    }
    if (dy == 2 && y > 0){
      dy = 0;
      y = 0;
      dx = 0;
    }
    
    update();
    
    x = x + dx;
    y = y + dy;
    repaint();
  }
  
  public void update (){
    layout.putConstraint (layout.NORTH, sprite, 300+y, layout.NORTH, this);
    layout.putConstraint (layout.WEST, sprite, 100, layout.WEST, this);
    
    refresh();
  }
  
  public void refresh (){
      repaint ();
      revalidate ();
    }
  
  @Override
  /*public Dimension getPreferredSize() {
    return new Dimension(20 + 2 * x, 20 + 2 * y);
  }*/
  
  /**
   * @source https://www.youtube.com/watch?v=Km81XyczqC4
   */
  public void keyPressed (KeyEvent e){
    int c = e.getKeyCode();
    
    if (c == KeyEvent.VK_LEFT) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT){
      dx = 3;
    }
    if (c == KeyEvent.VK_UP && y == 0){
      dy = -2;
      update();
    }
   /* if (c == KeyEvent.VK_DOWN){
      dy = 2;
    } */
  }
  
  public void keyTyped (KeyEvent e){}
  public void keyReleased (KeyEvent e){
    if (dy == -2 || dy == 2){
      if (dx == -3)
        dx = -3;
      else if (dx == 3)
        dx = 3;
    }
    else 
      dx = 0;
  }
  
}