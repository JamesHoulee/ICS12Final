import java.awt.event.MouseEvent; 

/**
 * @author James Houle & Juan Diego Castano 
 */
public class LevelThreeButton extends CustomButton{

    public LevelThreeButton (int width, int height){
        super ("Level Three", width, height);
      }
      
      @Override
      public void mouseClicked (MouseEvent e){
        setPath(6);
      }
}