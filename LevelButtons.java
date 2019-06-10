import java.awt.event.MouseEvent; 

/**
 * This class is responsible for creating the three buttons on the PlayScreen that 
 * direct the user to the appropriate level. 
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b> path </b> This variable is responsbile for storing the approprate path of the button created. 
 * <p>
 * @author James Houle & Juan Diego Castano 
 */
public class LevelButtons extends CustomButton{
  private int path; 
  /**
   * This the the classes constructor, and creates the instance of the level buttons. 
   * 
   * @param buttonText stores the text that will be on the button 
   * @param width stores the width of the 
   * @param height stores the height of the button 
   * 
   * */
  public LevelButtons (int width, int height, String buttonText, int path){
    super (buttonText, width, height);
    this.path = path; 
  }
  /*
   * This method is responsible for selecting the path (ie. where the user will be taken 
   * upon being clicked). 
   */
  @Override
  public void mouseClicked (MouseEvent e){
    setPath(path); 
  }
}