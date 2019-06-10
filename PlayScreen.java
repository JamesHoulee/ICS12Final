import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * 
 * The PlayScreen class is meant to direct the user to a level chosen by the
 * user. They have the option to go to Level One, Level Two, and or Level three
 * as well as to go back to MainMenu
 * 
 * @author James Houle and JuanDiego Castano
 * @version 1 05.30.19
 */
public class PlayScreen extends JPanel {
  private LevelButtons button;
  private LevelButtons button2;
  private LevelButtons button3;
  private SpringLayout layout;
  private MenuButton backButton;
  private Images background;

  /**
   * This constructor creates the buttons and the background image of the play
   * screen.
   */
  public PlayScreen() {

    layout = new SpringLayout();
    setLayout(layout);

    button = new LevelButtons(250, 150, "Level One", 4);
    button2 = new LevelButtons(250, 150, "Level Two ", 5);
    button3 = new LevelButtons(250, 150, "Level Three", 6);
    backButton = new MenuButton(135, 40);
    // background = new Images ()
    layout.putConstraint(layout.WEST, button, 375, layout.WEST, this);
    layout.putConstraint(layout.NORTH, button, 100, layout.NORTH, this);
    add(button);

    layout.putConstraint(layout.WEST, button2, 375, layout.WEST, this);
    layout.putConstraint(layout.NORTH, button2, 250, layout.NORTH, this);
    add(button2);

    layout.putConstraint(layout.WEST, button3, 375, layout.WEST, this);
    layout.putConstraint(layout.NORTH, button3, 400, layout.NORTH, this);
    add(button3);

    layout.putConstraint(layout.EAST, backButton, 0, layout.EAST, this);
    layout.putConstraint(layout.SOUTH, backButton, 0, layout.SOUTH, this);
    add(backButton);
  }
}