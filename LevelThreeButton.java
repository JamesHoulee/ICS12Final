import java.awt.even.MouseEvent; 

/**
 * @author James Houle & Juan Diego Castano 
 */
public class LevelThreeButton extends CustomButton{

    public LevelOneButton (int width, int height){
        super ("Level Three", width, height);
      }
      
      @Override
      public void mouseClicked (MouseEvent e){
        setPath(6);
      }
}