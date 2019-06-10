import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * The teachingAlex class ___________
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b> brotherSprite </b> This variable holds the information of an Images
 * object representing the older brother.
 * <p>
 * <b> background </b> This variable holds the information of an Images object
 * that is the background of this screen.
 * <p>
 * <b> firstText </b> This variable is the first text field that stores an
 * Images object.
 * <p>
 * <b> secondText </b> This variable is the first text field that stores an
 * Images object.
 * <p>
 * <b> thirdText </b> This variable is the first text field that stores an
 * Images object.
 * <p>
 * <b> fourthText </b> This variable is the first text field that stores an
 * Images object.
 * <p>
 * <b> lastBreath </b> Stores the time the user last used breathe ability.
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 06.06.19
 */
public class TeachingAlex extends LevelFramework {

  private Images brotherSprite;
  private Images background;

  private Images firstText;
  private Images secondText;
  private Images thirdText;
  private Images fourthText;

  private int lastBreath;

  /**
   * This is the constructor of the class and is responsible for creating the
   * images and the position of alex, the brother the text and the background.
   */
  public TeachingAlex() {

    brotherSprite = new Images("BigBrother.png", 210, 200);
    background = new Images("AlexRoomV2.png", 1000, 750);

    firstText = new Images("LevelThreeA.png", 280, 145);
    secondText = new Images("LevelThreeB.png", 280, 145);
    thirdText = new Images("LevelThreeC.png", 280, 145);
    fourthText = new Images("LevelThreeD.png", 280, 145);

    anxietyBar.setPercent(50);

    x = 50;
    y = -200;

    // This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    // End of source code

    time = 0;
    lastBreath = -800;

    layout.putConstraint(layout.WEST, sprite, 50, layout.WEST, this);
    layout.putConstraint(layout.SOUTH, sprite, -200, layout.SOUTH, this);

    layout.putConstraint(layout.EAST, brotherSprite, -50, layout.EAST, this);
    layout.putConstraint(layout.SOUTH, brotherSprite, -200, layout.SOUTH, this);
    add(brotherSprite);

    layout.putConstraint(layout.WEST, firstText, -70, layout.EAST, sprite);
    layout.putConstraint(layout.SOUTH, firstText, 50, layout.NORTH, sprite);
    add(firstText);

    layout.putConstraint(layout.EAST, secondText, 70, layout.WEST, brotherSprite);
    layout.putConstraint(layout.SOUTH, secondText, 50, layout.NORTH, brotherSprite);
    add(secondText);
    secondText.setVisible(false);

    layout.putConstraint(layout.EAST, thirdText, 70, layout.WEST, brotherSprite);
    layout.putConstraint(layout.SOUTH, thirdText, 50, layout.NORTH, brotherSprite);
    add(thirdText);
    thirdText.setVisible(false);

    layout.putConstraint(layout.EAST, fourthText, 70, layout.WEST, brotherSprite);
    layout.putConstraint(layout.SOUTH, fourthText, 50, layout.NORTH, brotherSprite);
    add(fourthText);
    fourthText.setVisible(false);

    layout.putConstraint(layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint(layout.SOUTH, background, 0, layout.SOUTH, this);
    add(background);

    update();
  }

  /**
   * The actionPerformed method defines how the game reacts to a players specific
   * input. __________
   * 
   * @param e is an object of the ActionEvent class
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    time++;
    if (time == 400) {
      remove(firstText);
      secondText.setVisible(true);
    }
    if (time == 1200) {
      remove(secondText);
      thirdText.setVisible(true);
    }
    if (time == 2000) {
      remove(thirdText);
      fourthText.setVisible(true);
    }
    if (time == 2800) {
      remove(fourthText);
    }
    if (time > 2800) {
      if (x < 0) {
        x = 0;
        dx = 0;
      }
      if (x > 780) {
        x = 780;
        dx = 0;
      }
      if (y > 0) {
        y = 0;
        dy = 0;
      }
      if (y < -500) {
        y = -500;
        dy = 0;
      }

      x = x + dx;
      y = y + dy;
    }
    update();
  }

  /**
   * The keyPressed method defines how the program will react when certain keys
   * are pressed
   * 
   * @param e is a KeyEvent object
   */
  @Override
  public void keyPressed(KeyEvent e) { // put override?
    int c = e.getKeyCode();

    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D) {
      dx = 3;
    }
    if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W) {
      dy = -3;
    }
    if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S) {
      dy = 3;
    }
    if (c == KeyEvent.VK_E && (x >= 380 && x <= 430 && y > -50)) {
      menuButton.setPath(11);
    }
    if (c == KeyEvent.VK_C && time > 2800 && (time - lastBreath) >= 800) {
      anxietyBar.setPercent(anxietyBar.getPercent() - 40);
      lastBreath = time;
    }
    update();
  }

  /**
   * The keyReleased method defines what happens when the player releases whatever
   * key they were pressing
   * 
   * @param e is a KeyEvent object
   */
  @Override
  public void keyReleased(KeyEvent e) { // put override?
    dx = 0;
    dy = 0;
  }

  /**
   * The update method will re-apply the constraints of any objects that move
   * across the screen
   */
  @Override
  public void update() {

    layout.putConstraint(layout.WEST, sprite, x, layout.WEST, this);
    layout.putConstraint(layout.SOUTH, sprite, y, layout.SOUTH, background);

    refresh();
  }
}