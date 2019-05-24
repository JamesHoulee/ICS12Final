import java.awt.event.MouseEvent;

public class MenuButton extends CustomButton {
  
  public MenuButton (int width, int height){
    super ("Main Menu", width, height);
  }
  
  @Override
  public void mouseClicked (MouseEvent e){
    setPath (-999);
  }
}
    