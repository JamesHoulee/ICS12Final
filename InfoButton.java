import java.awt.event.MouseEvent;

public class InfoButton extends CustomButton {
  
  private int path;
  
  public InfoButton (int width, int height){
    super ("Instructions", width, height);
  }
  
  @Override
  public void mouseClicked (MouseEvent e){
    path = 2;
  }
  
  public int getPath (){
    return path;
  }
}
    