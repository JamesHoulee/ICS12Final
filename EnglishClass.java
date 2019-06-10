import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Thread;

/**
 * ----------------------Writing stuff
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <p>
 * <b>firstText </b> this is an Images object and will drawText in the
 * classroom.
 * <p>
 * <p>
 * <b>levelComplete </b> this variable stores true when the level is complete.
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class EnglishClass extends ClassRoom implements ActionListener {

  private Images firstText;
  private static boolean levelComplete;

  /** 
   * 
   */
  public EnglishClass() {

    background = new Images("ClassV2.png", 1000, 750);
    firstText = new Images("EnglishClassA.png", 280, 145);

    layout.putConstraint(layout.SOUTH, firstText, 70, layout.NORTH, teacherSprite);
    layout.putConstraint(layout.EAST, firstText, 75, layout.WEST, teacherSprite);
    add(firstText);

    layout.putConstraint(layout.EAST, teacherSprite, -50, layout.EAST, this);
    layout.putConstraint(layout.SOUTH, teacherSprite, -300, layout.SOUTH, this);

    layout.putConstraint(layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint(layout.SOUTH, background, 0, layout.SOUTH, this);
    add(background);
  }

  /**
   * The actionPerformed method defines how the game reacts to a players specific
   * input. __________
   * 
   * @param e is an object of the ActionEvent class
   */
  @Override
  public void actionPerformed(ActionEvent ae) {
    time++;
    if (x < 750) {
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
      x += dx;
      y += dy;
      update();
    } else {
      remove(sprite);
      sprite = new Images("AlexSadFace.png", 200, 200);
      add(sprite);
      update();
      if (time % 75 == 0)
        anxietyBar.increasePercent(4);
    }
  }

  /** 
   * 
   */
  public static boolean levelComplete() {
    return levelComplete;
  }

  /** 
   * 
   */
  public static void completeLevel() { /// REMOVE STATIC
    levelComplete = true;
  }
}
