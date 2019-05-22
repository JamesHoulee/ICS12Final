import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.Box;

/**
 * 
 */
public class Main extends JPanel {
  
  public Main() {
    
    this.setBackground(java.awt.Color.DARK_GRAY);
    
    CustomButton button = new CustomButton("Play", 250, 150, 10, 10);
    CustomButton button2 = new CustomButton("Instructions", 250, 150, 10, 10);
    CustomButton button3 = new CustomButton("Quit", 250, 150, 10, 10);
    
    add(button);
    add(button2);
    add(button3);
  }
}