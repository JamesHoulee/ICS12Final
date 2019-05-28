import java.awt.even.MouseEvent; 

/**
 * @author James Houle & Juan Diego Castano 
 */
public class LevelTwoButton extends CustomButton{

    public LevelTwoButton (int width, int height){
        super ("Level Two", width, height);
      }
      
      @Override
      public void mouseClicked (MouseEvent e){
        setPath(5);
      }
}