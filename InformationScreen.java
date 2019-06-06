import javax.swing.JPanel; 
import javax.swing.SpringLayout;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class InformationScreen extends JPanel {
  
  MenuButton menuButton;
  Images info1;
  Images info2;
  Images info3;
  
  SpringLayout layout;
  NextInfoButton next;
  
  static int screen;
  
  public InformationScreen (){
    
    menuButton = new MenuButton (135,40);
    info1 = new Images ("Info1.png",1000,750);
    info2 = new Images ("Info2.png",1000,750);
    info3 = new Images ("Info3.png",1000,750);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    next = new NextInfoButton (135,40);
    
    screen = 1;
    
    //applies the constraints for the menu button and adds it to the JPanel
    layout.putConstraint (layout.EAST, menuButton, 0, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    
    layout.putConstraint (layout.EAST, next, 0, layout.EAST, this);
    layout.putConstraint (layout.NORTH, next, 10, layout.NORTH, this);
    add (next);
    
    layout.putConstraint (layout.WEST, info1, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, info1, 0, layout.SOUTH, this);
    add (info1);
    info1.setVisible (false);
    
    layout.putConstraint (layout.WEST, info2, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, info2, 0, layout.SOUTH, this);
    add (info2);
    info2.setVisible (false);
    
    layout.putConstraint (layout.WEST, info3, 0, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, info3, 0, layout.SOUTH, this);
    add (info3);
    info3.setVisible (false);
  }
  
  public void checkScreen (){
    if (screen == 1){
      info1.setVisible (true);
      repaint ();
    }
    if (screen == 2){
      info1.setVisible (false);
      info2.setVisible (true);
      repaint ();
    }
    if (screen == 3){
      info2.setVisible (false);
      info3.setVisible (true);
      repaint ();
      remove (next);
      add (menuButton);
    }
  }
  
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}