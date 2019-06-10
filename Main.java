import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * @author James Houle and JuanDiego Castano 
 * @version 1 ___ 
 */
public class Main extends JPanel {
  
  private Images background;
  public PlayButton button;
  private InfoButton button2;
  private CustomButton button3;
  private SpringLayout layout;
  
  public Main() {
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    button = new PlayButton(250, 150);
    button2 = new InfoButton(250, 150);
    button3 = new QuitButton(250, 150);
    
    layout.putConstraint (layout.WEST, button, 338, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button, 236, layout.NORTH, this);
    
    layout.putConstraint (layout.WEST, button2, 338, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button2, 377, layout.NORTH, this);
    
    layout.putConstraint (layout.WEST, button3, 338, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button3, 517, layout.NORTH, this);
    
    add(button);
    add(button2);
    add(button3);
    
    background = new Images ("TheAnxiousLifeOfAlexBackground.png",1000,750);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    
    add (background);
  }
}