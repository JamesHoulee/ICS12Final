import java.awt.event.MouseEvent; 

/**
 * @author James Houle & Juan Diego Castano 
 */
public class LevelButtons extends CustomButton{
  private int path; 
  
  public LevelButtons (int width, int height, String buttonText, int path){
    super (buttonText, width, height);
    this.path = path; 
  }
  
  @Override
  public void mouseClicked (MouseEvent e){
    setPath(path); 
  }
}