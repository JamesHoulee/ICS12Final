import java.awt.event.MouseEvent;
import java.awt.*; 

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.05.19
 */
public class NextInfoButton extends CustomButton {
  
  public NextInfoButton (int width, int height){
     super ("Next", width, height);
  }
  
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
  
  @Override 
  public void mouseClicked (MouseEvent e){
    if (InformationScreen.screen == 1)
      InformationScreen.screen = 2;
    else 
      InformationScreen.screen = 3;
  }
}