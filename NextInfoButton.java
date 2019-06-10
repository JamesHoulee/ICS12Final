import java.awt.event.MouseEvent;
import java.awt.*;

/**
 * 
 * This button will take the user to the next image on the information screen
 * when it is clicked on by the user.
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 06.05.19
 */
public class NextInfoButton extends CustomButton {
  /**
   * This constructor is responsible for creating the nextInfo button.
   * 
   * @param width  stores the width of the button.
   * @param height stores the height of the button.
   */
  public NextInfoButton(int width, int height) {
    super("Next", width, height);
  }

  /**
   * This method overrides the superclass in order to cahnge the color and string
   * size of the button.
   * 
   * @param metrics will get the font metrics of the string.
   * @param width   will store the width of the screen.
   * @param g       ________________
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (click) {
      g.setColor(new Color(217, 217, 219));
      g.fillRect(0, 0, sizeX, sizeY);
    } else if (hover) {
      g.setColor(new Color(143, 144, 145));
      g.fillRect(0, 0, sizeX, sizeY);
    } else {
      g.setColor(new Color(177, 178, 181));
      g.fillRect(0, 0, sizeX, sizeY);
    }

    g.setColor(Color.WHITE);
    g.setFont(Font.decode("arial-BOLD-20"));
    FontMetrics metrics = g.getFontMetrics();
    int width = metrics.stringWidth(text);
    g.drawString(text, sizeX / 2 - width / 2, 29);
  }

  /**
   * This method recognises when the button is clicked and will take the user to
   * the appropriate screen when clicked.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    if (InformationScreen.screen == 1)
      InformationScreen.screen = 2;
    else
      InformationScreen.screen = 3;
  }
}