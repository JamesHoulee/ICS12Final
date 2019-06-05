import java.awt.event.MouseEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.05.19
 */
public class NextInfoButton extends CustomButton {
  
  public NextInfoButton (int width, int height){
     super ("Next", width, height);
  }
  
  @Override 
  public void mouseClicked (MouseEvent e){
    if (InformationScreen.screen == 1)
      InformationScreen.screen = 2;
    else 
      InformationScreen.screen = 3;
  }
}