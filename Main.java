import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Main extends JPanel {
  
  Images background;
  CustomButton button;
  CustomButton button2;
  CustomButton button3;
  SpringLayout layout;
  
  public Main() {
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    button = new CustomButton("Play", 250, 150);
    button2 = new CustomButton("Instructions", 250, 150);
    button3 = new CustomButton("Quit", 250, 150);
    
    layout.putConstraint (layout.WEST, button, 375, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button, 200, layout.NORTH, this);
    
    layout.putConstraint (layout.WEST, button2, 375, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button2, 360, layout.NORTH, this);
    
    layout.putConstraint (layout.WEST, button3, 375, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button3, 520, layout.NORTH, this);
    
    add(button);
    add(button2);
    add(button3);
    
    background = new Images ("TheAnxiousLifeOfAlexBackground.png",1000,750);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    
    
    add (background);
  }
}