import java.awt.event.MouseEvent;

public class PlayButton extends CustomButton {
  
  private int path;
  
  public PlayButton (int width, int height){
    super ("Play", width, height);
  }
  
  @Override
  public void mouseClicked (MouseEvent e){
    path = 1;
  }
  
  public int getPath (){
    return path;
  }
}
    