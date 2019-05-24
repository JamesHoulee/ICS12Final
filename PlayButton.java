import java.awt.event.MouseEvent;

public class PlayButton extends CustomButton {
  
  public PlayButton (int width, int height){
    super ("Play", width, height);
  }
  
  @Override
  public void mouseClicked (MouseEvent e){
    setPath(1);
  }
}
    