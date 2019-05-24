import java.awt.event.MouseEvent;

public class InfoButton extends CustomButton {
  
  public InfoButton (int width, int height){
    super ("Instructions", width, height);
  }
  
  @Override
  public void mouseClicked (MouseEvent e){
    setPath (2);
  }
}
    