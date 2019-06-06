import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.06.19
 */
public class TeachingAlex extends JPanel implements ActionListener {
   
  Images sprite;
  Images brotherSprite;
  Images background;
  
  SpringLayout layout;
  
  Timer timer = new Timer (5, this);
  
  public TeachingAlex (){
    
    sprite = new Images ("AlexSmile.png",200,200);
    brotherSprite = new Images ("BigBrother.png",210,200);
    background = new Images ("AlexRoomV1.png", 1000, 750);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    layout.putConstraint (layout.WEST, sprite, 50, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, -200, layout.SOUTH, this);
    add (sprite);
    
    layout.putConstraint (layout.EAST, brotherSprite, -50, layout.EAST, this);
    layout.putConstraint (layout.SOUTH, brotherSprite, -200, layout.SOUTH, this);
    add (brotherSprite);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  public void actionPerformed (ActionEvent e){
    
  }
  
  public void update (){
    
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