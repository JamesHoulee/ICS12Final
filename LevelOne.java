import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.SpringLayout;

public class LevelOne extends JPanel implements ActionListener, KeyListener {
   
  Images sprite;
  Images background;
  SpringLayout layout;
  
  Timer timer = new Timer(5,this);
  int x = 0, y = 0, dx = 0, dy = 0;
  
  public LevelOne (){
    
    sprite = new Images ("AlexSmile.png",200,200);
    background = new Images ("BackgroundVersion1.png",8000,750);
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    setVisible (true);
    layout = new SpringLayout ();
    setLayout (layout);
    
    layout.putConstraint (layout.EAST, sprite, 250, layout.WEST, this);
    layout.putConstraint (layout.NORTH, sprite, 450, layout.NORTH, this);
    add (sprite);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    add (background);
  }
  
  public void actionPerformed (ActionEvent e){
    //stops player from leaving boundries
    if (x < 0){
      dx = 0;
      x = 0;
    }
    if (x > 8000){
      dx = 0;
      x = 8000;
    }
    
    //defines the movement of the jump pre/post stairs
    if (x < 1075 || x > 4155){
      if (dy == -2 && y < -200){
        dy = 2;
        y = -200;
      }
      if (dy == 2 && y > 0){
        dy = 0;
        y = 0;
        dx = 0;
      }
    
      if (y == -90 && dy == 0)
        y = 0;
    }
    //Stop the players from walking through the steps
    //Step one
    if (x>1075 && x <=1170){
      if (y == 0){
        dx = 0;
        x = 1075;
      }
      if (y > -90 && x>1075){
        dy = 0;
        y = -90;
      }
      if (dy == -2 && y < -290){
        dy = 2;
        y = -290;
      }
      
      if (x <1170 && y == -180 && dy == 0)
        y = -90;
    }
    //step two
    if (x>1170 && x <= 1265){
      if (y == -90){
        dx = 0;
        x = 1170;
      }
      if (y > -180 && x > 1170){
        dy = 0;
        y = -180;
      }
      if (dy == -2 && y < -380){
        dy = 2;
        y = -380;
      }
      
      if (x < 1265 && y == -270 && dy == 0)
        y = -180;
    }
    //step three
    if (x>1265 && x <=1360){
      if (y == -180){
        dx = 0;
        x = 1265;
      }
      if (y > -270 && x > 1265){
        dy = 0;
        y = -270;
      }
      if (dy == -2 && y < -470){
        dy = 2;
        y = -470;
      }
      
      if (x <1360 && y == -360 && dy == 0)
        y = -270;
    }
    //top
    if (x>1360 && x <3870){
      if (y == -270){
        dx = 0;
        x = 1360;
      }
      if (y > -360 && x > 1360){
        dy = 0;
        y = -360;
      }
      if (dy == -2 && y < -560){
        dy = 2;
        y = -560;
      }
      if (dy == 2 && y >= -365){
        dy = 0;
        y = -360;
        dx = 0;
      }
    }
    
    //going down the stairs
    //first step
    if (x > 3870 && x < 3965){
      y = -270;
    }
    if (x > 3965 && x < 4060){
      y = -180;
    }
    if (x > 4065 && x < 4155){
      y = -90;
    }
    
    
    update();
    
    x = x + dx;
    y = y + dy;
    repaint();
  }
  
  public void update (){
    layout.putConstraint (layout.NORTH, sprite, 450+y, layout.NORTH, this);
    layout.putConstraint (layout.EAST, sprite, 250, layout.WEST, this);
    
    layout.putConstraint (layout.WEST, background, 0-x, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    
    refresh();
  }
  
  public void refresh (){
      repaint ();
      revalidate ();
    }
  
  /**
   * @source https://www.youtube.com/watch?v=Km81XyczqC4
   */
  public void keyPressed (KeyEvent e){
    int c = e.getKeyCode();
    
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    if ((c == KeyEvent.VK_UP || c == KeyEvent.VK_W )&& (y == 0 || y == -90 || y == -180 || y == -270 || y == - 360)){
      dy = -2;
      update();
    }
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