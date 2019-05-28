import java.awt.even.MouseEvent; 


public class LevelOneButton extends CustomButton{

    public LevelOneButton (int width, int height){
        super ("Level One", width, height);
      }
      
      @Override
      public void mouseClicked (MouseEvent e){
        setPath(4);
      }
}