import java.awt.event.MouseEvent;

public class QuitButton extends CustomButton {
  
  public QuitButton (int width, int height){
    super ("Quit", width, height);
  }
  
  @Override
  public void mouseClicked (MouseEvent e){
    setPath (3);
  }
}
    