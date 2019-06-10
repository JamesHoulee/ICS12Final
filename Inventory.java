import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

/**
 * 
 * The Inventory Class is responsible for keeping track of the pencil case
 * object.
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>pencilCase</b> This variable stores true if the the pencil case has been
 * picked.
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.29.19
 */
public class Inventory extends JPanel {

  private static boolean pencilCase;

  /**
   * 
   */
  public Inventory() {
  }

  /**
   * This method will return the status of the pencil case
   */
  public static boolean getPencilCase() {
    return pencilCase;
  }

  /**
   * This method will return if alex has the pencil case
   */
  public static void setPencilCase(boolean hasCase) {
    pencilCase = hasCase;
  }

  /**
   * This method will draw the pencil case
   */
  @Override
  public void paintComponent(Graphics g) {
    g.drawRect(1, 1, 100, 80);
    g.drawString ("Inventory:",5,16);
    if (pencilCase == true)
      g.drawString("Pencil Case", 20, 50);

  }

  /**
   * This method will set the size of the pencil case
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }
}