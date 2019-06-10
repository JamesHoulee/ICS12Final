import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * The InformationScreen class is used in order to give the user tips and help
 * on how the game works. It is a simple screen that will give the user a quick
 * rundown on how the game functions and what they must do to be successful.
 * This menu also gives some background on the developers of the project.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>menuButton </b> This variable is responsible for creating the "Menu
 * Button" object
 * <p>
 * <b>info1 </b> This variable holds the information of an Images object that is
 * the first screen of the information screen.
 * <p>
 * <b>info2 </b> This variable holds the information of an Images object that is
 * the first screen of the information screen.
 * <p>
 * <b>info3 </b> This variable holds the information of an Images object that is
 * the first screen of the information screen.
 * <p>
 * <b>layout </b> This variable represents the layout of the JLabel
 * <p>
 * <b> next </b> This variable is responsible for creating the "Next Button"
 * object.
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class InformationScreen extends JPanel {

  private MenuButton menuButton;
  private Images info1;
  private Images info2;
  private Images info3;

  private SpringLayout layout;
  private NextInfoButton next;

  public static int screen;

  /**
   * This method creates the information screen that has images and a button that
   * will allow the user to switch the image when they deem appropriate. On the
   * final image they will be able to go directly to the main menu.
   */
  public InformationScreen() {

    menuButton = new MenuButton(135, 40);
    info1 = new Images("Info1.png", 1000, 750);
    info2 = new Images("Info2.png", 1000, 750);
    info3 = new Images("Info3.png", 1000, 750);

    layout = new SpringLayout();
    setLayout(layout);

    next = new NextInfoButton(135, 40);

    screen = 1;

    // applies the constraints for the menu button and adds it to the JPanel
    layout.putConstraint(layout.EAST, menuButton, 0, layout.EAST, this);
    layout.putConstraint(layout.NORTH, menuButton, 10, layout.NORTH, this);

    layout.putConstraint(layout.EAST, next, 0, layout.EAST, this);
    layout.putConstraint(layout.NORTH, next, 10, layout.NORTH, this);
    add(next);

    layout.putConstraint(layout.WEST, info1, 0, layout.WEST, this);
    layout.putConstraint(layout.SOUTH, info1, 0, layout.SOUTH, this);
    add(info1);
    info1.setVisible(false);

    layout.putConstraint(layout.WEST, info2, 0, layout.WEST, this);
    layout.putConstraint(layout.SOUTH, info2, 0, layout.SOUTH, this);
    add(info2);
    info2.setVisible(false);

    layout.putConstraint(layout.WEST, info3, 0, layout.WEST, this);
    layout.putConstraint(layout.SOUTH, info3, 0, layout.SOUTH, this);
    add(info3);
    info3.setVisible(false);
  }

  /**
   * The checkScreen method is used to direct the user to the correct place when
   * the button is clicked by the user.
   */
  public void checkScreen() {
    if (screen == 1) {
      info1.setVisible(true);
      repaint();
    }
    if (screen == 2) {
      info1.setVisible(false);
      info2.setVisible(true);
      repaint();
    }
    if (screen == 3) {
      info2.setVisible(false);
      info3.setVisible(true);
      repaint();
      remove(next);
      add(menuButton);
    }
  }
}