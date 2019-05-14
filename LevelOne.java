import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class LevelOne extends JPanel implements ActionListener, KeyListener {
  
  Timer timer = new Timer(5,this);
  int x = 0, y = 0, dx = 0, dy = 0;
  
  public LevelOne (){
    
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    
    JFrame frame = new JFrame ("Level One");
    frame.add (this);
    frame.setVisible (true);
    frame.setSize (800,550);
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
    g.setColor (Color.BLACK);
    g.fillRect (20,20,100,100);
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
    
    x = x + dx;
    y = y + dy;
    repaint();
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(20 + 2 * x, 20 + 2 * y);
  }
  
  public void keyPressed (KeyEvent e){
    int c = e.getKeyCode();
    
    if (c == KeyEvent.VK_LEFT) {
      dx = -3;
      dy = 0;
    }
    if (c == KeyEvent.VK_RIGHT){
      dx = 3;
      dy = 0;
    }
    if (c == KeyEvent.VK_UP){
      dx = 0;
      dy = -3;
    }
    if (c == KeyEvent.VK_DOWN){
      dx = 0;
      dy = 3;
    }
  }
  
  public void keyTyped (KeyEvent e){}
  public void keyReleased (KeyEvent e){
    dx = 0; 
    dy = 0;
  }
  
}