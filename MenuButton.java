import java.awt.event.MouseEvent;
import java.awt.*; 

/**
 * The MenuButton class is a subclass of CustomButton. This class creates a button
 * with specified dimensions and a set label of "Main Menu". It also overrides
 * the moouseClicked method to set the path variable to equal -999.
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.28.19
 */
public class MenuButton extends CustomButton {
  
  /**
   * This is the constructor for the MenuButton class. It uses the superclass's
   * constructor to instantiate a new button.
   * 
   * @param width holds the width of the button
   * @param height holds the height of the button
   */
  public MenuButton (int width, int height){
    super ("Main Menu", width, height);
  }
  
  /**
   * 
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (click) {
      g.setColor(new Color (217,217,219));
      g.fillRect(0, 0, sizeX, sizeY);  
    }
    else if (hover) {
      g.setColor(new Color (143,144,145));
      g.fillRect(0, 0, sizeX, sizeY);
    }
    else {
      g.setColor(new Color (177,178,181));
      g.fillRect(0, 0, sizeX, sizeY);
    }
    
    g.setColor(Color.WHITE);
    g.setFont(Font.decode("arial-BOLD-20"));
    FontMetrics metrics = g.getFontMetrics();
    int width = metrics.stringWidth(text);
    g.drawString(text, sizeX/2 - width / 2, 29); // xSize/2 , size/2
  }  
  /**
   * The mouseClicked method sets the path variable to equal -999 when the button 
   * is clicked.
   * 
   * @param e is an object of the MouseEvent class
   */
  @Override
  public void mouseClicked (MouseEvent e){
    setPath (-999);
  }
}
    