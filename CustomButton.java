import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * The CustomButton Class is responsible for creating the buttons in all the
 * screens. It is extended by other classes in order to create the button
 * objects for the appropriate screens, with different text, sizes and colors.
 * 
 * <p>
 * <b> hover </b> This variable will change when the user hovers over the
 * button.
 * <p>
 * <b> click </b> This boolean will change to true if the user clicks the
 * button.
 * <p>
 * <b> text </b> This variable stores the text that will be on the button.
 * <p>
 * <b> sizeX </b> This variable represents height of the button.
 * <p>
 * <b> sizeY </b> This variable represents the width of the button.
 * <p>
 * <b> path </b> This variable will store where the button leads.
 * <p>
 * 
 * @author James Houle & JuanDiego Castano
 * @version 2 06.06.19
 */
public class CustomButton extends JButton implements MouseListener {

  protected boolean hover = false;
  protected boolean click = false;
  protected String text = "";
  protected int sizeX, sizeY;

  protected static int path = -999;

  // public CustomButton (){} I dont think this is needed

  /**
   * This is the constructor for the CustomButton class.
   * 
   * @param text  this variable defines the text on the button.
   * @param sizeX this variable defines the width.
   * @param sizeY this variable defines the height.
   * 
   */
  public CustomButton(String text, int sizeX, int sizeY) {
    setVisible(true);
    setBorderPainted(false);

    this.text = text;
    this.sizeX = sizeX;
    this.sizeY = sizeY;

    addMouseListener(this);
  }

  /**
   * This method will draw the buttons with the specified color and text.
   * 
   * @param g allows _____?
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (click) { // when clicked change the color of the rectangle to :
      g.setColor(new Color(217, 217, 219));
      g.fillRect(0, 0, sizeX, sizeY);
    } else if (hover) {// when user hovers change the color of the rectangle to :
      g.setColor(new Color(143, 144, 145));
      g.fillRect(0, 0, sizeX, sizeY);
    } else {
      g.setColor(new Color(177, 178, 181));
      g.fillRect(0, 0, sizeX, sizeY);
    }

    g.setColor(Color.WHITE);
    g.setFont(Font.decode("arial-BOLD-24"));
    FontMetrics metrics = g.getFontMetrics();
    int width = metrics.stringWidth(text);
    g.drawString(text, sizeX / 2 - width / 2, 85);
  }

  /**
   * This method will redraw the buttons when needed
   */
  public void redraw() {
    this.repaint();
  }

  /**
   * This method will create the dimensions of the buttons based on the parameters
   * passed into the constructor.
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(sizeX, sizeY);
  }

  /**
   * This setter method will set the text for the button.
   */
  public void setButtonText(String text) {
    this.text = text;

  }

  /**
   * This getter method will get the text of the button
   */
  public String getButtonText() {
    return text;
  }

  /**
   * This method will be accessed when the mouse enters the area of a button and
   * it will change the hover variable to true.
   * 
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    hover = true;
  }

  /**
   * The mousePressed method will be accessed when the button is clicked by the
   * user, the variable click will then change accordingly.
   */
  @Override
  public void mousePressed(MouseEvent e) {
    click = true;
  }

  /**
   * This method will be accessed when the mose exits the area of the button and
   * hover will thus be set to false.
   */
  @Override
  public void mouseExited(MouseEvent e) {
    hover = false;
  }

  /**
   * This method will be used when the mouse is released and it will change the
   * click variable to false.
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    click = false;
  }

  /**
   * 
   */
  @Override
  public void mouseClicked(MouseEvent e) {
  }

  /**
   * This method will return the path of the button
   */
  public static int getPath() {
    return path;
  }

  /**
   * This method sets the path that the user will be lead to when the button is
   * clicked
   */
  public void setPath(int newPath) {
    path = newPath;
  }
}